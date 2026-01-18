package dev.ua.klaidi4_.spacepvpapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class DefaultQueueLeaveEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final boolean armorQueue;

    public DefaultQueueLeaveEvent(Player player, boolean armorQueue) {
        this.player = player;
        this.armorQueue = armorQueue;
    }

    @NotNull
    public Player getPlayer() {
        return player;
    }

    /**
     * Returns true if the player was in the Armor Queue.
     * Returns false if the player was in the Default Queue.
     */
    public boolean isArmorQueue() {
        return armorQueue;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}