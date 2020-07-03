package org.asterisk.packet.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// <editor-fold defaultstate="collapsed" desc="MessageDispatcher">
/*
    - Message Type에 따라 Messge를 처리하는 Worker Thread로 전달하는 Class
      1) Command 

*/
// </editor-fold>

public class MessageDispatcher {

    private static final Logger     _Logger = LoggerFactory.getLogger(MessageDispatcher.class);
    public MessageDispatcher() {
        try{
            
            _Logger.info(" ---   MessageDispatcher   --- ");
        }catch(Exception ex){
            _Logger.error(" * MessageDispatcher Exception:", ex);
        }
    }
    
    public void dispatch( Message message ){
        try{
            if( message == null ){
                _Logger.error(" * Message is NULL");
                return;
            }
            if( !message.isValid() ){
                _Logger.error(" * Message is NOT Valid");
                // Response : Command Parameter is NOT valid
                return;
            }
            
            // Route Message
        }catch(Exception ex){
            _Logger.error(" * MessageDispatcher Exception:", ex);
        }
    }
    
    private void sendResponse( Message message, boolean close ){
        try{
            
            
            if( close ){            // Close Session

            }
        }catch(Exception ex){
            _Logger.error(" * sendResponse Exception:", ex);
        }
    }
    
    

}
