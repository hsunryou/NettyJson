package org.asterisk.netty.client;

import org.asterisk.netty.ISession;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.asterisk.netty.packet.Packet;
import org.asterisk.netty.packet.Packet.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NettyClient implements ISession{

    
    private static final Logger     _Logger = LoggerFactory.getLogger(NettyClient.class);
    public NettyClient() {
        
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(new ClientInitalizer(this));
            
            // Start the client.
            ChannelFuture f = b.connect("127.0.0.1", 20000).sync(); // (5)

            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
        } catch(Exception ex){
            _Logger.error( "* NettyClient Exception:", ex );
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    //
    // Events
    @Override
    public void OnChannelActive( ChannelHandlerContext ctx ) {
        try{
            _Logger.info(" - OnChannelActive : ");
            Packet packet = new Packet(MessageType.EnterWorldResponse, "{ \"type\":\"login\" }");
            ctx.writeAndFlush(packet);
            _Logger.info(" Client > [{}][{}] ", packet.getType(), packet.getMessage());
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
    
    public static void main(String[] args) {
        try{
            _Logger.error( "----    main    ----");
            new NettyClient();
        }catch(Exception ex){
            _Logger.error( "* main Exception:", ex );
        }
    }

    
}
