package org.asterisk.packet.json.cmd.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.asterisk.packet.json.cmd.User;
import org.asterisk.packet.json.cmd.Cmd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// <editor-fold defaultstate="collapsed" desc="UserCmd">
/*

*/
// </editor-fold>

public class UserCmd extends Cmd {
    
    @SerializedName("user")
    @Expose
    private User    user;

    private static final Logger     _Logger = LoggerFactory.getLogger(UserCmd.class);
    public UserCmd() {
        try{
            
            
        }catch(Exception ex){
            _Logger.error(" * UserCmd Exception:", ex);
        }
    }
    public UserCmd(String version, String type) {
        super(version, type);
        try{
            
        }catch(Exception ex){
            _Logger.error(" * UserCmd Exception:", ex);
        }
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    

}
