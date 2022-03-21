package com.oceandatum.dataworks;

import com.oceandatum.dataworks.channel.Channel;
import com.oceandatum.dataworks.process.CheckProcess;
import com.oceandatum.dataworks.process.FilterProcess;
import com.oceandatum.dataworks.process.PostProcess;
import com.oceandatum.dataworks.process.SubStringProcess;
import com.oceandatum.dataworks.reader.IReader;
import com.oceandatum.dataworks.reader.MysqlReader;
import com.oceandatum.dataworks.reader.OracleReader;
import com.oceandatum.dataworks.writer.IWriter;
import com.oceandatum.dataworks.writer.PrintWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 数据处理启动类
 * @author zhangzhifeng
 */
public class Launcher1 {


    public static void main(String[] args) throws InterruptedException {
        // 构建任务 之前也能做一些处理 : 准备工作  基于内存做处理  主外建  ，A 1  -> B
        // sql 去搞定  统计的类 去保存当前步骤的 结果

        // 多个输出  id 包含1

        ArrayBlockingQueue<Map<String,Object>> queue = new ArrayBlockingQueue(10);
        List<PostProcess> list = new ArrayList<>();
//        list.add(new SubStringProcess());
//        list.add(new FilterProcess());
        list.add(new CheckProcess());
        Channel channel = new Channel();
        channel.setList(list);

        IReader reader = new MysqlReader();

        IWriter writer = new PrintWriter();
        new Thread(new Runnable() {
            @Override
            public void run() {
                reader.read(channel);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                writer.writer(channel);
            }
        }).start();

        while (true){
            Thread.sleep(100);
        }


    }
}
