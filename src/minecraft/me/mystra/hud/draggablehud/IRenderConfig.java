package me.mystra.hud.draggablehud;

public interface IRenderConfig {
	public void save(ScreenPosition pos);

	public ScreenPosition load();
}
