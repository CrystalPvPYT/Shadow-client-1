package me.mystra.module.render;

import me.mystra.event.EventManager;
import me.mystra.event.EventTarget;
import me.mystra.event.events.ClientTickEvent;
import me.mystra.module.Category;
import me.mystra.module.Module;
import net.minecraft.client.renderer.EntityRenderer;

public class MotionBlur extends Module
{
    public MotionBlur() {
        super("MotionBlur", 0, Category.RENDER);
    }
    
    @Override
    public void onDisable() {
        EventManager.unregister(this);
        this.mc.entityRenderer.useShader = true;
        if (this.mc.entityRenderer.theShaderGroup != null) {
            this.mc.entityRenderer.theShaderGroup.deleteShaderGroup();
        }
    }
    
    @Override
    public void onEnable() {
        final EntityRenderer er = this.mc.entityRenderer;
        er.activateNextShader();
        EventManager.register(this);
    }
    
    @EventTarget
    public void onTick(final ClientTickEvent event) {
        final EntityRenderer er = this.mc.entityRenderer;
        this.mc.entityRenderer.useShader = true;
        if (this.mc.theWorld != null && (this.mc.entityRenderer.theShaderGroup == null || !this.mc.entityRenderer.theShaderGroup.getShaderGroupName().contains("phosphor"))) {
            if (er.theShaderGroup != null) {
                er.theShaderGroup.deleteShaderGroup();
            }
            er.activateNextShader();
        }
    }
}
