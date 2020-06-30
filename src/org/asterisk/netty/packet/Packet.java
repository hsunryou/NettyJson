package org.asterisk.netty.packet;

import com.google.gson.annotations.SerializedName;

public class Packet {

    public enum MessageFormat {
        @SerializedName("C")
        PacketCommand,
        @SerializedName("R")
        PacketResponse,
        @SerializedName("E")
        PacketEvent
    }

    private MessageFormat       format;
    private String              type = null;
    private String              message = null;

    public Packet(MessageFormat format, String type, String message) {
        this.format = format;
        this.type = type;
        this.message = message;
    }

    public MessageFormat getMessageFormat() {
        return format;
    }
    public String getMessageType() {
        return type;
    }
    public String getMessage() {
        return message;
    }
    
    
}
