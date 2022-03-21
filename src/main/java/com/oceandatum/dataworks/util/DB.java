package com.oceandatum.dataworks.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB {

    public static List<Map<String,Object>> mysql(){
        System.out.println("建立mysql JDBC连接...");
        System.out.println("开始获取mysql数据");
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();


        for (int i = 0; i < 100; i++) {
            Map<String,Object> record = new HashMap<String, Object>(4);
            record.put("id",i);
            record.put("dbType","mysql");
            record.put("name","zhangsan-"+i);


            record.put("phone","1762173120"+i);



            list.add(record);
        }
        return  list;
    }


    public static List<Map<String,Object>> oracle(){
        System.out.println("建立oracle JDBC连接...");
        System.out.println("开始获取oracle数据");
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        Map<String,Object> record;
        for (int i = 0; i < 100; i++) {
            record = new HashMap<String, Object>(4);
            record.put("id",String.valueOf(i));
            record.put("dbType","oracle");
            record.put("name","zhangsan-"+i);
            record.put("phone","1762173120"+i);
            list.add(record);
        }
        return  list;
    }
}
