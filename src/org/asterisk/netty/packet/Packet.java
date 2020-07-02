package org.asterisk.netty.packet;

public class Packet {

    /*
    public enum PacketFormat {
        @SerializedName("J")
        PacketJson,
        @SerializedName("G")
        PacketGoogle
    }
    */

    private byte                format;
    private String              message = null;

    public Packet(byte format, String message) {
        this.format = format;
        this.message = message;
    }

    public byte getPacketFormat() {
        return format;
    }
    public String getMessage() {
        return message;
    }
    
    
}
