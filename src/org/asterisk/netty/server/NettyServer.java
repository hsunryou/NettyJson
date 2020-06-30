package org.asterisk.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.asterisk.netty.ISession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class NettyServer implements ISession {

    private EventLoopGroup bossGroup = null;
    private EventLoopGroup  workerGroup = null;
    private ServerBootstrap bootstrap = null;
    private ChannelFuture future = null;

    private static final Logger     _Logger = LoggerFactory.getLogger(NettyServer.class);
    public NettyServer() {
        try{
            _Logger.error( "----    NettyServer    ----");
            
        }catch(Exception ex){
            _Logger.error( "* NettyServer Exception:", ex );
        }
    }
    
    
    public void startService(int port){
        try{
            _Logger.error( "-- startService ");
            bossGroup = new NioEventLoopGroup();
            workerGroup = new NioEventLoopGroup();
            
            bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .childHandler(new ServerInitializer(this))
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true);

            // Bind and start to accept incoming connections.
            _Logger.info(" - Binding.. ");
            future = bootstrap.bind(port).sync(); // (7)

            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            future.channel().closeFuture().sync();
        }catch(Exception ex){
            _Logger.error( "* startService Exception:", ex );
        }
    }

    public void stopService(){
        try{
            _Logger.error( "-- stopService ");
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }catch(Exception ex){
            _Logger.error( "* stopService Exception:", ex );
        }
    }

    
    //
    // Evetns
    @Override
    public void OnChannelActive( ChannelHandlerContext ctx ) {
        try{
            _Logger.info(" - OnChannelActive : ");

        }catch(Exception ex){
            _Logger.error( "* OnChannelActive Exception:", ex );
        }
    }
    @Override
    public void OnChannelInactive( ChannelHandlerContext ctx ) {
        try{
            _Logger.info(" - OnChannelInactive : ");

        }catch(Exception ex){
            _Logger.error( "* OnChannelInactive Exception:", ex );
        }
    }
    
}
