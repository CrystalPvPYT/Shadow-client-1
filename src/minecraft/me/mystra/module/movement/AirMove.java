package me.mystra.module.movement;

import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;
import net.minecraft.client.Minecraft;

public class AirMove extends Module {

	private boolean onGround;
	
	public AirMove() {
		super("AirMove", 0, Category.MOVEMENT);
	}
	
	@EventTarget
	   public void onUpdate(EventUpdate event) {
	      this.onGround = Minecraft.getMinecraft().thePlayer.onGround;
	      Minecraft.getMinecraft().thePlayer.onGround = true;
	   }

	   public boolean isOnGround() {
	      return this.onGround;
	   }

}
