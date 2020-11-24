package me.mystra.event.events;

import me.mystra.event.Event;
import net.minecraft.entity.Entity;

public class EventEntityDamage extends Event {

	Entity entity;
	
	public EventEntityDamage(Entity entity) {
		this.entity = entity;
	}
	
	public Entity getEntity() {
		return entity;
	}
	
}
