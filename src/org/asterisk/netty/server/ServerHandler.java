package org.asterisk.netty.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerHandler extends ChannelInboundHandlerAdapter {



    private static final Logger _Logger = LoggerFactory.getLogger(ServerHandler.class);
    public ServerHandler() {
        super();
        try{
            _Logger.error( "----    ServerHandler    ----");

        }catch(Exception ex){
            _Logger.error( "* ServerHandler Exception:", ex );
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        try{

        }catch(Exception ex){
            _Logger.error( "* channelInactive Exception:", ex );
        }
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        try{

        }catch(Exception ex){
            _Logger.error( "* channelRead Exception:", ex );
        }
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        try{

        }catch(Exception ex){
            _Logger.error( "* channelActive Exception:", ex );
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        try{

        }catch(Exception ex){
            _Logger.error( "* exceptionCaught Exception:", ex );
        }
    }
}
