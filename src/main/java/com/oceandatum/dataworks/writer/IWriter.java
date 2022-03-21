package com.oceandatum.dataworks.writer;

import com.oceandatum.dataworks.channel.Channel;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

public interface IWriter {

    void writer(Channel channel);
}
