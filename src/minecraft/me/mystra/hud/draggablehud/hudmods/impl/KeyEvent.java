package me.mystra.hud.draggablehud.hudmods.impl;

import me.mystra.event.events.EventCancelable;

public class KeyEvent extends EventCancelable {
	final int key;

	public KeyEvent(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}
}
