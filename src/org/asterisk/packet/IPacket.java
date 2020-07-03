package org.asterisk.packet;


public interface IPacket {
    
    // Packet Format - JSON, ..
    public static final byte            PACKET_FORMAT_JSON               = 0x4A;        // J
    
    
    // Packet Service Type
    
    //   System(Heartbeat)
    public static final String         PACKET_TYPE_HEARBEAT                 = "000";
    
    //   User(Agent, Manager, Root)
    public static final String         PACKET_TYPE_USER_LOGIN               = "010";         // Login Service
    public static final String         PACKET_TYPE_USER_LOGOUT              = "011";         // Logout Service
    
    //   Phone
    public static final String         PACKET_TYPE_PHONE_LOGIN              = "050";         // Login Service
    public static final String         PACKET_TYPE_PHONE_LOGOUT             = "051";         // Login Service
    

    
}
