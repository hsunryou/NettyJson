package org.asterisk.netty.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.asterisk.netty.ISession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ChannelOnActiveHandler extends ChannelInboundHandlerAdapter {
    
    private ISession            _Listener = null;

    
    private static final Logger     _Logger = LoggerFactory.getLogger(ChannelOnActiveHandler.class);
    public ChannelOnActiveHandler( ISession listener ) {
        _Listener = listener;
    }



    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        try{
            _Logger.info(" ");
            _Logger.info(" +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ ");
            _Logger.info(" ");
            _Logger.info( " - channelActive ");

            ctx.fireChannelActive();
            _Listener.OnChannelActive(ctx);
        }catch(Exception ex){
            _Logger.error( "* channelActive Exception:", ex );
        }
        
    }


}
