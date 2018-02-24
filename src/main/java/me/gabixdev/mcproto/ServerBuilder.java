package me.gabixdev.mcproto;

import java.net.InetSocketAddress;

public class ServerBuilder {
    private InetSocketAddress bindAddress;
    private int timeout;

    public ServerBuilder() {
        this.bindAddress = new InetSocketAddress(25565);
        this.timeout = 10;
    }

    public ServerBuilder setBindAddress(InetSocketAddress bindAddress) {
        this.bindAddress = bindAddress;
        return this;
    }

    public ServerBuilder setTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public Server build() {
        return new Server(bindAddress, timeout);
    }
}
