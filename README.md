# NettyJson


Server
    1) Execute Server
        - java -jar .\dist\NettyJson.jar
    2) Log

        [2020-06-29 14:07:34] DEBUG io.netty.buffer.AbstractByteBuf -Dio.netty.buffer.checkAccessible: true
        [2020-06-29 14:07:34] DEBUG io.netty.buffer.AbstractByteBuf -Dio.netty.buffer.checkBounds: true
        [2020-06-29 14:07:34] DEBUG i.n.util.ResourceLeakDetectorFactory Loaded default ResourceLeakDetector: io.netty.util.ResourceLeakDetector@898c930
        [2020-06-29 14:07:34] DEBUG i.n.handler.logging.LoggingHandler [id: 0xedf1fac7, L:/127.0.0.1:20000 - R:/127.0.0.1:49354] READ: 58B
                 +-------------------------------------------------+
                 |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
        +--------+-------------------------------------------------+----------------+
        |00000000| 00 3a 7b 0a 20 20 22 74 79 70 65 22 3a 20 22 30 |.:{.  "type": "0|
        |00000010| 22 2c 0a 20 20 22 6d 65 73 73 61 67 65 22 3a 20 |",.  "message": |
        |00000020| 22 7b 20 5c 22 74 79 70 65 5c 22 3a 5c 22 6c 6f |"{ \"type\":\"lo|
        |00000030| 67 69 6e 5c 22 20 7d 22 0a 7d                   |gin\" }".}      |
        +--------+-------------------------------------------------+----------------+
        [2020-06-29 14:07:34] INFO  o.a.netty.server.codec.JsonDecoder  - decode
        [2020-06-29 14:07:34] INFO  o.a.netty.server.ServerHandler  - channelRead0
        [2020-06-29 14:07:34] INFO  o.a.netty.server.ServerHandler   Server < [EnterWorldResponse][{ "type":"login" }]
        [2020-06-29 14:07:35] INFO  o.a.netty.server.codec.JsonEncoder  - encode
        [2020-06-29 14:07:35] DEBUG i.n.handler.logging.LoggingHandler [id: 0xedf1fac7, L:/127.0.0.1:20000 - R:/127.0.0.1:49354] WRITE: 2B
                 +-------------------------------------------------+
                 |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
        +--------+-------------------------------------------------+----------------+
        |00000000| 00 2e                                           |..              |
        +--------+-------------------------------------------------+----------------+
        [2020-06-29 14:07:35] DEBUG i.n.handler.logging.LoggingHandler [id: 0xedf1fac7, L:/127.0.0.1:20000 - R:/127.0.0.1:49354] WRITE: 44B
                 +-------------------------------------------------+
                 |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
        +--------+-------------------------------------------------+----------------+
        |00000000| 7b 0a 20 20 22 74 79 70 65 22 3a 20 22 32 22 2c |{.  "type": "2",|
        |00000010| 0a 20 20 22 6d 65 73 73 61 67 65 22 3a 20 22 7b |.  "message": "{|
        |00000020| 31 32 33 34 35 36 37 38 7d 22 0a 7d             |12345678}".}    |
        +--------+-------------------------------------------------+----------------+
        [2020-06-29 14:07:35] DEBUG i.n.handler.logging.LoggingHandler [id: 0xedf1fac7, L:/127.0.0.1:20000 - R:/127.0.0.1:49354] FLUSH
        [2020-06-29 14:07:35] DEBUG i.n.handler.logging.LoggingHandler [id: 0xedf1fac7, L:/127.0.0.1:20000 - R:/127.0.0.1:49354] READ COMPLETE



