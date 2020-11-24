package me.mystra.event.events;

import me.mystra.event.Event;

public class Event3D extends Event {
    private static float partialTicks;

    public Event3D(float partialTicks) {
        this.partialTicks = partialTicks;
    }

    public static float getPartialTicks() {
        return partialTicks;
    }
}
