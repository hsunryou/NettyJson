package org.asterisk.netty.server.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;
import org.asterisk.packet.json.Message;
import org.asterisk.packet.json.MessageFactory;
import org.asterisk.packet.Packet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



// <editor-fold defaultstate="collapsed" desc="MessageDecoder">
/*

*/
// </editor-fold>

public class MessageDecoder extends MessageToMessageDecoder<Packet> {

    private static final Logger     _Logger = LoggerFactory.getLogger(MessageDecoder.class);
    public MessageDecoder() {
        _Logger.info(" - MessageDecoder ");
    }

    
    @Override
    protected void decode(ChannelHandlerContext chc, Packet packet, List<Object> out) throws Exception {
        _Logger.info(" - decode ");
        Message message = MessageFactory.createMessage(packet.getMessage());
        if( message == null ){
            _Logger.warn(" - Message[{}] is NULL", packet.getMessage());
            return;
        }
        out.add(message);
    }

}
