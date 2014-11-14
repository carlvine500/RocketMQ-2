package com.alibaba.rocketmq.client.impl.consumer;

import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;
import java.util.Set;

public interface Rebalance {

    public void unlock(final MessageQueue mq, final boolean oneWay);

    public void unlockAll(final boolean oneWay);

    public boolean lock(final MessageQueue mq);

    public void lockAll();

    public void rebalance(MessageModel messageModel);

    public void messageQueueChanged(final String topic, final Set<MessageQueue> mqAll,
                                             final Set<MessageQueue> mqDivided);
    public void removeProcessQueue(final MessageQueue mq);

    public boolean removeUnnecessaryMessageQueue(final MessageQueue mq, final ProcessQueue pq);

    public void dispatchPullRequest(final List<PullRequest> pullRequestList);

    public long computePullFromWhere(final MessageQueue mq);
}
