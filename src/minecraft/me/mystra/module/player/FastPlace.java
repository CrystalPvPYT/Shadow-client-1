package me.mystra.module.player;

import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;

public class FastPlace extends Module {
	public FastPlace() {
		super("Fastplace", 0, Category.PLAYER);
	}

	@EventTarget
	public void onUpdate(EventUpdate event) {
		if (this.isToggled()) {
			mc.rightClickDelayTimer = 0;
		}
	}

	public void onDisable() {
		mc.rightClickDelayTimer = 6;
			super.onDisable();
		}

	@Override
    public void onEnable() {
    	super.onEnable();
    }
}