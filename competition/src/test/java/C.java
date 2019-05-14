import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.stream.*;

import static java.util.stream.Collectors.toMap;

public class C {
    static class A {
    }

    static class B extends A {
    }

    public static void main(String[] args) {
//        ArrayList<A> list = new ArrayList<A>();
//        list.add(new B());
//        method1(list);
//        ThreadTest.main(new String[]{});

//        ListParamTest.main(new String[]{});

        Test.main(new String[]{});
    }

    private static void method1(List<? extends A> list) {
        for (int i = 0; i < list.size(); i++) {
            A a = list.get(0);
        }
    }
}

class ThreadTest {
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        A a = new A();
        try {
            atomicInteger.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.start();
    }

    static class A extends Thread {

        @Override
        public void run() {
            atomicInteger.notify();
            atomicInteger.lazySet(1);
            System.out.println(atomicInteger.get());
        }
    }
}

class ListParamTest {
    public static void resetList(List<Integer> dataList) {
        dataList.subList(2, 4).set(0, 40);
        dataList = new ArrayList<Integer>(dataList);
        dataList.add(50);
    }

    public static void setOne(List<Integer> dataList) {
        dataList.set(3, 100);
    }

    public static void main(String[] args) {
        List<Integer> dataList = new ArrayList<Integer>(Arrays.asList(10, 20, 30, null));
        resetList(dataList);
        setOne(dataList);
        int sum = 0;
        for (Integer v : dataList) {
            sum += v;
        }
        System.out.println(sum);
    }
}

//class Test {
//    static int x = 10;
//    static {
//        x += 5;
//    }
//    public static void main(String[] args){
//        System.out.println("x= "+ x);
//    }
//    static {
//        x += 3;
//    }
//}

//class Test {
//
//    static int arr[] = new int[10];
//
//    public static void main(String a[]) {
//
//        System.out.println(arr[1]);
//
//    }
//
//}

//public class Books {
//    public static void main(String[] args) {
//        IntegerStream pages = IntegerStream.of(200, 300);
//        IntegerSummaryStatistics stats =
//                pages.summaryStatistics();
//        long total = stats.getSum();
//        long count = stats.getCount();
//        System.out.println(total + "-" + count);
//    }
//
////    class Building {
////    }
////
////    class House extends Building {
////    }
////
////    public void convert() {
////        Building b = new Building();
////        House h = new House();
////        Building bh = new House();
////        Building p = (House) b;
////        House q = (Building) h;
////        Building r = (Building) bh;
////        House s = (House) bh;
////    }
//}

class ExamAnswers {
    private static ExamAnswers instance = new ExamAnswers();
    private List<String> answers = new ArrayList<>();

    public static List<String> getAnswers() {
        return instance.answers;
    }
}

class TestAnswers {
    private static TestAnswers instance = new TestAnswers();
    private List<String> answers = new ArrayList<>();

    public static TestAnswers getTestAnswers() {
        return instance;
    }

    public List<String> getAnswers() {
//        int i = Byte.valueOf("1");
//        long a = Short.valueOf("1");
//        double d = Float.valueOf("1.0");
//        int in= 10;
//        char s = in;
        return answers;
    }
}


enum DaysOff {
    Thanksgiving, PresidentsDay, ValentinesDay
}

class Test {
    public static void main (String args[]) {
        String[] s=new String[10];
        System.out.println("Value is " + s[9]);
    }
}

/*
1. public void paint(Graphics g) {
 2. g.drawString(“Any question”, 10, 0);
 3.
 }
 */
