package me.mystra.module.misc;

import java.util.ArrayList;

import me.mystra.Mystra;
import me.mystra.clickgui.settings.Setting;
import me.mystra.module.Category;
import me.mystra.module.Module;

public class Cosmetics extends Module {
	
	public Cosmetics() {
		super("Cosmetics", 0, Category.MISC);
		
		ArrayList<String> options = new ArrayList<>();

		Mystra.instance.settingsManager.rSetting(new Setting("Hat", this, true));
		Mystra.instance.settingsManager.rSetting(new Setting("Cape", this, true));
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
