package me.mystra.module.render;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import me.mystra.Mystra;
import me.mystra.module.Category;
import me.mystra.module.Module;
import me.mystra.utils.render.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;

public class ChestESP extends Module {

	public ChestESP() {
		super("ChestESP", 0, Category.RENDER);
	}
	
	public void onRender() {
		if(Mystra.instance.moduleManager.getModuleByName("ChestESP").isToggled())
			for(Object o: mc.theWorld.loadedTileEntityList){
				if(o instanceof TileEntityChest){
					final int[] counter = {1};
					RenderUtils.blockESPBox(((TileEntityChest)o).getPos(), novoline(counter[0] * 300));
					counter[0]++;
			}
		}
	}
	
	public static int novoline(int delay) {
	      double novolineState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
	      novolineState %= 360;
	      return Color.getHSBColor((float) (novolineState / 360.0f), 0.8f, 0.7f).getRGB();
	}
}
