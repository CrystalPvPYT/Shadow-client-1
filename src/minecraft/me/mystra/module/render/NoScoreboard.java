package me.mystra.module.render;

import me.mystra.Mystra;
import me.mystra.clickgui.settings.Setting;
import me.mystra.module.Category;
import me.mystra.module.Module;

public class NoScoreboard extends Module {

	public NoScoreboard() {
		super("NoScoreboard", 0, Category.RENDER);
		
		Mystra.instance.settingsManager.rSetting(new Setting("Position", this, 0, -150, 200, false));
	}

}
