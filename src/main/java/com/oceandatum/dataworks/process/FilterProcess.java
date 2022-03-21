package com.oceandatum.dataworks.process;


import java.util.Map;

public class FilterProcess implements PostProcess{

    @Override
    public Map<String, Object> processBeforeSender(Map<String, Object> record) {
        Object id = record.get("sex");
        if (id.equals("99")){
            return null;
        }
        return record;
    }
}
