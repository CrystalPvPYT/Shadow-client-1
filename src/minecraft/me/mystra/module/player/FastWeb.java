package me.mystra.module.player;

import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;

public class FastWeb extends Module {

	public FastWeb() {
		super("FastWeb", 0, Category.PLAYER);
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
		 if ((mc.thePlayer.fallDistance > 3.0F) && (!mc.thePlayer.onGround)) {
			mc.thePlayer.motionY = -4.17F;
		}
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}

	@Override
	public void onEnable() {
		onDisable();
	}
}
