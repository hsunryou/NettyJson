package org.asterisk.netty.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// <editor-fold defaultstate="collapsed" desc="Message">
/*

*/
// </editor-fold>

public class Message {
    
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("type")
    @Expose
    private String type;
    
    private static final Logger     _Logger = LoggerFactory.getLogger(Message.class);
    public Message() {
        
    }

    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    

}
