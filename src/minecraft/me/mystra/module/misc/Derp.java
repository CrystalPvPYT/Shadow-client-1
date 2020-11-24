package me.mystra.module.misc;

import java.util.Random;

import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;

public class Derp extends Module {

	public static boolean mode = false;
	
	public Derp() {
		super("Derp", 0, Category.MISC);
	}
	
	
	@EventTarget
	public void onUpdate(EventUpdate e) {
		Random rand = new Random();
		int yaw = rand.nextInt((1000 - 0) + 1) + 0;
		int pitch = rand.nextInt((1000 - 0) + 1) + 0;
		mc.thePlayer.rotationYawHead = yaw;
		mc.thePlayer.rotationPitch = pitch;
	}

}
