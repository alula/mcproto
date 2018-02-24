package me.gabixdev.mcproto.packet;

public abstract class PacketCodec<T extends Packet> {
    public T decode(byte[] data) {
        return null;
    }

    public byte[] encode(T packet) {
        return null;
    }
}
