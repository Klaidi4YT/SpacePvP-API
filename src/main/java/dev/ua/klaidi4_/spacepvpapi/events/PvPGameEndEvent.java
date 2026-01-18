package dev.ua.klaidi4_.spacepvpapi.events;

import dev.ua.klaidi4_.spacepvpapi.enums.GameEndReason;
import dev.ua.klaidi4_.spacepvpapi.enums.GameType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PvPGameEndEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player winner;
    private final Player loser;
    private final GameType type;
    private final GameEndReason reason;
    private final String arenaName;

    public PvPGameEndEvent(@Nullable Player winner, @Nullable Player loser, @NotNull GameType type, @NotNull GameEndReason reason, @Nullable String arenaName) {
        this.winner = winner;
        this.loser = loser;
        this.type = type;
        this.reason = reason;
        this.arenaName = arenaName;
    }

    public @Nullable Player getWinner() { return winner; }
    public @Nullable Player getLoser() { return loser; }
    public @NotNull GameType getType() { return type; }
    public @NotNull GameEndReason getReason() { return reason; }
    public @Nullable String getArenaName() { return arenaName; }

    @Override
    public @NotNull HandlerList getHandlers() { return handlers; }
    public static HandlerList getHandlerList() { return handlers; }
}