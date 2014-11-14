package com.ndpmedia.rocketmq.consumer.pojo;

import java.util.List;

/**
 * <p>
 *     Application level configuration Spring bean. An application may involve multiple topics, this wrapping class
 *     guarantees all topic consumer client shares the same infrastructure,
 *     say {@link com.alibaba.rocketmq.client.impl.factory.MQClientInstance}.
 * </p>
 *
 * @author Li Zhanhui
 * @version 1.0
 * @since 1.0
 */
public class AppGroup {

    private String nameServer;
    
    private String consumerGroup;

    private List<TopicAdaptor> topicAdaptors;

    public String getNameServer() {
        return nameServer;
    }

    public void setNameServer(String nameServer) {
        this.nameServer = nameServer;
    }

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }

    public List<TopicAdaptor> getTopicAdaptors() {
        return topicAdaptors;
    }

    public void setTopicAdaptors(List<TopicAdaptor> topicAdaptors) {
        this.topicAdaptors = topicAdaptors;
    }
}
