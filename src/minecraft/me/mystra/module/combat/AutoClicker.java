package me.mystra.module.combat;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import io.netty.util.internal.ThreadLocalRandom;
import me.mystra.Mystra;
import me.mystra.clickgui.settings.Setting;
import me.mystra.event.EventTarget;
import me.mystra.event.events.ClientTickEvent;
import me.mystra.module.Category;
import me.mystra.module.Module;
import net.minecraft.client.settings.KeyBinding;

public class AutoClicker extends Module {

	private long lastClick;
	private long hold;
	
	private double speed;
	private double holdLenght;
	private double min;
	private double max;
	
	public AutoClicker() {
		super("AutoClicker", Keyboard.KEY_M, Category.COMBAT);
		
		Mystra.instance.settingsManager.rSetting(new Setting("MinCPS", this, 8, 1, 20, false));
		Mystra.instance.settingsManager.rSetting(new Setting("MaxCPS", this, 12, 1, 20, false));
	}
	
	@EventTarget
	public void onTick(ClientTickEvent e) {
		 if(Mouse.isButtonDown(0)) {
			 if(System.currentTimeMillis() - lastClick > speed * 1000) {
				  lastClick = System.currentTimeMillis();
				  if(hold < lastClick) {
					  hold = lastClick;
				  }
				  int key = mc.gameSettings.keyBindAttack.getKeyCode();
				  KeyBinding.setKeyBindState (key, true);
				  KeyBinding.onTick(key);
				  this.updateVals();
			 } else if (System.currentTimeMillis() - hold > holdLenght * 1000) {
				 KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
				 this.updateVals();
			 }
		 }
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		this.updateVals();
	}
	
	private void updateVals() {
		min = Mystra.instance.settingsManager.getSettingByName("MinCPS").getValDouble();
		max = Mystra.instance.settingsManager.getSettingByName("MinCPS").getValDouble();
		if(min >= max) {
			max = min + 1;
		}
		speed = 1.0 / ThreadLocalRandom.current().nextDouble(min - 0.2, max);
		holdLenght = speed / ThreadLocalRandom.current().nextDouble(min, max); 
	}
}
