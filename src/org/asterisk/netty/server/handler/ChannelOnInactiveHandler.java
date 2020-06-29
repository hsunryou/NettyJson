package org.asterisk.netty.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.asterisk.netty.ISession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class ChannelOnInactiveHandler extends ChannelInboundHandlerAdapter {
    
    private ISession                _Listener = null;

    
    private static final Logger     _Logger = LoggerFactory.getLogger(ChannelOnInactiveHandler.class);
    public ChannelOnInactiveHandler( ISession listener ) {
        _Listener = listener;
    }
    

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        try{
            _Logger.info( " - channelInactive ");
            
            ctx.fireChannelInactive();
            _Listener.OnChannelInactive(ctx);
        }catch(Exception ex){
            _Logger.error( "* channelInactive Exception:", ex );
        }
    }

    
    
}
