package dev.ua.klaidi4_.spacepvpapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ArenaQueueJoinEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final String arenaName;
    private final boolean armorQueue;
    private boolean cancelled;

    public ArenaQueueJoinEvent(Player player, String arenaName, boolean armorQueue) {
        this.player = player;
        this.arenaName = arenaName;
        this.armorQueue = armorQueue;
    }

    @NotNull
    public Player getPlayer() {
        return player;
    }

    @NotNull
    public String getArenaName() {
        return arenaName;
    }

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