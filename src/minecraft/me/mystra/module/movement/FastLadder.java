package me.mystra.module.movement;


import java.util.ArrayList;

import me.mystra.Mystra;
import me.mystra.clickgui.settings.Setting;
import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;

public class FastLadder extends Module {

   public FastLadder() {
      super("FastLadder", 0, Category.MOVEMENT);
      
      Mystra.instance.settingsManager.rSetting(new Setting("Speed", this, 0.2D, 0.1D, 1.0D, false));
      
      ArrayList<String> options = new ArrayList<>();
      options.add("Vanilla");
      options.add("AAC");
      
      Mystra.instance.settingsManager.rSetting(new Setting("Ladder Mode", this, "AAC", options));
   }

   @EventTarget
   public void onUpdate(EventUpdate event) {
	  String mode = Mystra.instance.settingsManager.getSettingByName("Ladder Mode").getValString();
      this.setDisplayName("FastLadder §7| " + mode);
      
      double aacSpeed = 0.16999999433755875D;
      if(!this.mc.gameSettings.keyBindSneak.isKeyDown() && this.mc.thePlayer.isOnLadder() && this.mc.thePlayer.isCollidedHorizontally) {
         if(mode.equalsIgnoreCase("AAC")) {
            this.mc.thePlayer.motionY = aacSpeed;
         } else {
            this.mc.thePlayer.motionY = ((Double)Mystra.instance.settingsManager.getSettingByName("Speed").getValDouble());
         }
      }

   }
}
