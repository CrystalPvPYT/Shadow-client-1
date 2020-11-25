package me.mystra.module.render;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import me.mystra.Mystra;
import me.mystra.clickgui.settings.Setting;
import me.mystra.module.Category;
import me.mystra.module.Module;

public class ClickGUI extends Module {
    public ClickGUI() {
        super("ClickGUI", Keyboard.KEY_RSHIFT, Category.RENDER);
    }

    @Override
    public void setup() {
        ArrayList<String> options = new ArrayList<>();
        options.add("Shadow");
        Mystra.instance.settingsManager.rSetting(new Setting("Design", this, "Mystra", options));
        Mystra.instance.settingsManager.rSetting(new Setting("Sound", this, false));
        /*Mystra.instance.settingsManager.rSetting(new Setting("GuiRed", this, 0, 0, 0, true));
        Mystra.instance.settingsManager.rSetting(new Setting("GuiGreen", this, 255, 0, 255, true));
        Mystra.instance.settingsManager.rSetting(new Setting("GuiBlue", this, 42, 0, 0, true));*/
    }

    @Override
    public void onEnable() {
        super.onEnable();

        mc.displayGuiScreen(Mystra.instance.clickGui);
        toggle();
    }
}
