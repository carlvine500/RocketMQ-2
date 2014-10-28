package com.alibaba.rocketmq.remoting.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.FileRegion;
import io.netty.handler.codec.MessageToByteEncoder;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class FileRegionEncoder extends MessageToByteEncoder<FileRegion> {

    private final String CLASS_NAME = FileRegionEncoder.class.getName();

    /**
     * Encode a message into a {@link io.netty.buffer.ByteBuf}. This method will be called for each written message that can be handled
     * by this encoder.
     *
     * @param ctx the {@link io.netty.channel.ChannelHandlerContext} which this {@link io.netty.handler.codec.MessageToByteEncoder} belongs to
     * @param msg the message to encode
     * @param out the {@link io.netty.buffer.ByteBuf} into which the encoded message will be written
     * @throws Exception is thrown if an error accour
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, FileRegion msg, final ByteBuf out) throws Exception {
        System.out.println("Enter " + CLASS_NAME + "#encode");
        WritableByteChannel writableByteChannel = new WritableByteChannel() {
            @Override
            public int write(ByteBuffer src) throws IOException {
                out.writeBytes(src);
                return out.capacity();
            }

            @Override
            public boolean isOpen() {
                return true;
            }

            @Override
            public void close() throws IOException {
            }
        };

        while (true) {
            if (msg.transferTo(writableByteChannel, 0) == 0) {
                break;
            }
        }
    }
}
