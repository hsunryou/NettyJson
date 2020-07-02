package org.asterisk.netty.server.codec;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;
import org.asterisk.netty.message.Message;
import org.asterisk.netty.packet.IPacket;
import org.asterisk.netty.packet.Packet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// <editor-fold defaultstate="collapsed" desc="MessageEncoder">
/*
    - Message 객체를 Packet으로 Encoding하는 Class

*/
// </editor-fold>

public class MessageEncoder extends MessageToMessageEncoder<Message> {

    
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    private static final Logger     _Logger = LoggerFactory.getLogger(MessageEncoder.class);
    public MessageEncoder() {
        _Logger.info(" - MessageEncoder ");
    }

    @Override
    protected void encode(ChannelHandlerContext chc, Message message, List<Object> out) throws Exception {
        _Logger.info(" - encode ");
        Packet packet = new Packet(IPacket.PACKET_FORMAT_JSON, gson.toJson(message));
        out.add(packet);
    }

}
