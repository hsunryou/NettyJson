package org.asterisk.netty.message.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.asterisk.netty.message.IMessage;
import org.asterisk.netty.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// <editor-fold defaultstate="collapsed" desc="ResponseMessage">
/*

*/
// </editor-fold>

public class ResponseMessage extends Message{

    
    @SerializedName("result")
    @Expose
    private String result;
    
    @SerializedName("code")
    @Expose
    private String code;
    
    @SerializedName("data")
    @Expose
    private String data;
    
    private static final Logger     _Logger = LoggerFactory.getLogger(ResponseMessage.class);
    public ResponseMessage() {
        
    }
    public ResponseMessage( Message message, String result, String code ) {
        setVersion(message.getVersion());
        setFormat(IMessage.MESSAGE_FORMAT_RESPONSE);
        setType(message.getType());
        setResult(result);
        setCode(code);
        _Logger.info(" - ResponseMessage : {} ", getType());
    }
    public ResponseMessage( Message message, String result, String code, String data ) {
        setVersion(message.getVersion());
        setFormat(IMessage.MESSAGE_FORMAT_RESPONSE);
        setType(message.getType());
        setResult(result);
        setCode(code);
        setData(data);
        _Logger.info(" - ResponseMessage : {} ", getType());
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
