package org.asterisk.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class NettyServer {

    private static final Logger     _Logger = LoggerFactory.getLogger(NettyServer.class);
    public NettyServer() {
        try{
            _Logger.error( "----    NettyServer    ----");
            
        }catch(Exception ex){
            _Logger.error( "* NettyServer Exception:", ex );
        }
    }
    
    
    public void startService(){
        try{
            _Logger.error( "-- startService ");
            
        }catch(Exception ex){
            _Logger.error( "* startService Exception:", ex );
        }
    }
    public void stopService(){
        try{
            _Logger.error( "-- stopService ");
            
            
        }catch(Exception ex){
            _Logger.error( "* stopService Exception:", ex );
        }
    }
    
    
    
}
