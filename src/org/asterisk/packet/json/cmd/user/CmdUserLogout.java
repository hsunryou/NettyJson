package org.asterisk.packet.json.cmd.user;

import org.asterisk.packet.IPacket;
import org.asterisk.packet.json.cmd.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



// <editor-fold defaultstate="collapsed" desc="CmdUserLogout">
/*

*/
// </editor-fold>

public class CmdUserLogout extends UserCmd {

    
    private static final Logger     _Logger = LoggerFactory.getLogger(CmdUserLogout.class);
    public CmdUserLogout() {
        try{
            
            
        }catch(Exception ex){
            _Logger.error(" * CmdUserLogout Exception:", ex);
        }
    }

    public CmdUserLogout(String version, User user) {
        super(version, IPacket.PACKET_TYPE_USER_LOGOUT);
        try{
            setUser(user);
        }catch(Exception ex){
            _Logger.error(" * CmdUserLogout Exception:", ex);
        }
    }

}
