package me.mystra.module.player;

import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;

public class FastBreak extends Module {
	public FastBreak() {
		super("FastBreak", 0, Category.PLAYER);
	}

	@EventTarget
	public void onUpdate(EventUpdate event){
	if (mc.playerController.curBlockDamageMP > 0.8F) {
		    mc.playerController.curBlockDamageMP = 1.0F;
		}
		mc.playerController.blockHitDelay = 0;
	}

	@Override
	public void onDisable(){
		super.onDisable();
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
	}
}
