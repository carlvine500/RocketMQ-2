package com.alibaba.rocketmq.client.consumer;

import com.alibaba.rocketmq.client.ClientConfig;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;

/**
 * This class contains common fields shared by both {@link com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer}
 * and {@link com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer}.
 *
 * <p>
 *    <strong>Thread Safety:</strong> This class is not thread safe.
 * </p>
 *
 * @author Li Zhanhui
 * @version 1.0
 * @since 1.0
 */
public abstract class BaseMQConsumer extends ClientConfig {

    /**
     * 做同样事情的Consumer归为同一个Group，应用必须设置，并保证命名唯一
     */
    private String consumerGroup;

    /**
     * 集群消费/广播消费
     */
    private MessageModel messageModel = MessageModel.CLUSTERING;

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }

    public MessageModel getMessageModel() {
        return messageModel;
    }

    public void setMessageModel(MessageModel messageModel) {
        this.messageModel = messageModel;
    }
}
