package org.asterisk.netty.packet;

import com.google.gson.annotations.SerializedName;

public class Packet {

    public enum MessageType {
        @SerializedName("0")
        EnterWorldResponse,
        @SerializedName("1")
        SnapshotResponse,
        @SerializedName("2")
        TargetPositionRequest
    }

    public MessageType type;
    public String message;

    
    public Packet(MessageType type, String message) {
        this.type = type;
        this.message = message;
    }

    public MessageType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
    
    
}
