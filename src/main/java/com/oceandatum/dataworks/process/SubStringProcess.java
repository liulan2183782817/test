package com.oceandatum.dataworks.process;

import java.util.Map;

public class SubStringProcess implements PostProcess {


    @Override
    public Map<String,Object> processBeforeSender(Map<String,Object> record) {
        String name = record.get("name").toString();
        record.put("name", name.substring(0,5));
        return record;
    }

}
