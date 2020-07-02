package org.asterisk.netty.message.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.asterisk.netty.message.IMessage;
import org.asterisk.netty.message.Message;
import org.asterisk.netty.packet.IPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





// <editor-fold defaultstate="collapsed" desc="UserLogoutMessage">
/*

*/
// </editor-fold>

public class UserLogoutMessage extends Message {
    
    @SerializedName("user")
    @Expose
    private User    user;

    
    private static final Logger     _Logger = LoggerFactory.getLogger(UserLogoutMessage.class);
    public UserLogoutMessage() {
    }

    public UserLogoutMessage( String version, String userid, String grade ) {
        setVersion(version);
        setFormat(IMessage.MESSAGE_FORMAT_COMMAND);
        setType(IPacket.PACKET_TYPE_USER_LOGOUT);
        user = new User(userid, null, grade);
    }
    
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    

}
