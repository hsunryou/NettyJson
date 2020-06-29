package org.asterisk.netty.server.codec;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;
import java.util.List;
import org.asterisk.netty.packet.Packet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




// <editor-fold defaultstate="collapsed" desc="JsonDecoder">
/*
    - Outbound Data를 한 Format에서 다른 Format으로 변환하는 코덱
      1) 아웃바운드 데이타 처리하는 코덱으로 ChannelOutboundHandler를 상속받는다
      2) MessageToByteEncorder     : 메세지를 Byte로 Encode
         MessageToMessageEncorder  : Message를 다른 Message로 Encode

      3) https://juyoung-1008.tistory.com/21 사이트 참조

*/
// </editor-fold>
public class JsonEncoder extends MessageToMessageEncoder<Packet> {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static final Logger     _Logger = LoggerFactory.getLogger(JsonEncoder.class);
    public JsonEncoder() {
        _Logger.info(" - JsonEncoder ");
    }


    @Override
    protected void encode(ChannelHandlerContext chc, Packet packet, List<Object> out) throws Exception {
        _Logger.info(" - encode ");
        String json = gson.toJson(packet);
        ByteBuf buffer = Unpooled.copiedBuffer(json, CharsetUtil.UTF_8);
        out.add(buffer);
    }
}
