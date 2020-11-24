package me.mystra.module.render;

import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;
import net.minecraft.client.Minecraft;

public class NoBob extends Module {
	
    public NoBob() {
		super("NoBobbing", 0, Category.RENDER);
	}

	@EventTarget
    private void onUpdate(final EventUpdate event) {
        Minecraft.getMinecraft().thePlayer.distanceWalkedModified = 0.0f;
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
