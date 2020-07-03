package org.asterisk;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.asterisk.netty.server.NettyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class NettyJson  {
    
    private NettyServer             _Service = null;

    private static final Logger     _Logger = LoggerFactory.getLogger(NettyJson.class);
    public NettyJson() {
        try{
            _Logger.info(" - NettyJson ");
            _Service = new NettyServer();
            _Service.startService(20000);
        }catch(Exception ex){
            _Logger.error( "* NettyJson Exception:", ex );
        }
    }
    
    public static void main(String[] args) {
        try{
            _Logger.error( "----    main    ----");
            new NettyJson();
        }catch(Exception ex){
            _Logger.error( "* main Exception:", ex );
        }
    }

    
    
    
}
