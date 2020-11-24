package me.mystra.module.movement;

import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;
import me.mystra.utils.player.PlayerUtils;

public class Strafe extends Module {

    public Strafe() {
        super("Strafe", 0, Category.MOVEMENT);
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
    	if (this.mc.thePlayer.hurtTime > 0) {
            return;
        }
        PlayerUtils.setSpeed((float)Math.sqrt(this.mc.thePlayer.motionX * this.mc.thePlayer.motionX + this.mc.thePlayer.motionZ * this.mc.thePlayer.motionZ));
    }
}

