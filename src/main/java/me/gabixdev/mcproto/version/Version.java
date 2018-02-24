package me.gabixdev.mcproto.version;

import me.gabixdev.mcproto.packet.PacketCodec;

import java.util.HashMap;

public abstract class Version {
    private final String name;
    private final int protocolNumber;
    private final HashMap<Byte, PacketCodec> idMapClientBound;
    private final HashMap<Byte, PacketCodec> idMapServerBound;

    public Version(String name, int protocolNumber, HashMap<Byte, PacketCodec> idMapClientBound, HashMap<Byte, PacketCodec> idMapServerBound) {
        this.name = name;
        this.protocolNumber = protocolNumber;
        this.idMapClientBound = idMapClientBound;
        this.idMapServerBound = idMapServerBound;
    }

    public String getName() {
        return name;
    }

    public int getProtocolNumber() {
        return protocolNumber;
    }

    public HashMap<Byte, PacketCodec> getIdMapClientBound() {
        return idMapClientBound;
    }

    public HashMap<Byte, PacketCodec> getIdMapServerBound() {
        return idMapServerBound;
    }
}
