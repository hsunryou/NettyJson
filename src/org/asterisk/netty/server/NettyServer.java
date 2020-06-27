package org.asterisk.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class NettyServer {

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
            bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class) // (3)
                .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ServerHandler());
                    }
                })
                .option(ChannelOption.SO_BACKLOG, 128)          // (5)
                .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

            // Bind and start to accept incoming connections.
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
    
    
    
}
