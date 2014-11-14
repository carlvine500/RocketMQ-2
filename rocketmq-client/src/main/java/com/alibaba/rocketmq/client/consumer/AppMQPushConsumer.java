package com.alibaba.rocketmq.client.consumer;

import com.alibaba.rocketmq.client.ClientConfig;
import com.alibaba.rocketmq.client.QueryResult;
import com.alibaba.rocketmq.client.consumer.listener.MessageListener;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

import java.util.Set;

public class AppMQPushConsumer extends ClientConfig implements MQPushConsumer {

    /**
     * 启动服务，调用之前确保registerMessageListener与subscribe都已经调用<br>
     * 或者已经通过Spring注入了相关配置
     *
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     */
    @Override
    public void start() throws MQClientException {

    }

    /**
     * 关闭服务，一旦关闭，此对象将不可用
     */
    @Override
    public void shutdown() {

    }

    /**
     * 注册消息监听器，一个Consumer只能有一个监听器
     *
     * @param messageListener
     */
    @Override
    public void registerMessageListener(MessageListener messageListener) {

    }

    /**
     * 订阅消息，方法可以调用多次来订阅不同的Topic，也可覆盖之前Topic的订阅过滤表达式
     *
     * @param topic         消息主题
     * @param subExpression 1、订阅过滤表达式字符串，broker依据此表达式进行过滤。目前只支持或运算<br>
     *                      例如: "tag1 || tag2 || tag3"<br>
     *                      如果subExpression等于null或者*，则表示全部订阅<br>
     *                      <p/>
     *                      2、高级过滤方式，传入一个Java程序，例如:
     *                      "rocketmq.message.filter.cousumergroup.FilterClassName"<br>
     *                      "rocketmq.message.filter.cousumergroup.topic1.FilterClassName"<br>
     *                      注意事项：<br>
     *                      a、Java程序必须继承于com.alibaba.rocketmq.common.filter.MessageFilter，
     *                      并实现相应的接口来过滤<br>
     *                      b、Java程序必须是UTF-8编码<br>
     *                      c、这个Java过滤程序只能依赖JDK里的类，非JDK的Java类一律不能依赖
     *                      d、过滤方法里不允许抛异常，只要抛异常，整个消费过程就停止
     *                      e、FilterClassName.java文件放置到CLASSPATH目录下，例如src/main/resources
     *                      消息回调监听器
     * @throws com.alibaba.rocketmq.client.exception.MQClientException
     */
    @Override
    public void subscribe(String topic, String subExpression) throws MQClientException {

    }

    /**
     * 取消订阅，从当前订阅组内注销，消息会被订阅组内其他订阅者订阅
     *
     * @param topic 消息主题
     */
    @Override
    public void unsubscribe(String topic) {

    }

    /**
     * 动态调整消费线程池线程数量
     *
     * @param corePoolSize
     */
    @Override
    public void updateCorePoolSize(int corePoolSize) {

    }

    /**
     * 消费线程挂起，暂停消费
     */
    @Override
    public void suspend() {

    }

    /**
     * 消费线程恢复，继续消费
     */
    @Override
    public void resume() {

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
