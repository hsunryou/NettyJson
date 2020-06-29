package org.asterisk.netty.server.handler;

import com.google.gson.Gson;
import io.netty.channel.ChannelHandlerContext;
import org.asterisk.netty.client.NettyClient;
import org.asterisk.netty.packet.Packet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonSnapshotResponseHandler extends ChannelInboundHandlerBase<Packet> {

    private final Gson gson = new Gson();

    
    private static final Logger     _Logger = LoggerFactory.getLogger(JsonSnapshotResponseHandler.class);
    public JsonSnapshotResponseHandler() {
    }
    
    

    @Override
    public boolean acceptInboundMessage(Object obj) {
        return (obj instanceof Packet) ? ((Packet) obj).type == Packet.MessageType.SnapshotResponse : false;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext chc, Packet packet) throws Exception {
        
        _Logger.info(" - channelRead0 : {}", packet.toString());
        
        /*
        MetaDataSnapshot metadata =  gson.fromJson(packet.message, MetaDataSnapshot.class);
        sendMetaDataToClient(chc, metadata);
        */
    }
}
