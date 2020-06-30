package org.asterisk.netty.server.handler;

import io.netty.channel.ChannelHandlerContext;
import org.asterisk.netty.packet.Packet;
import org.asterisk.netty.server.handler.ChannelInboundHandlerBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerHandler extends ChannelInboundHandlerBase<Packet>{



    private static final Logger _Logger = LoggerFactory.getLogger(ServerHandler.class);
    public ServerHandler() {
        super();
        try{
            _Logger.info( "----    ServerHandler    ----");

        }catch(Exception ex){
            _Logger.error( "* ServerHandler Exception:", ex );
        }
    }

    @Override
    public boolean acceptInboundMessage(Object msg) throws Exception {
        return super.acceptInboundMessage(msg);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Packet packet) throws Exception {
        try{
            _Logger.info(" - channelRead0 ");
            _Logger.info("  Server < [{}][{}] ", packet.getMessageFormat(), packet.getMessage());
            
            Thread.sleep(500);
            Packet response = new Packet(Packet.MessageFormat.PacketResponse, packet.getMessageType(), "{12345678}");
            ctx.writeAndFlush(response);

        }catch(Exception ex){
            _Logger.error( "* channelRead0 Exception:", ex );
        }
    }
}
