package com.cs.cs.web.testcode;

public class InterfaceStaticTest {
    public static void main(String[] args) {
        AbsImpl1 a = new AbsImpl1();
        AbsImpl2 b = new AbsImpl2();

        a.setS("df");
        System.out.println(a.getS());
        System.out.println(b.getS());
    }
}


interface inf{
    String s = "str";
}

class InfImp1 implements inf{

    public static String s = "df";

    public String getS(){
        return s;
    }

}

abstract class abs{
    public static String s = "1";
}

class AbsImpl1 extends abs{
    public String getS(){
        return s;
    }

    public void setS(String str){
        s = str;
    }
}

class AbsImpl2 extends abs{
    public String getS(){
        return s;
    }

    public void setS(String str){
        s = str;
    }
}