package dev.ua._klaidi4_.spacepvpapi.events;

import dev.ua._klaidi4_.spacepvpapi.enums.ApiGameEndReason;
import dev.ua._klaidi4_.spacepvpapi.enums.ApiGameType;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PvPGameEndEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Player winner;
    private final Player loser;
    private final ApiGameType type;
    private final ApiGameEndReason reason;
    private final String arenaName;
    private boolean cancelled;

    public PvPGameEndEvent(@Nullable Player winner, @Nullable Player loser, @NotNull ApiGameType type, @NotNull ApiGameEndReason reason, @Nullable String arenaName) {
        this.winner = winner;
        this.loser = loser;
        this.type = type;
        this.reason = reason;
        this.arenaName = arenaName;
    }

    public @Nullable Player getWinner() { return winner; }
    public @Nullable Player getLoser() { return loser; }
    public @NotNull ApiGameType getType() { return type; }
    public @NotNull ApiGameEndReason getReason() { return reason; }
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