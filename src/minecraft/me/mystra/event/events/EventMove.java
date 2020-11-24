package me.mystra.event.events;

import me.mystra.event.Event;

public final class EventMove extends Event {
	   public double x;
	   public double y;
	   public double z;

	   public EventMove(double x, double y, double z) {
	      this.x = x;
	      this.y = y;
	      this.z = z;
	   }
}
