package me.mystra.module.player;

import me.mystra.event.EventManager;
import me.mystra.event.EventTarget;
import me.mystra.event.events.EventSendPacket;
import me.mystra.module.Category;
import me.mystra.module.Module;
import net.minecraft.network.status.client.C01PacketPing;

public class PingSpoof extends Module {

	public PingSpoof() {
		super("PingSpoof", 0, Category.PLAYER);
	}
	
	@Override
    public void onEnable() {
        EventManager.register(this);
    }
    
    @Override
    public void onDisable() {
        EventManager.unregister(this);
    }
    
    @EventTarget
    public void onSendPacket(final EventSendPacket event) {
        if (event.packet instanceof C01PacketPing) {
            final C01PacketPing packet = (C01PacketPing)event.packet;
            packet.clientTime = 0L;
            event.packet = packet;
        }
    }

}
