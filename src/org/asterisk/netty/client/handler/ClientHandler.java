package org.asterisk.netty.client.handler;

import io.netty.channel.ChannelHandlerContext;
import org.asterisk.netty.message.IMessage;
import org.asterisk.netty.message.Message;
import org.asterisk.netty.message.response.ResponseMessage;
import org.asterisk.netty.message.user.UserLogoutMessage;
import org.asterisk.netty.packet.IPacket;
import org.asterisk.netty.server.handler.ChannelInboundHandlerBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// <editor-fold defaultstate="collapsed" desc="ClientHandler">
/*

*/
// </editor-fold>

public class ClientHandler extends ChannelInboundHandlerBase<Message>{
    
    private static String           _PacketVersion = "01";
    
    //public class ClientHandler extends ChannelInboundHandlerBase<Packet>{

    private static final Logger     _Logger = LoggerFactory.getLogger(ClientHandler.class);
    public ClientHandler() {
        _Logger.info(" - ClientHandler ");
    }
    
    /*
    @Override
    protected void channelRead0( ChannelHandlerContext chc, Packet packet ) throws Exception {
        _Logger.info(" - channelRead0 ");
        _Logger.info(" Client < [{}][{}] ", packet.getPacketFormat(), packet.getMessage());
        
    }
    */

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        
        boolean fire = false;
        _Logger.info(" - channelRead0 ");
        _Logger.info(" Client < [{}][{}][{}] ", msg.getVersion(), msg.getFormat(), msg.getType());
        switch( msg.getFormat() ){
            case IMessage.MESSAGE_FORMAT_RESPONSE:
                ResponseMessage response = (ResponseMessage)msg;
                _Logger.info("  -  Response : [{}][{}][{}] ", response.getResult(), response.getCode(), response.getData());
                if( response.getType().equals(IPacket.PACKET_TYPE_USER_LOGIN) ){
                    Thread.sleep(1000 * 2);
                    ctx.writeAndFlush(new UserLogoutMessage( _PacketVersion, "user1", "A"));
                }
                fire = true;
                break;
            default:
                _Logger.error(" * Message[{}] is NOT define ", msg.getType());
                break;
        }
        
    }

}
