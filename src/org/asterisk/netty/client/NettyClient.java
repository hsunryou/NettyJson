package org.asterisk.netty.client;

import org.asterisk.netty.ISession;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.asterisk.packet.json.cmd.User;
import org.asterisk.packet.json.cmd.user.CmdUserLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NettyClient implements ISession{
    
    private static String           _PacketVersion = "01";
    
    private static final Logger     _Logger = LoggerFactory.getLogger(NettyClient.class);
    public NettyClient( String[] args ) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ClientInitalizer(this));
            int port = Integer.parseInt(args[1]);
            ChannelFuture f = b.connect(args[0], port).sync();
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

            //Packet packet = new Packet(IPacket.PACKET_FORMAT_JSON, "{ \"version\":\"02\", \"format\":\"C\", \"type\":\"010\", \"user\":{ \"grade\":\"A\", \"userid\": \"user1\", \"password\": \"user1\" } }");
            //ctx.writeAndFlush(packet);
            
            CmdUserLogin cmdLogin = new CmdUserLogin(_PacketVersion, new User("user9000", "password9000", "A"));
            ctx.writeAndFlush(cmdLogin);
            _Logger.info(" Client >  UserLoginMessage : [{}][{}][{}] <-- {} ", cmdLogin.getVersion(), cmdLogin.getFormat(), cmdLogin.getType(), cmdLogin.toString());
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
            _Logger.info( "----    NettyClient {}:{}    ----", args[0], args[1]);
            new NettyClient( args );
        }catch(Exception ex){
            _Logger.error( "* main Exception:", ex );
        }
    }

    
}
