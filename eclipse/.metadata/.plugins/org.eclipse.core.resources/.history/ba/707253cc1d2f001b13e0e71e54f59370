package me.mystra.module.misc;

import java.util.ArrayList;

import me.mystra.Mystra;
import me.mystra.clickgui.settings.Setting;
import me.mystra.module.Category;
import me.mystra.module.Module;

public class HUD extends Module {
	
	public HUD() {
		super("HUD", 0, Category.MISC);

		ArrayList<String> options = new ArrayList<>();
		options.add("New");
        options.add("Old");
        options.add("Old2");
        options.add("Novoline");
        Mystra.instance.settingsManager.rSetting(new Setting("ArrayLists", this, "Novoline", options));
        
        ArrayList<String> capes = new ArrayList<>();
        capes.add("Shadow");
        capes.add("Small");
        
        Mystra.instance.settingsManager.rSetting(new Setting("Cape Mode", this, "Mystra", capes));
        
        ArrayList<String> theme = new ArrayList<>();
        theme.add("Shadow");
        theme.add("Cheese");
        Mystra.instance.settingsManager.rSetting(new Setting("Theme", this, "Mystra", theme));
        Mystra.instance.settingsManager.rSetting(new Setting("ArrayListFont", this, false));
        Mystra.instance.settingsManager.rSetting(new Setting("ArmorStatus", this, false));
        Mystra.instance.settingsManager.rSetting(new Setting("Keystrokes", this, false));
        Mystra.instance.settingsManager.rSetting(new Setting("Watermark", this, true));
        Mystra.instance.settingsManager.rSetting(new Setting("TabGui", this, true));
        Mystra.instance.settingsManager.rSetting(new Setting("FPS", this, false));
        Mystra.instance.settingsManager.rSetting(new Setting("CPS", this, false));
	}
}
