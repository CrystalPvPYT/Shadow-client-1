package me.mystra.module.movement;

import org.lwjgl.input.Keyboard;

import me.mystra.Mystra;
import me.mystra.clickgui.settings.Setting;
import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;

public class Step extends Module {
    public Step() {
        super("Step", Keyboard.KEY_L, Category.MOVEMENT);
        
        Mystra.instance.settingsManager.rSetting(new Setting("Step Height", this, 1.0F, 0.5F, 2F, false));
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        mc.thePlayer.stepHeight = (float) Mystra.instance.settingsManager.getSettingByName("Step Height").getValDouble();
    }

    @Override
    public void onDisable() {
    	mc.thePlayer.stepHeight = 0.5F;
        super.onDisable();
    }
}
