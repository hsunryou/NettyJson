package org.asterisk.netty.server.handler;

import io.netty.channel.ChannelHandlerContext;
import org.asterisk.netty.message.Message;
import org.asterisk.netty.message.MessageFactory;
import org.asterisk.netty.message.response.IResponse;
import org.asterisk.netty.message.user.User;
import org.asterisk.netty.message.user.UserLoginMessage;
import org.asterisk.netty.message.user.UserLogoutMessage;
import org.asterisk.netty.packet.IPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//public class ServerHandler extends ChannelInboundHandlerBase<Packet>{
public class ServerHandler extends ChannelInboundHandlerBase<Message>{



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
            _Logger.info("  Server < [{}][{}][{}] ", msg.getVersion(), msg.getFormat(), msg.getType());
            switch( msg.getType() ){
                case IPacket.PACKET_TYPE_USER_LOGIN:
                    UserLoginMessage login = (UserLoginMessage)msg;
                    User loginUser = login.getUser();
                    if( loginUser == null ){
                        _Logger.info(" * User is NULL ");
                    } else {
                        _Logger.info("   - User : [{}][{}][{}] ", loginUser.getUserid(), loginUser.getPassword(), loginUser.getGrade());
                    }
                    break;
                case IPacket.PACKET_TYPE_USER_LOGOUT:
                    UserLogoutMessage logout = (UserLogoutMessage)msg;
                    User logoutUser = logout.getUser();
                    if( logoutUser == null ){
                        _Logger.info(" * User is NULL ");
                    } else {
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
