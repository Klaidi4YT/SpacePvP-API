package dev.ua.klaidi4_.spacepvpapi.events;

import dev.ua.klaidi4_.spacepvpapi.enums.GameType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PvPGameStartEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player player1;
    private final Player player2;
    private final GameType type;
    private final String arenaName;

    public PvPGameStartEvent(@NotNull Player player1, @NotNull Player player2, @NotNull GameType type, @Nullable String arenaName) {
        this.player1 = player1;
        this.player2 = player2;
        this.type = type;
        this.arenaName = arenaName;
    }

    public @NotNull Player getPlayer1() { return player1; }
    public @NotNull Player getPlayer2() { return player2; }
    public @NotNull GameType getType() { return type; }
    public @Nullable String getArenaName() { return arenaName; }

    @Override
    public @NotNull HandlerList getHandlers() { return handlers; }
    public static HandlerList getHandlerList() { return handlers; }
}