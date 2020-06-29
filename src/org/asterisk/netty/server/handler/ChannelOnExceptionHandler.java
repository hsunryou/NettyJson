package org.asterisk.netty.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class ChannelOnExceptionHandler extends ChannelInboundHandlerAdapter {

    private static final Logger     _Logger = LoggerFactory.getLogger(ChannelOnExceptionHandler.class);
    public ChannelOnExceptionHandler() {
        
    }

    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        _Logger.error( cause.getMessage() );
        ctx.close();
    }
}
