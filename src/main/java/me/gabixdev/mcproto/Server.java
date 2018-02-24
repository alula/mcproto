package me.gabixdev.mcproto;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    private InetSocketAddress listenAddress;
    private int timeout;
    private final EventLoopGroup bossgroup;
    private boolean running;

    public Server(InetSocketAddress listenAddress, int timeout) {
        this.listenAddress = listenAddress;
        this.bossgroup = new NioEventLoopGroup();
        this.timeout = timeout;
    }

    public void run() throws IOException {
        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(bossgroup)
                .channel(NioServerSocketChannel.class)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                .addLast("timeout", new ReadTimeoutHandler(timeout));
                    }
                });
    }

    public InetSocketAddress getListenAddress() {
        return listenAddress;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
