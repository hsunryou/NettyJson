package org.asterisk.packet.json.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.asterisk.packet.json.IMessage;
import org.asterisk.packet.json.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// <editor-fold defaultstate="collapsed" desc="BigResponseMessage">
/*
    - Packet Size(2^16) 만큼 크기의 Response 객체
      1) Client단에서 정상적으로 수신 기능 체크 용도
      2) 

*/
// </editor-fold>

public class BigResponseMessage extends Message {
    
    @SerializedName("result")
    @Expose
    private String result;
    
    @SerializedName("code")
    @Expose
    private String code;
    
    @SerializedName("data")
    @Expose
    private String data;
    
    private static final Logger     _Logger = LoggerFactory.getLogger(BigResponseMessage.class);
    public BigResponseMessage() {
        
    }

    public BigResponseMessage(Message message, String result, String code) {
        setVersion(message.getVersion());
        setFormat(IMessage.MESSAGE_FORMAT_RESPONSE);
        setType(message.getType());
        
        StringBuilder stringBuilder1 = new StringBuilder();
        for( int index=0 ; index<500 ; index++ ){
            stringBuilder1.append(String.format("%d", index));
        }
        setResult(new String(stringBuilder1));
        
        StringBuilder stringBuilder2 = new StringBuilder();
        for( int index=0 ; index<500 ; index++ ){
            stringBuilder2.append(String.format("%d", index));
        }
        setCode(new String(stringBuilder2));
        
        _Logger.info(" - BigResponseMessage : {} ", getType());
    }

    
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    

}
