package com.cs.ognl;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import ognl.OgnlParser;

public class Ognl {

    public static void main(String[] args) throws Exception {
        String exp = "param.length()";
        // Object parser = new OgnlParser(new StringReader(exp)).topLevelExpression();

        Object parser = ognl.Ognl.parseExpression(exp);

        Map<String, Object> map = new HashMap<>();
        map.put("param", "hello world");

        Object value = ognl.Ognl.getValue(parser, map);
        System.out.println(value);
    }

}


