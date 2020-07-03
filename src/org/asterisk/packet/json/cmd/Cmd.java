package org.asterisk.packet.json.cmd;

import org.asterisk.packet.json.IMessage;
import org.asterisk.packet.json.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// <editor-fold defaultstate="collapsed" desc="Cmd">
/*

*/
// </editor-fold>

public class Cmd extends Message{

    
    private static final Logger     _Logger = LoggerFactory.getLogger(Cmd.class);
    public Cmd() {
        try{
            setFormat(IMessage.MESSAGE_FORMAT_COMMAND);
        }catch(Exception ex){
            _Logger.error(" * Cmd Exception:", ex);
        }
    }

    public Cmd(String version, String type) {
        super(version, IMessage.MESSAGE_FORMAT_COMMAND, type);
        try{
            
        }catch(Exception ex){
            _Logger.error(" * Cmd Exception:", ex);
        }
    }
    

}
