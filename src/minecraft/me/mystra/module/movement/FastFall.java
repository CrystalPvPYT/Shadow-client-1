package me.mystra.module.movement;

import me.mystra.Mystra;
import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;
import net.minecraft.block.material.Material;

public class FastFall extends Module {

	public FastFall() {
		super("FastFall", 0, Category.MOVEMENT);
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
		if (mc.thePlayer.isAirBorne && mc.thePlayer.motionY < 0.0D) {
			if (!mc.thePlayer.isOnLadder() && !mc.gameSettings.keyBindJump.isPressed()) {
				if (mc.thePlayer.isInsideOfMaterial(Material.web) && !Mystra.instance.moduleManager.getModuleByName("NoSlowdown").isToggled()) {
					mc.thePlayer.motionY = -7.0D;
	            } else {
	                mc.thePlayer.motionY = -2.0D;
	            }
	         }
	      }
	   }
	@Override
	public void onEnable() {
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
}
