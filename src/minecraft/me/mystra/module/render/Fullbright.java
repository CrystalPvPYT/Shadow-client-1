package me.mystra.module.render;

import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;

public class Fullbright extends Module{
	public Fullbright() {
		super("Fullbright", 0, Category.RENDER);
	}

	public void onUpdate(EventUpdate e) {
		if(this.isToggled()) {
			mc.gameSettings.gammaSetting = 1000f;
		}else {
			mc.gameSettings.gammaSetting = 0f;
		}
	}

	@Override
    public void onEnable() {
		mc.gameSettings.gammaSetting = 1000f;
    	super.onEnable();
    }

	@Override
	public void onDisable() {
		mc.gameSettings.gammaSetting = 0f;
		super.onDisable();
	}
}
