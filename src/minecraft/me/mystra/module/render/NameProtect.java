package me.mystra.module.render;

import me.mystra.module.Category;
import me.mystra.module.Module;

public class NameProtect extends Module {

	public static boolean isEnabled = false;
	public static String fakename = "§bMystra";
	
	public NameProtect() {
		super("NameProtect", 0, Category.RENDER);
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
	}

}
