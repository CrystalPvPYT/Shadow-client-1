package me.mystra.module.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import org.lwjgl.opengl.GL11;

import me.mystra.Mystra;
import me.mystra.clickgui.settings.Setting;
import me.mystra.event.EventTarget;
import me.mystra.event.events.Event3D;
import me.mystra.module.Category;
import me.mystra.module.Module;
import me.mystra.utils.render.RenderUtils;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;

public class ItemESP extends Module {

	public ItemESP() {
		super("ItemESP", 0, Category.RENDER);
		
		ArrayList<String> options = new ArrayList<>();
        options.add("Outline");
        
        Mystra.instance.settingsManager.rSetting(new Setting("ItemESP Mode", this, "Outline", options));
	}
	
	@EventTarget
	public void onRender(Event3D event) {
		
		String mode = Mystra.instance.settingsManager.getSettingByName("ItemESP Mode").getValString();
		
		if(mode.equalsIgnoreCase("Outline")) {
		for(Object entity : mc.theWorld.loadedEntityList)
			if(entity instanceof EntityItem)
				RenderUtils.itemESP((Entity)entity, 2);      
		}
		
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
