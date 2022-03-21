package com.oceandatum.dataworks.reader;

import com.oceandatum.dataworks.EndRecord;
import com.oceandatum.dataworks.channel.Channel;
import com.oceandatum.dataworks.util.DB;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

public class OracleReader implements IReader{

    @Override
    public void read(Channel channel) {
        List<Map<String, Object>> data = DB.oracle();
        for (Map<String, Object> datum : data) {
            channel.sender(datum);
        }
        channel.sender(EndRecord.endRecord);
    }
}
