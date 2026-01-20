package dev.ua._klaidi4_.spacepvpapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ArenaQueueLeaveEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final String arenaName;
    private final boolean armorQueue;

    public ArenaQueueLeaveEvent(Player player, String arenaName, boolean armorQueue) {
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

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}