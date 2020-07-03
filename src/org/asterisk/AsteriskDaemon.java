package org.asterisk;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.asterisk.netty.server.NettyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// <editor-fold defaultstate="collapsed" desc="AsteriskDaemon">
/*

*/
// </editor-fold>

public class AsteriskDaemon implements Daemon {
    
    private NettyServer             _Service = null;

    private static final Logger     _Logger = LoggerFactory.getLogger(AsteriskDaemon.class);
    public AsteriskDaemon() {
        try{
            _Logger.info(" - AsteriskDaemon ");
        }catch(Exception ex){
            _Logger.error( "* AsteriskDaemon Exception:", ex );
        }
    }
    
    @Override
    public void init(DaemonContext dc) throws DaemonInitException, Exception {
        try{
            _Logger.warn( " - init ");
            _Service = new NettyServer();
        }catch(Exception ex){
            _Logger.error( "* init Exception:", ex );
        }
    }
    @Override
    public void start() throws Exception {
        try{
            _Logger.warn( " - start ");
            _Service.startService(20000);

        }catch(Exception ex){
            _Logger.error( "* start Exception:", ex );
        }
    }
    @Override
    public void stop() throws Exception {
        try{
            _Logger.warn( " - stop ");
            _Service.stopService();
        }catch(Exception ex){
            _Logger.error( "* stop Exception:", ex );
        }
    }
    @Override
    public void destroy() {
        try{
            _Logger.warn( " - destroy ");

        }catch(Exception ex){
            _Logger.error( "* destroy Exception:", ex );
        }
    }

}
