package me.mystra.module.movement;

import me.mystra.event.EventTarget;
import me.mystra.event.events.EventItemSpeed;
import me.mystra.event.events.EventPostMotionUpdate;
import me.mystra.event.events.EventPreMotionUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class NoSlowdown extends Module{
	public NoSlowdown() {
		super("NoSlowdown", 0, Category.MOVEMENT);
	}
	@EventTarget
	public void onPre(EventPreMotionUpdate pre) {
		if (this.mc.thePlayer.isBlocking() && (this.mc.thePlayer.motionX != 0.0 || this.mc.thePlayer.motionZ != 0.0)) {
			this.mc.getNetHandler().getNetworkManager().dispatchPacket((Packet)new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.DOWN), null);
        }
	}
	@EventTarget
	public void onPost(EventPostMotionUpdate post) {
		if (this.mc.thePlayer.isBlocking() && (this.mc.thePlayer.motionX != 0.0 || this.mc.thePlayer.motionZ != 0.0)) {
			this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C08PacketPlayerBlockPlacement(this.mc.thePlayer.inventory.getCurrentItem()));
        }
	}
	@EventTarget
    private void onItemUse(EventItemSpeed event) {
    	event.setCancelled(true);
    }

	@Override
	public void onEnable() {
	}

	@Override
	public void onDisable() {
	}
}
