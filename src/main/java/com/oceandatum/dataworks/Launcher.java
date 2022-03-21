package com.oceandatum.dataworks;

import com.oceandatum.dataworks.util.DB;

import java.util.List;
import java.util.Map;

/**
 * 数据处理启动类
 * @author zhangzhifeng
 */
public class Launcher {


    public static void main(String[] args) {
        // 1. 性能问题 -》 读数据的时候 写等待 写数据的时候读等待
        // 生产者- 消费者

        // 2. 无拓展性 (代码很lOW)
        // 工厂模式

        List<Map<String, Object>> mysql = DB.mysql();

//        for (Map<String, Object> map : mysql) {
//            // insert（） oracle
//        }


        // 读 -> 写

        //



    }
}
