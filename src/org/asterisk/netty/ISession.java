package org.asterisk.netty;

import io.netty.channel.ChannelHandlerContext;


public interface ISession {
    
    public void OnChannelActive( ChannelHandlerContext ctx );
    public void OnChannelInactive( ChannelHandlerContext ctx );
    
}
