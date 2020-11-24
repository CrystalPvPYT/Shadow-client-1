package me.mystra.module.player;

import me.mystra.module.Category;
import me.mystra.module.Module;

public class Timer extends Module {
	public Timer() {
		super("Timer", 0, Category.PLAYER);
	}

	public void onUpdate() {
		if (this.isToggled()) {
			net.minecraft.util.Timer.timerSpeed = 20.25F;
		}
	}

	public void onDisable(){
		net.minecraft.util.Timer.timerSpeed = 1.0f;
			super.onDisable();
		}

	@Override
    public void onEnable() {
    	super.onEnable();
    }
}
