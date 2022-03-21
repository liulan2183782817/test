package com.oceandatum.dataworks.channel;


import com.oceandatum.dataworks.process.PostProcess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

public class Channel {

    ArrayBlockingQueue<Map<String,Object>> queue
            = new ArrayBlockingQueue(10);

    List<PostProcess> list = new ArrayList<>();

    public void sender(Map<String,Object> record){
        try {
            // 传输之前做一些事
            for (PostProcess process : list) {
                record =   process.processBeforeSender(record);
                if (record==null){
                    return;
                }
            }




            queue.put(record);
            // 传输之后做一些事
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Map<String,Object> receiver(){
        try {
          return   queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public void setList(List<PostProcess> list) {
        this.list = list;
    }
}
