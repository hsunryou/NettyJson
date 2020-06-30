package org.asterisk.netty.server.codec;

import com.google.gson.Gson;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;
import java.util.List;
import org.asterisk.netty.packet.Packet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// <editor-fold defaultstate="collapsed" desc="JsonDecoder">
/*
    - Network Streams을 JSON Format으로 변환하는 코덱
      1) 인바운드 데이타 처리하는 코덱으로 ChannelInboundHandler를 상속받는다
      2) ByteToMessageDecorder / ReplayingDecorder : Byte Stream을 Messsge로 Decode
         MessageToMessageDecorder                  : Message를 다른 Message로 Decode

      3) https://juyoung-1008.tistory.com/21 사이트 참조

*/
// </editor-fold>
public class JsonDecoder extends MessageToMessageDecoder<ByteBuf> {

    private final Gson gson = new Gson();

    private static final Logger     _Logger = LoggerFactory.getLogger(JsonDecoder.class);
    public JsonDecoder() {
        _Logger.info(" - JsonDecoder ");
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {
        _Logger.info(" - decode ");
        String json = buf.toString(CharsetUtil.UTF_8);
        Packet packet = gson.fromJson(json, Packet.class);
        out.add(packet);
    }
}
