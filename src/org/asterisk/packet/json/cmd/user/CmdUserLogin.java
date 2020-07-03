package org.asterisk.packet.json.cmd.user;

import org.asterisk.packet.IPacket;
import org.asterisk.packet.json.cmd.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



// <editor-fold defaultstate="collapsed" desc="CmdUserLogin">
/*

*/
// </editor-fold>

public class CmdUserLogin extends UserCmd {

    
    private static final Logger     _Logger = LoggerFactory.getLogger(CmdUserLogin.class);
    public CmdUserLogin() {
        try{
            
            
        }catch(Exception ex){
            _Logger.error(" * CmdUserLogin Exception:", ex);
        }
    }

    public CmdUserLogin(String version, User user) {
        super(version, IPacket.PACKET_TYPE_USER_LOGIN);
        try{
            setUser(user);
        }catch(Exception ex){
            _Logger.error(" * CmdUserLogin Exception:", ex);
        }
    }
    
    

}
