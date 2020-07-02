package org.asterisk.netty.client;

import org.asterisk.netty.ISession;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.asterisk.netty.packet.IPacket;
import org.asterisk.netty.packet.Packet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NettyClient implements ISession{

    
    private static final Logger     _Logger = LoggerFactory.getLogger(NettyClient.class);
    public NettyClient() {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ClientInitalizer(this));
            
            ChannelFuture f = b.connect("127.0.0.1", 20000).sync();
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
            Packet packet = new Packet(IPacket.PACKET_FORMAT_JSON, "{ version=\"10\", format:\"C\", type:\"100\", userid:\"userid\", password:\"password\" }");
            ctx.writeAndFlush(packet);
            _Logger.info(" Client > [{}][{}] ", packet.getPacketFormat(), packet.getMessage());
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
