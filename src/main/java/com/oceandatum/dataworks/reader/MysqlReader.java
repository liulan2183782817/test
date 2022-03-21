package com.oceandatum.dataworks.reader;

import com.oceandatum.dataworks.EndRecord;
import com.oceandatum.dataworks.channel.Channel;
import com.oceandatum.dataworks.util.DB;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

public class MysqlReader implements IReader{

    @Override
    public void read(Channel channel) {
        // 数据ku连接

        List<Map<String, Object>> data = DB.mysql();
        for (Map<String, Object> datum : data) {

            channel.sender(datum);
        }
        // 终止条件
        channel.sender(EndRecord.endRecord);
    }
}
