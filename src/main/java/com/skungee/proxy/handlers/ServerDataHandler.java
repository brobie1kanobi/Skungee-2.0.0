package com.skungee.proxy.handlers;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import com.sitrica.japson.gson.JsonObject;
import com.sitrica.japson.shared.Executor;
import com.skungee.proxy.ServerDataManager;
import com.skungee.proxy.ServerDataManager.ServerData;
import com.skungee.shared.Packets;
import com.skungee.shared.serializers.SkungeeServerDataSerializer;

public class ServerDataHandler extends Executor {

	public ServerDataHandler() {
		super(Packets.SERVER_DATA.getPacketId());
	}

	@Override
	public void execute(InetAddress address, int port, JsonObject object) {
		ServerDataManager.set(new InetSocketAddress(object.get("address").getAsString(), object.get("port").getAsInt()), new SkungeeServerDataSerializer().deserialize(object, ServerData.class, null));
	}

}
