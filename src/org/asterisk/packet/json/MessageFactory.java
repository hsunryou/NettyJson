package org.asterisk.packet.json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.asterisk.packet.json.response.ResponseMessage;
import org.asterisk.packet.IPacket;
import org.asterisk.packet.json.cmd.user.CmdUserLogin;
import org.asterisk.packet.json.cmd.user.CmdUserLogout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




// <editor-fold defaultstate="collapsed" desc="MessageFactory">
/*

*/
// </editor-fold>

public class MessageFactory {

    private static Gson gson = new Gson();
    
    private static final Logger     _Logger = LoggerFactory.getLogger(MessageFactory.class);
    public MessageFactory() {
        
    }
    
    public static Message createMessage( String json ){
        Message message = null;
        try{
            JsonElement jsonElement = new JsonParser().parse(json);
            String format = jsonElement.getAsJsonObject().get("format").getAsString();          // Client, Messge 수신
            if( format.equals(IMessage.MESSAGE_FORMAT_RESPONSE) ){
                _Logger.info( " - ResponseMessage ");
                message = gson.fromJson(json, ResponseMessage.class);
                return message;
            }
            
            String type = jsonElement.getAsJsonObject().get("type").getAsString();              // Server, Message 수신
            _Logger.info( " - Command ");
            switch( type ){
                case IPacket.PACKET_TYPE_USER_LOGIN:
                    //message = gson.fromJson(json, UserLoginMessage.class);
                    message = gson.fromJson(json, CmdUserLogin.class);
                    break;
                case IPacket.PACKET_TYPE_USER_LOGOUT:
                    //message = gson.fromJson(json, UserLogoutMessage.class);
                    message = gson.fromJson(json, CmdUserLogout.class);
                    break;
                default:
                    _Logger.error( "* Packet[{}] is NOT define", type);
                    break;
            }
        }catch(Exception ex){
            _Logger.error( "* createMessage Exception:", ex );
        }
        return message;
    }

    
    
    
    public static ResponseMessage createResponse( Message msg, String result, String code ){
        ResponseMessage response = null;
        try{
            response = new ResponseMessage(msg, result, code);
        }catch(Exception ex){
            _Logger.error( "* createResponse Exception:", ex );
        }
        return response;
    }
    

}
