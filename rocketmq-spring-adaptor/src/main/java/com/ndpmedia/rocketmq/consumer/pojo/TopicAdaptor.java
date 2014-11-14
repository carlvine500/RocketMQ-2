package com.ndpmedia.rocketmq.consumer.pojo;

import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;

public class TopicAdaptor {

    private String topic;

    private String tags;

    private MessageModel messageModel;

    private ConsumeFromWhere consumeFromWhere;

}