Client
    1) Execute client
        - java -cp .\dist\NettyJson.jar org.asterisk.netty.client.NettyClient

    2) Log
        [2020-06-29 14:07:34] DEBUG i.n.handler.logging.LoggingHandler [id: 0x840d6fa4] REGISTERED
        [2020-06-29 14:07:34] DEBUG i.n.handler.logging.LoggingHandler [id: 0x840d6fa4] CONNECT: /127.0.0.1:20000
        [2020-06-29 14:07:34] DEBUG i.n.handler.logging.LoggingHandler [id: 0x840d6fa4, L:/127.0.0.1:49354 - R:/127.0.0.1:20000] ACTIVE
        [2020-06-29 14:07:34] INFO  o.a.n.s.h.ChannelOnActiveHandler  - channelActive
        [2020-06-29 14:07:34] INFO  o.asterisk.netty.client.NettyClient  - OnChannelActive :
        [2020-06-29 14:07:34] INFO  o.a.netty.server.codec.JsonEncoder  - encode
        [2020-06-29 14:07:34] DEBUG io.netty.buffer.AbstractByteBuf -Dio.netty.buffer.checkAccessible: true
        [2020-06-29 14:07:34] DEBUG io.netty.buffer.AbstractByteBuf -Dio.netty.buffer.checkBounds: true
        [2020-06-29 14:07:34] DEBUG i.n.util.ResourceLeakDetectorFactory Loaded default ResourceLeakDetector: io.netty.util.ResourceLeakDetector@942e0bf
        [2020-06-29 14:07:34] DEBUG io.netty.util.Recycler -Dio.netty.recycler.maxCapacityPerThread: 4096
        [2020-06-29 14:07:34] DEBUG io.netty.util.Recycler -Dio.netty.recycler.maxSharedCapacityFactor: 2
        [2020-06-29 14:07:34] DEBUG io.netty.util.Recycler -Dio.netty.recycler.linkCapacity: 16
        [2020-06-29 14:07:34] DEBUG io.netty.util.Recycler -Dio.netty.recycler.ratio: 8
        [2020-06-29 14:07:34] DEBUG i.n.handler.logging.LoggingHandler [id: 0x840d6fa4, L:/127.0.0.1:49354 - R:/127.0.0.1:20000] WRITE: 2B
                 +-------------------------------------------------+
                 |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
        +--------+-------------------------------------------------+----------------+
        |00000000| 00 3a                                           |.:              |
        +--------+-------------------------------------------------+----------------+
        [2020-06-29 14:07:34] DEBUG i.n.handler.logging.LoggingHandler [id: 0x840d6fa4, L:/127.0.0.1:49354 - R:/127.0.0.1:20000] WRITE: 56B
                 +-------------------------------------------------+
                 |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
        +--------+-------------------------------------------------+----------------+
        |00000000| 7b 0a 20 20 22 74 79 70 65 22 3a 20 22 30 22 2c |{.  "type": "0",|
        |00000010| 0a 20 20 22 6d 65 73 73 61 67 65 22 3a 20 22 7b |.  "message": "{|
        |00000020| 20 5c 22 74 79 70 65 5c 22 3a 5c 22 6c 6f 67 69 | \"type\":\"logi|
        |00000030| 6e 5c 22 20 7d 22 0a 7d                         |n\" }".}        |
        +--------+-------------------------------------------------+----------------+
        [2020-06-29 14:07:34] DEBUG i.n.handler.logging.LoggingHandler [id: 0x840d6fa4, L:/127.0.0.1:49354 - R:/127.0.0.1:20000] FLUSH
        [2020-06-29 14:07:34] INFO  o.asterisk.netty.client.NettyClient  Client > [EnterWorldResponse][{ "type":"login" }]
        [2020-06-29 14:07:35] DEBUG i.n.handler.logging.LoggingHandler [id: 0x840d6fa4, L:/127.0.0.1:49354 - R:/127.0.0.1:20000] READ: 46B
                 +-------------------------------------------------+
                 |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
        +--------+-------------------------------------------------+----------------+
        |00000000| 00 2e 7b 0a 20 20 22 74 79 70 65 22 3a 20 22 32 |..{.  "type": "2|
        |00000010| 22 2c 0a 20 20 22 6d 65 73 73 61 67 65 22 3a 20 |",.  "message": |
        |00000020| 22 7b 31 32 33 34 35 36 37 38 7d 22 0a 7d       |"{12345678}".}  |
        +--------+-------------------------------------------------+----------------+
        [2020-06-29 14:07:35] INFO  o.a.netty.server.codec.JsonDecoder  - decode
        [2020-06-29 14:07:35] INFO  o.a.n.client.handler.ClientHandler  - channelRead0
        [2020-06-29 14:07:35] INFO  o.a.n.client.handler.ClientHandler  Client < [TargetPositionRequest][{12345678}]
        [2020-06-29 14:07:35] DEBUG i.n.handler.logging.LoggingHandler [id: 0x840d6fa4, L:/127.0.0.1:49354 - R:/127.0.0.1:20000] READ COMPLETE