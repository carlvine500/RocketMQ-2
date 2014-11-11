/**
 * Copyright (C) 2010-2013 Alibaba Group Holding Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.rocketmq.store;

/**
 * 向物理队列写入消息返回结果
 *
 * @author shijia.wxr<vintage.wang@gmail.com>
 * @since 2013-7-21
 */
public class AppendMessageResult {

    // 返回码
    private AppendMessageStatus status;

    // 从哪里开始写入
    private long writeOffset;

    // 写入字节数
    private int numberOfBytesWritten;

    // 消息ID
    private String msgId;

    // 消息存储时间
    private long storeTimestamp;

    // 写入逻辑队列的offset（递进1）
    private long logicOffset;


    public AppendMessageResult(AppendMessageStatus status) {
        this(status, 0, 0, "", 0, 0);
    }


    public AppendMessageResult(AppendMessageStatus status, long writeOffset, int numberOfBytesWritten, String msgId,
                               long storeTimestamp, long logicOffset) {
        this.status = status;
        this.writeOffset = writeOffset;
        this.numberOfBytesWritten = numberOfBytesWritten;
        this.msgId = msgId;
        this.storeTimestamp = storeTimestamp;
        this.logicOffset = logicOffset;
    }


    public boolean isOk() {
        return this.status == AppendMessageStatus.PUT_OK;
    }


    public AppendMessageStatus getStatus() {
        return status;
    }


    public void setStatus(AppendMessageStatus status) {
        this.status = status;
    }


    public long getWriteOffset() {
        return writeOffset;
    }


    public void setWriteOffset(long writeOffset) {
        this.writeOffset = writeOffset;
    }


    public int getNumberOfBytesWritten() {
        return numberOfBytesWritten;
    }


    public void setNumberOfBytesWritten(int numberOfBytesWritten) {
        this.numberOfBytesWritten = numberOfBytesWritten;
    }


    public String getMsgId() {
        return msgId;
    }


    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }


    public long getStoreTimestamp() {
        return storeTimestamp;
    }


    public void setStoreTimestamp(long storeTimestamp) {
        this.storeTimestamp = storeTimestamp;
    }


    public long getLogicOffset() {
        return logicOffset;
    }


    public void setLogicOffset(long logicOffset) {
        this.logicOffset = logicOffset;
    }


    @Override
    public String toString() {
        return "AppendMessageResult [status=" + status + ", writeOffset=" + writeOffset + ", numberOfBytesWritten="
                + numberOfBytesWritten + ", msgId=" + msgId + ", storeTimestamp=" + storeTimestamp + ", logicOffset="
                + logicOffset + "]";
    }

}
