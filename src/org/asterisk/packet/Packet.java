package org.asterisk.packet;


// <editor-fold defaultstate="collapsed" desc="Packet">
/*
    [2020-07-03 11:12:18] INFO  i.n.handler.logging.LoggingHandler [id: 0x15f1a67d, L:/127.0.0.1:20000 - R:/127.0.0.1:61422] WRITE: 2B
             +-------------------------------------------------+
             |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
    +--------+-------------------------------------------------+----------------+
    |00000000| 00 63                                           |.c              |
    +--------+-------------------------------------------------+----------------+
    [2020-07-03 11:12:18] INFO  i.n.handler.logging.LoggingHandler [id: 0x15f1a67d, L:/127.0.0.1:20000 - R:/127.0.0.1:61422] WRITE: 97B
             +-------------------------------------------------+
             |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
    +--------+-------------------------------------------------+----------------+
    |00000000| 4a 7b 0a 20 20 22 72 65 73 75 6c 74 22 3a 20 22 |J{.  "result": "|
    |00000010| 53 75 63 63 65 73 73 22 2c 0a 20 20 22 63 6f 64 |Success",.  "cod|
    |00000020| 65 22 3a 20 22 30 30 30 30 22 2c 0a 20 20 22 76 |e": "0000",.  "v|
    |00000030| 65 72 73 69 6f 6e 22 3a 20 22 30 31 22 2c 0a 20 |ersion": "01",. |
    |00000040| 20 22 66 6f 72 6d 61 74 22 3a 20 22 52 22 2c 0a | "format": "R",.|
    |00000050| 20 20 22 74 79 70 65 22 3a 20 22 30 31 31 22 0a |  "type": "011".|
    |00000060| 7d                                              |}               |
    +--------+-------------------------------------------------+----------------+
*/
// </editor-fold>
public class Packet {

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
