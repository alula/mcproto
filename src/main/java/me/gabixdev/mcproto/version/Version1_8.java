package me.gabixdev.mcproto.version;

import me.gabixdev.mcproto.packet.PacketCodec;
import me.gabixdev.mcproto.packet.codec.mc18.client.play.KeepAlivePacketCodec;

import java.util.HashMap;

public class Version1_8 extends Version {
    private static HashMap<Byte, PacketCodec> idMapClientBound;
    private static HashMap<Byte, PacketCodec> idMapServerBound;
    static {
        idMapClientBound = new HashMap<Byte, PacketCodec>();
        idMapClientBound.put((byte) 0, new KeepAlivePacketCodec());
    }

    public Version1_8() {
        super("1.8", 47, idMapClientBound, idMapServerBound);
    }
}
