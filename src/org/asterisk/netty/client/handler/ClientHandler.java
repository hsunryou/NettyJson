package org.asterisk.netty.client.handler;

import io.netty.channel.ChannelHandlerContext;
import org.asterisk.netty.packet.Packet;
import org.asterisk.netty.server.handler.ChannelInboundHandlerBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// <editor-fold defaultstate="collapsed" desc="ClientHandler">
/*

*/
// </editor-fold>

public class ClientHandler extends ChannelInboundHandlerBase<Packet>{

    private static final Logger     _Logger = LoggerFactory.getLogger(ClientHandler.class);
    public ClientHandler() {
        _Logger.info(" - ClientHandler ");
    }
    

    @Override
    protected void channelRead0( ChannelHandlerContext chc, Packet packet ) throws Exception {
        _Logger.info(" - channelRead0 ");
        _Logger.info(" Client < [{}][{}] ", packet.getMessageFormat(), packet.getMessage());
        
    }

}
