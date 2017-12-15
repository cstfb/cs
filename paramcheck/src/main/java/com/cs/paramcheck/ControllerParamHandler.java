package com.cs.paramcheck;

import com.cs.paramcheck.Impl.paramdescription.CheckThisDescription;
import com.cs.paramcheck.Impl.parser.DateParamParser;
import com.cs.paramcheck.Impl.parser.IntParamParser;
import com.cs.paramcheck.Impl.parser.StrParamParser;
import com.cs.paramcheck.annotations.CheckThis;
import com.cs.paramcheck.interfaces.ICheckable;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fengbo on 17/10/12.
 * controller参数检查
 *
 * 需要spring IOC以及Spring AOP的支持
 *
 * 示例配置：
 *
 * <aop:config>
 * <aop:aspect id="paramCheckAspect" ref="controllerParamHandler">
 * <!--对controller包下面所有类的所有方法进行代理-->
 * <aop:pointcut id="allController" expression="execution(* com.tqmall.reports.web.controller..*(..))"/>
 * <!--执行参数检查-->
 * <aop:before method="enter" pointcut-ref="allController"/>
 * </aop:aspect>
 * </aop:config>
 *
 * <bean id="controllerParamHandler" class="com.tqmall.reports.biz.paramcheck.ControllerParamHandler"/>
 *
 * todo 可扩展处 ：
 * 1。参数类型的丰富 以及 已有参数类型的丰富
 * 2。异常信息的丰富
 * 3。优化：包括ICheckable复用等等 实际应用中的问题
 *
 */
public class ControllerParamHandler {

    @Autowired
    DateParamParser dateParamParser;
    @Autowired
    IntParamParser intParamParser;
    @Autowired
    StrParamParser strParamParser;

    /**
     * 方法参数缓存注解缓存
     * key : joinPoint.toString()
     * value : IParamDescription[] 下标对应了参数的顺序下标， 因为每个参数只会有一个CheckThis注解， 所以一维数组即可
     */
    private Map<String, CheckThisDescription[]> cache = new ConcurrentHashMap<>();

    /**
     * aop:pointCut入口
     * //MethodSignature.class.cast(joinPoint.getSignature()).getMethod().getParameterAnnotations()
     *
     * 这里解析参数注解，并且根据参数注解检查相应的参数
     * @param joinPoint 织入点
     */
    public void enter(JoinPoint joinPoint){
        String cacheKey = joinPoint.toString();

        CheckThisDescription[] descriptions = cache.get(cacheKey);

        //检查缓存
        if (descriptions == null){
            descriptions = parse(MethodSignature.class.cast(joinPoint.getSignature()).getMethod());
            cache.put(cacheKey, descriptions);
        }

        Object[] args = joinPoint.getArgs();
        //检查参数值
        for (int i = 0; i < descriptions.length; i++) {
            if (descriptions[i] == null)
                continue;

            //检查是否允许空值， 不允许则抛出异常
            if (!descriptions[i].isNullable() && args[i] == null){
                throw new IllegalArgumentException("第" + (i+1) + "个参数无效, 不能为空");
            }

            //检查Date， Int， Str等约束是否满足条件
            ICheckable[] desc = descriptions[i].getDescriptions();
            for (int j = 0; desc != null && j < desc.length; j++) {
                if (desc[j] != null)
                    if (!desc[j].check(args[i]))
                        throw new IllegalArgumentException("第" + (i+1) + "个参数无效");

            }
        }
    }


    /**
     * 解析方法参数@CheckThis注解
     * @param method 要检查的方法签名
     */
    private CheckThisDescription[] parse(Method method){
        //每个参数可能有多个注解
        Annotation[][] ar = method.getParameterAnnotations();
        //每个参数只能有一个CheckThis注解
        CheckThisDescription[] ret = new CheckThisDescription[ar.length];

        Class<CheckThis> annaClass = CheckThis.class;
        //循环每一个注解, 如果是CheckThis注解， 那么解析出对应的参数
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                //检查是否是 CheckThis 注解, 如果是， 那么解析， 并且后面的不必再进行遍历
                if (annaClass.isInstance(ar[i][j])){
                    CheckThis checkThis = (CheckThis)ar[i][j];
                    //是否可以为空
                    boolean nullable = checkThis.nullable();
                    List<ICheckable> descriptions = new ArrayList<>(3);
                    //
                    ICheckable dateParamDescription = dateParamParser.parse(checkThis.dateDesc());
                    if (dateParamDescription != null)
                        descriptions.add(dateParamDescription);
                    //
                    ICheckable intParamDescription = intParamParser.parse(checkThis.intDesc());
                    if (intParamDescription != null)
                        descriptions.add(intParamDescription);
                    //
                    ICheckable strParamDescription = strParamParser.parse(checkThis.strDesc());
                    if (strParamDescription != null)
                        descriptions.add(strParamDescription);

                    // 因为每个参数最多只有一个CheckThis注解， 所以直接赋值即可 , 如果有约束或者要求非空
                    if (descriptions.size() > 0 || !nullable)
                        ret[i] = new CheckThisDescription(new ICheckable[descriptions.size()], nullable);
                    break;
                }
            }
        }

        //
        return ret;
    }
}
