package com.oceandatum.dataworks.reader;

import com.oceandatum.dataworks.channel.Channel;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

public interface IReader {

    void read(Channel channel);
}
