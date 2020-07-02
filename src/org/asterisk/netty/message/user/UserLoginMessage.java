package org.asterisk.netty.message.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.asterisk.netty.message.IMessage;
import org.asterisk.netty.message.Message;
import org.asterisk.netty.packet.IPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// <editor-fold defaultstate="collapsed" desc="UserLoginMessage">
/*
    
*/
// </editor-fold>

public class UserLoginMessage extends Message{
    
    
    @SerializedName("user")
    @Expose
    private User    user;
    
    private static final Logger     _Logger = LoggerFactory.getLogger(UserLoginMessage.class);
    public UserLoginMessage() {
    }
    
    public UserLoginMessage( String version, String userid, String password, String grade ) {
        setVersion(version);
        setFormat(IMessage.MESSAGE_FORMAT_COMMAND);
        setType(IPacket.PACKET_TYPE_USER_LOGIN);
        user = new User(userid, password, grade);
    }

    /*
    public String getUserid() {
        return user.getUserid();
    }

    public void setUserid(String userid) {
        user.setUserid(userid);
    }

    public String getPassword() {
        return user.getPassword();
    }

    public void setPassword(String password) {
        user.setPassword(password);
    }
    */

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    

}
