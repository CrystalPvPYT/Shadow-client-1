package me.mystra.module.render;

import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

public class AntiFire extends Module {

	public AntiFire() {
		super("AntiFire", 0, Category.RENDER);
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
		if (!mc.thePlayer.capabilities.isCreativeMode && mc.thePlayer.onGround
				&& mc.thePlayer.isBurning())
			for (int i = 0; i < 100; i++)
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer());
	}

}
