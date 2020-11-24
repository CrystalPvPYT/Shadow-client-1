package me.mystra.module.movement;

import org.lwjgl.input.Keyboard;

import me.mystra.module.Category;
import me.mystra.module.Module;

public class Jesus extends Module{
	public Jesus() {
		super("Jesus", Keyboard.KEY_L, Category.MOVEMENT);
	}
}
