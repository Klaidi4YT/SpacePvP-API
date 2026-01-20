package dev.ua._klaidi4_.spacepvpapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class DefaultQueueJoinEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final boolean armorQueue;
    private boolean cancelled;

    public DefaultQueueJoinEvent(Player player, boolean armorQueue) {
        this.player = player;
        this.armorQueue = armorQueue;
    }

    @NotNull
    public Player getPlayer() {
        return player;
    }

    /**
     * Returns true if the player is joining the Armor Queue.
     * Returns false if the player is joining the Default Queue.
     */
    public boolean isArmorQueue() {
        return armorQueue;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
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