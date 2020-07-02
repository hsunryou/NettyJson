package org.asterisk.netty.server.handler;

import io.netty.channel.ChannelHandlerContext;
import org.asterisk.netty.packet.IPacket;
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
            _Logger.info("  Server < [{}][{}] ", packet.getPacketFormat(), packet.getMessage());
            
            Thread.sleep(500);
            Packet response = new Packet(IPacket.PACKET_FORMAT_JSON, "{ version=\"10\", format:\"R\", type:\"100\", result:\"success\", code:\"0000\", data:\"01\" }");
            ctx.writeAndFlush(response);

        }catch(Exception ex){
            _Logger.error( "* channelRead0 Exception:", ex );
        }
    }
}
