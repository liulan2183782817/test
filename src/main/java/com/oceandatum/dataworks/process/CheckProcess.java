package com.oceandatum.dataworks.process;

import com.oceandatum.dataworks.EndRecord;
import com.oceandatum.dataworks.channel.Record;

import java.util.Map;

public class CheckProcess implements PostProcess{

    int neatCount = 0;
    int dirtyCount = 0;


    // job 的概念

    // reader -> writer1

               // writer2->

    @Override
    public Map<String, Object> processBeforeSender(Map<String, Object> record) {
        if(record== EndRecord.endRecord){
            System.out.println("正确数据量,"+neatCount);
            System.out.println("错误数据量,"+dirtyCount);
            return  record;
        }
        String id = record.get("id").toString();
        if (id.contains("1")){

            Record r = new Record();
            r.wirteId = "1";
        }else {
            dirtyCount++;
        }
        return record;
    }
}
