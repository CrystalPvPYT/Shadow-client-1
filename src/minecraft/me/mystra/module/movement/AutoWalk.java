package me.mystra.module.movement;

import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;

public class AutoWalk extends Module{
	public AutoWalk() {
		super("AutoWalk", 0, Category.MOVEMENT);
	}

	@EventTarget
    public void onUpdate(EventUpdate event){
        mc.gameSettings.keyBindForward.pressed = true;
    }
    @Override
    public void onDisable(){
        super.onDisable();
    }

    @Override
    public void onEnable(){
        super.onEnable();
    }
}
