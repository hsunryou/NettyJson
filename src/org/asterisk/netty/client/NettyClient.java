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
import org.asterisk.netty.packet.Packet.MessageFormat;
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
            Packet packet = new Packet(MessageFormat.PacketCommand, IPacket.PACKET_TYPE_TEST, "{ \"books\": [ { \"genre\": \"소설\", \"price\": \"100\", \"name\": \"사람은 무엇으로 사는가?\", \"writer\": \"톨스토이\", \"publisher\": \"톨스토이 출판사\" }, { \"genre\": \"소설\", \"price\": \"300\", \"name\": \"홍길동전\", \"writer\": \"허균\", \"publisher\": \"허균 출판사\" }, { \"genre\": \"소설\", \"price\": \"300\", \"name\": \"홍길동전\", \"writer\": \"허균\", \"publisher\": \"허균 출판사\" }, { \"genre\": \"소설\", \"price\": \"300\", \"name\": \"홍길동전\", \"writer\": \"허균\", \"publisher\": \"허균 출판사\" }, { \"genre\": \"소설\", \"price\": \"300\", \"name\": \"홍길동전\", \"writer\": \"허균\", \"publisher\": \"허균 출판사\" }, { \"genre\": \"소설\", \"price\": \"300\", \"name\": \"홍길동전\", \"writer\": \"허균\", \"publisher\": \"허균 출판사\" }, { \"genre\": \"소설\", \"price\": \"300\", \"name\": \"홍길동전\", \"writer\": \"허균\", \"publisher\": \"허균 출판사\" }, { \"genre\": \"소설\", \"price\": \"300\", \"name\": \"홍길동전\", \"writer\": \"허균\", \"publisher\": \"허균 출판사\" }, { \"genre\": \"소설\", \"price\": \"300\", \"name\": \"홍길동전\", \"writer\": \"허균\", \"publisher\": \"허균 출판사\" }, { \"genre\": \"소설\", \"price\": \"300\", \"name\": \"홍길동전\", \"writer\": \"허균\", \"publisher\": \"허균 출판사\" }, { \"genre\": \"소설\", \"price\": \"300\", \"name\": \"홍길동전\", \"writer\": \"허균\", \"publisher\": \"허균 출판사\" }, { \"genre\": \"소설\", \"price\": \"900\", \"name\": \"레미제라블\", \"writer\": \"빅토르 위고\", \"publisher\": \"빅토르 위고 출판사\" } ], \"persons\": [ { \"nickname\": \"남궁민수\", \"age\": \"25\", \"name\": \"송강호\", \"gender\": \"남자\" }, { \"nickname\": \"예니콜\", \"age\": \"21\", \"name\": \"전지현\", \"gender\": \"여자\" } ] } ");
            ctx.writeAndFlush(packet);
            _Logger.info(" Client > [{}][{}] ", packet.getMessageFormat(), packet.getMessage());
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
