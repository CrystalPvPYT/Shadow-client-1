package me.mystra.module.render;

import org.lwjgl.opengl.GL11;

import me.mystra.event.EventManager;
import me.mystra.event.EventTarget;
import me.mystra.event.events.RenderEvent;
import me.mystra.module.Category;
import me.mystra.module.Module;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

public class Chams2 extends Module {
    public Chams2() {
		super("Chams2", 0, Category.RENDER);
	}

    public void onEnable() {
        EventManager.register(this);
    }
    
    public void onDisable() {
        EventManager.unregister(this);
    }
    
    private boolean isValid(final Entity ent) {
        return ent instanceof EntityPlayer && ent != this.mc.thePlayer && !ent.isInvisible();
    }
    
    @EventTarget
    public void beforeRenderPlayer(final RenderEvent event) {
            this.offsetPolygon();
        }
    
    @EventTarget
    public void afterRenderPlayer(final RenderEvent event) {
            this.resetPolygon();
        }
    
    private void offsetPolygon() {
        GL11.glEnable(32823);
        GL11.glPolygonOffset(1.0f, -1.0E7f);
    }
    
    private void resetPolygon() {
        GL11.glPolygonOffset(1.0f, 1000000.0f);
        GL11.glDisable(32823);
    }
}
