package me.mystra.hud.draggablehud.hudmods;

import me.mystra.event.EventManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class Mod {
	private boolean isEnabled = true;

	protected final Minecraft mc;
	protected final FontRenderer font;

	public Mod() {
		this.mc = Minecraft.getMinecraft();
		this.font = mc.fontRendererObj;

		setEnabled(isEnabled);
	}

	private void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;

		if(isEnabled) {
			EventManager.register(this);
		}else {
			EventManager.unregister(this);
		}
	}

	public boolean isEnabled() {
		return isEnabled;
	}
}
