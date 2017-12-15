package com.cs.cs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by fengbo on 16/8/25.
 */
public class import_file {

    static {
        try {
            com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
        }catch (Exception e) {}
    }


    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/toImport.csv"), "gbk"));
            String str ;
            while((str=br.readLine()) != null){
//                String[] ar = str.split(";");
                System.out.println(str);
//                for (String s : ar) System.out.debuginfo(s);
//                System.out.debuginfo(ar);
                break;
            }
            String[] ar = "434316;品牌;0CV阀总成;1415339667;普通件;;".split(";");
            System.out.println(ar.length);
        }catch (Exception e){
            e.printStackTrace();
        }

        Connection conn = null ;
        String url ="jdbc:mysql://localhost:3306/fengbo?characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&autoReconnect=true";
//        URLDecoder.decode(url.replaceAll("%", "%25"), "UTF-8")

        try {
//            String str = java.net.URLEncoder.encode(url, "utf-8");
//            System.out.debuginfo(str);
           conn = DriverManager.getConnection(url , "root" , "Asd1234%");
            Statement statement = conn.createStatement();
            String sql = "show tables from fengbo";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
