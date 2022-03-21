package com.oceandatum.dataworks.process;

import java.util.Map;

public interface PostProcess {

    Map<String,Object> processBeforeSender(Map<String,Object> record);

}
