package com.alibaba.rocketmq.client.consumer;

import com.alibaba.rocketmq.client.ClientConfig;
import com.alibaba.rocketmq.client.QueryResult;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

import java.util.Set;

public class AppMQPullConsumer extends ClientConfig implements MQPullConsumer {

    /**
     * 启动服务
     *
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     */
    @Override
    public void start() throws MQClientException {

    }

    /**
     * 关闭服务
     */
    @Override
    public void shutdown() {

    }

    /**
     * 注册监听队列变化的listener对象
     *
     * @param topic
     * @param listener
     */
    @Override
    public void registerMessageQueueListener(String topic, MessageQueueListener listener) {

    }

    /**
     * 指定队列，主动拉取消息，即使没有消息，也立刻返回
     *
     * @param mq            指定具体要拉取的队列
     * @param subExpression 订阅过滤表达式字符串，broker依据此表达式进行过滤。目前只支持或运算<br>
     *                      eg: "tag1 || tag2 || tag3"<br>
     *                      如果subExpression等于null或者*，则表示全部订阅
     * @param offset        从指定队列哪个位置开始拉取
     * @param maxNum        一次最多拉取条数
     * @return 参见PullResult
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     * @throws InterruptedException
     * @throws com.alibaba.rocketmq.client.exception.MQBrokerException
     * @throws com.alibaba.rocketmq.remoting.exception.RemotingException
     */
    @Override
    public PullResult pull(MessageQueue mq, String subExpression, long offset, int maxNum) throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        return null;
    }

    @Override
    public void pull(MessageQueue mq, String subExpression, long offset, int maxNum, PullCallback pullCallback) throws MQClientException, RemotingException, InterruptedException {

    }

    /**
     * 指定队列，主动拉取消息，如果没有消息，则broker阻塞一段时间再返回（时间可配置）<br>
     * broker阻塞期间，如果有消息，则立刻将消息返回
     *
     * @param mq            指定具体要拉取的队列
     * @param subExpression 订阅过滤表达式字符串，broker依据此表达式进行过滤。目前只支持或运算<br>
     *                      eg: "tag1 || tag2 || tag3"<br>
     *                      如果subExpression等于null或者*，则表示全部订阅
     * @param offset        从指定队列哪个位置开始拉取
     * @param maxNum        一次最多拉取条数
     * @return 参见PullResult
     * @throws InterruptedException
     * @throws com.alibaba.rocketmq.client.exception.MQBrokerException
     * @throws com.alibaba.rocketmq.remoting.exception.RemotingException
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     */
    @Override
    public PullResult pullBlockIfNotFound(MessageQueue mq, String subExpression, long offset, int maxNum) throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        return null;
    }

    @Override
    public void pullBlockIfNotFound(MessageQueue mq, String subExpression, long offset, int maxNum, PullCallback pullCallback) throws MQClientException, RemotingException, InterruptedException {

    }

    /**
     * 更新消费进度<br>
     * 只是更新Consumer缓存中的数据，如果是广播模式，则定时更新到本地存储<br>
     * 如果是集群模式，则定时更新到远端Broker<br>
     * <p/>
     * P.S. 可频繁调用，无性能开销
     *
     * @param mq
     * @param offset
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     */
    @Override
    public void updateConsumeOffset(MessageQueue mq, long offset) throws MQClientException {

    }

    /**
     * 获取消费进度，返回-1表示出错
     *
     * @param mq
     * @param fromStore
     * @return
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     */
    @Override
    public long fetchConsumeOffset(MessageQueue mq, boolean fromStore) throws MQClientException {
        return 0;
    }

    /**
     * 根据topic获取MessageQueue，以均衡方式在组内多个成员之间分配
     *
     * @param topic 消息Topic
     * @return 返回队列集合
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     */
    @Override
    public Set<MessageQueue> fetchMessageQueuesInBalance(String topic) throws MQClientException {
        return null;
    }

    /**
     * Consumer消费失败的消息可以选择重新发回到服务器端，并延时消费<br>
     * 会首先尝试将消息发回到消息之前存储的主机，此时只传送消息Offset，消息体不传送，不会占用网络带宽<br>
     * 如果发送失败，会自动重试发往其他主机，此时消息体也会传送<br>
     * 重传回去的消息只会被当前Consumer Group消费。
     *
     * @param msg
     * @param delayLevel
     * @throws InterruptedException
     * @throws com.alibaba.rocketmq.client.exception.MQBrokerException
     * @throws com.alibaba.rocketmq.remoting.exception.RemotingException
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     */
    @Override
    public void sendMessageBack(MessageExt msg, int delayLevel) throws RemotingException, MQBrokerException, InterruptedException, MQClientException {

    }

    /**
     * 根据topic获取对应的MessageQueue，是可被订阅的队列<br>
     * P.S 从Consumer Cache中拿数据，可以频繁调用。Cache中数据大约30秒更新一次
     *
     * @param topic 消息Topic
     * @return 返回队列集合
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     */
    @Override
    public Set<MessageQueue> fetchSubscribeMessageQueues(String topic) throws MQClientException {
        return null;
    }

    /**
     * 创建topic
     *
     * @param key      请向运维人员申请
     * @param newTopic 要创建的新topic
     * @param queueNum 新topic队列数
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     */
    @Override
    public void createTopic(String key, String newTopic, int queueNum) throws MQClientException {

    }

    /**
     * 创建topic
     *
     * @param key          请向运维人员申请
     * @param newTopic     要创建的新topic
     * @param queueNum     新topic队列数
     * @param topicSysFlag 新 topic 配置标识
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     */
    @Override
    public void createTopic(String key, String newTopic, int queueNum, int topicSysFlag) throws MQClientException {

    }

    /**
     * 根据时间查询对应的offset，精确到毫秒<br>
     * P.S. 当前接口有较多IO开销，请勿频繁调用
     *
     * @param mq        队列
     * @param timestamp 毫秒形式时间戳
     * @return 指定时间对应的offset
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     */
    @Override
    public long searchOffset(MessageQueue mq, long timestamp) throws MQClientException {
        return 0;
    }

    /**
     * 向服务器查询队列最大Offset PS: 最大Offset无对应消息，减1有消息
     *
     * @param mq 队列
     * @return 队列的最大Offset
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     */
    @Override
    public long maxOffset(MessageQueue mq) throws MQClientException {
        return 0;
    }

    /**
     * 向服务器查询队列最小Offset PS: 最小Offset有对应消息
     *
     * @param mq 队列
     * @return 队列的最小Offset
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     */
    @Override
    public long minOffset(MessageQueue mq) throws MQClientException {
        return 0;
    }

    /**
     * 向服务器查询队列保存的最早消息对应的存储时间
     *
     * @param mq 队列
     * @return 最早消息对应的存储时间，精确到毫秒
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     */
    @Override
    public long earliestMsgStoreTime(MessageQueue mq) throws MQClientException {
        return 0;
    }

    /**
     * 根据消息ID，从服务器获取完整的消息
     *
     * @param msgId
     * @return 完整消息
     * @throws InterruptedException
     * @throws com.alibaba.rocketmq.client.exception.MQBrokerException
     * @throws com.alibaba.rocketmq.remoting.exception.RemotingException
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     */
    @Override
    public MessageExt viewMessage(String msgId) throws RemotingException, MQBrokerException, InterruptedException, MQClientException {
        return null;
    }

    /**
     * 根据消息Key查询消息
     *
     * @param topic  消息主题
     * @param key    消息关键词
     * @param maxNum 查询最大条数
     * @param begin  起始时间戳
     * @param end    结束时间戳
     * @return 查询结果
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     * @throws InterruptedException
     */
    @Override
    public QueryResult queryMessage(String topic, String key, int maxNum, long begin, long end) throws MQClientException, InterruptedException {
        return null;
    }
}
