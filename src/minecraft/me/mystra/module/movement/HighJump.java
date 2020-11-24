package me.mystra.module.movement;

import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class HighJump extends Module
{
	public static float jump = 2;
	public HighJump() {
		super("HighJump", 0, Category.MOVEMENT);
	}

	@EventTarget
    public void onUpdate(EventUpdate event) {
            mc.thePlayer.removePotionEffect(Potion.jump.id);
            mc.thePlayer.addPotionEffect(new PotionEffect(Potion.jump.id, 999, (int) jump));
    }

    @Override
    public void onDisable() {
            mc.thePlayer.removePotionEffect(Potion.jump.id);
            super.onDisable();
    }

    public static float getJump() {
            return jump;
    }
}
