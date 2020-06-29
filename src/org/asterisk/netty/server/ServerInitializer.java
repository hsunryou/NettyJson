package org.asterisk.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.asterisk.netty.ISession;
import org.asterisk.netty.server.codec.JsonDecoder;
import org.asterisk.netty.server.codec.JsonEncoder;
import org.asterisk.netty.server.handler.ChannelOnActiveHandler;
import org.asterisk.netty.server.handler.ChannelOnExceptionHandler;
import org.asterisk.netty.server.handler.ChannelOnInactiveHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// <editor-fold defaultstate="collapsed" desc="ServerInitializer">
/*

*/
// </editor-fold>

public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    
    private ISession                _Listener = null;

    private static final Logger     _Logger = LoggerFactory.getLogger(ServerInitializer.class);
    public ServerInitializer( ISession listener ) {
        _Listener = listener;
        _Logger.info(" -- ServerInitializer ");
    }
    
    

    @Override
    protected void initChannel(SocketChannel sch) throws Exception {
        ChannelPipeline pipeline = sch.pipeline();
        /*
            lengthFieldOffset   =  0
            lengthFieldLength   =  2
            lengthAdjustment    = -2 (= the length of HDR1 + LEN, negative)
            initialBytesToStrip =  2

            BEFORE DECODE (15 bytes)                       AFTER DECODE (13 bytes)
            +--------+------+----------------+      +------+----------------+
            | Length | HDR2 | Actual Content |----->| HDR2 | Actual Content |
            | 0x0010 | 0xFE | "HELLO, WORLD" |      | 0xFE | "HELLO, WORLD" |
            +--------+------+----------------+      +------+----------------+
                2       1           12                  1          12        
            최대길이 = 2 Byte  = 16 Bit = 2^16 = 65,536
        */
        pipeline.addLast(new LoggingHandler(LogLevel.DEBUG));
        pipeline.addLast("FrameEncoder", new LengthFieldPrepender(2, true));
        pipeline.addLast("FrameDecoder", new LengthFieldBasedFrameDecoder(0x80000, 0, 2, -2, 2));
        
        pipeline.addLast("JsonEncoder", new JsonEncoder());
        pipeline.addLast("JsonDecoder", new JsonDecoder());
        pipeline.addLast("ServerHandler", new ServerHandler());

        pipeline.addLast("ChannelActiveHandler", new ChannelOnActiveHandler(_Listener));
        pipeline.addLast("ChannelInactiveHandler", new ChannelOnInactiveHandler(_Listener));
        pipeline.addLast("ExceptionHandler", new ChannelOnExceptionHandler());
        
        /*
        // outbound sequence ↑  
        cp.addLast(baseOutboundHandler);    // (3)
        cp.addLast(packetEncoder);          // (2)
        cp.addLast(byteArrayEncoder);       // (1)

        // inbound sequence ↓
        cp.addLast(byteArrayDecoder);       // (1)
        cp.addLast(packetDecoder);          // (2)
        cp.addLast(baseInboundHandler);     // (3)
        */
    }

}
