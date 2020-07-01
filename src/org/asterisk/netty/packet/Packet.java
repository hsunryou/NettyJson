package org.asterisk.netty.packet;

import com.google.gson.annotations.SerializedName;

public class Packet {

    public enum PacketFormat {
        @SerializedName("J")
        PacketJson,
        @SerializedName("G")
        PacketGoogle
    }

    private PacketFormat        format;
    
    private String              message = null;

    public Packet(PacketFormat format, String message) {
        this.format = format;
        this.message = message;
    }

    public PacketFormat getPacketFormat() {
        return format;
    }
    public String getMessage() {
        return message;
    }
    
    
}
