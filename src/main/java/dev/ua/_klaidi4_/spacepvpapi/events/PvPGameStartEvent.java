package dev.ua._klaidi4_.spacepvpapi.events;

import dev.ua._klaidi4_.spacepvpapi.enums.ApiGameType;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PvPGameStartEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Player player1;
    private final Player player2;
    private final ApiGameType type;
    private final String arenaName;
    private boolean cancelled;

    public PvPGameStartEvent(@NotNull Player player1, @NotNull Player player2, @NotNull ApiGameType type, @Nullable String arenaName) {
        this.player1 = player1;
        this.player2 = player2;
        this.type = type;
        this.arenaName = arenaName;
    }

    public @NotNull Player getPlayer1() { return player1; }
    public @NotNull Player getPlayer2() { return player2; }
    public @NotNull ApiGameType getType() { return type; }
    public @Nullable String getArenaName() { return arenaName; }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public @NotNull HandlerList getHandlers() { return handlers; }
    public static HandlerList getHandlerList() { return handlers; }
}