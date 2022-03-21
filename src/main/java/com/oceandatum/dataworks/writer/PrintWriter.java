package com.oceandatum.dataworks.writer;

import com.oceandatum.dataworks.EndRecord;
import com.oceandatum.dataworks.channel.Channel;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

public class PrintWriter implements IWriter{
    int count;
    @Override
    public void writer(Channel channel) {
        Map<String,Object> record ;

        while ((record = channel.receiver())!= EndRecord.endRecord) {
            System.out.println(record);
            count++;
        }
        System.out.println("数据获取结束");

    }
}
