package org.asterisk.netty.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.asterisk.packet.json.Message;
import org.asterisk.packet.json.MessageFactory;
import org.asterisk.packet.json.response.IResponse;
import org.asterisk.packet.json.cmd.User;
import org.asterisk.packet.IPacket;
import org.asterisk.packet.json.cmd.user.CmdUserLogin;
import org.asterisk.packet.json.cmd.user.CmdUserLogout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



// <editor-fold defaultstate="collapsed" desc="ServerHandler">
/*
    - 

*/
// </editor-fold>

public class ServerHandler extends SimpleChannelInboundHandler<Message>{


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

    /*
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Packet packet) throws Exception {
        try{
            _Logger.info(" - channelRead0 ");
            _Logger.info("  Server < [{}][{}] ", (char)packet.getPacketFormat(), packet.getMessage());
            
            Thread.sleep(500);
            Packet response = new Packet(IPacket.PACKET_FORMAT_JSON, "{ version=\"10\", format:\"R\", type:\"100\", result:\"success\", code:\"0000\", data:\"01\" }");
            ctx.writeAndFlush(response);
            _Logger.error( "* channelRead0 Exception:", ex );
        }
    }
    */

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        boolean fire = true, close = false;
        try{
            _Logger.info(" - channelRead0 ");
            _Logger.info("  Server < [Version:{}][Format:{}][Type:{}] ", msg.getVersion(), msg.getFormat(), msg.getType());
            switch( msg.getType() ){
                case IPacket.PACKET_TYPE_USER_LOGIN:
                    CmdUserLogin login = (CmdUserLogin)msg;
                    User loginUser = login.getUser();
                    if( loginUser == null ){
                        _Logger.info(" * User is NULL ");
                    } else {
                        _Logger.info( login.toString() );
                        _Logger.info("   - User : [{}][{}][{}] ", loginUser.getUserid(), loginUser.getPassword(), loginUser.getGrade());
                    }
                    break;
                case IPacket.PACKET_TYPE_USER_LOGOUT:
                    //UserLogoutMessage logout = (UserLogoutMessage)msg;
                    CmdUserLogout logout = (CmdUserLogout)msg;
                    User logoutUser = logout.getUser();
                    if( logoutUser == null ){
                        _Logger.info(" * User is NULL ");
                    } else {
                        _Logger.info( logout.toString() );
                        _Logger.info("   - User : [{}][{}][{}] ", logoutUser.getUserid(), logoutUser.getPassword(), logoutUser.getGrade());
                    }
                    close = true;
                    break;
                default:
                    fire = false;
                    _Logger.error(" * Message Type[{}] is NOT define", msg.getType());
                    break;
            }
            
            if( fire ){
                Message response = MessageFactory.createResponse(msg, IResponse.RESPONSE_RESULT_SUCCESS, IResponse.RESPONSE_CODE_SUCCESS);
                if( response == null ){
                    _Logger.info(" * ResponseMessage is NULL ");
                    return;
                }
                _Logger.info(" - Send Response ");
                ctx.writeAndFlush(response);
            }
            if( close ){
                Thread.sleep(300);
                _Logger.info(" - Close ChannelHandlerContext ");
                ctx.close();
            }
        }catch(Exception ex){
            _Logger.error( "* channelRead0 Exception:", ex );
        }
    }
}
