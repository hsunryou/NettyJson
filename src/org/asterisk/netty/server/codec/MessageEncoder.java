package org.asterisk.netty.server.codec;

import com.google.gson.Gson;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;
import org.asterisk.packet.json.Message;
import org.asterisk.packet.IPacket;
import org.asterisk.packet.Packet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// <editor-fold defaultstate="collapsed" desc="MessageEncoder">
/*
    - Message 객체를 Packet으로 Encoding하는 Class

*/
// </editor-fold>

public class MessageEncoder extends MessageToMessageEncoder<Message> {

    //private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    /*
        {
          "user": {
            "grade": "A",
            "userid": "user9000"
          },
          "version": "01",
          "format": "C",
          "type": "011"
        }
    */

    private final Gson gson = new Gson();
    /*
        {"user":{"grade":"A","userid":"user9000","password":"password9000"},"version":"01","format":"C","type":"010"}
    */
    
    private static final Logger     _Logger = LoggerFactory.getLogger(MessageEncoder.class);
    public MessageEncoder() {
        _Logger.info(" - MessageEncoder ");
    }

    @Override
    protected void encode(ChannelHandlerContext chc, Message message, List<Object> out) throws Exception {
        _Logger.info(" - encode ");
        _Logger.debug(gson.toJson(message));
        Packet packet = new Packet(IPacket.PACKET_FORMAT_JSON, gson.toJson(message));
        out.add(packet);
    }

}
