package dev.ua._klaidi4_.spacepvpapi;

import dev.ua._klaidi4_.spacepvpapi.enums.ApiGameEndReason;
import dev.ua._klaidi4_.spacepvpapi.managers.*;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.function.Consumer;

public interface SpacePvPProvider {

    /**
     * Gets the manager for player statistics (Wins, Losses, Elo, etc).
     */
    @NotNull
    StatsManager getStatsManager();

    /**
     * Gets the manager for the Default Queue logic.
     */
    @NotNull
    DefaultManager getDefaultManager();

    /**
     * Gets the manager for Arena Queue logic.
     */
    @NotNull
    ArenaManager getArenaManager();

    /**
     * Gets the manager for Cabin (Physical Region) logic.
     */
    @NotNull
    CabinManager getCabinManager();

    /**
     * Gets the manager for Kits.
     */
    @NotNull
    KitManager getKitManager();


    /**
     * Checks if the player is currently in ANY queue that requires Armor/Items.
     *
     * @param playerUUID The UUID of the player.
     * @return true if the player is in Default or Arena queue with Armor mode enabled.
     */
    boolean isArmorMode(@NotNull UUID playerUUID);

    /**
     * Executes the callback when the player finishes the current
     * or the next fight.
     *
     * @param playerUUID UUID of the player
     * @param callback callback executed on fight end
     */
    void onFightEnd(@NotNull UUID playerUUID,
                    @NotNull Consumer<ApiGameEndReason> callback);

    /**
     * Executes the callback when the player starts the next fight
     * (after the countdown).
     * The consumer receives the arena name (String) or {@code null}.
     *
     * @param playerUUID UUID of the player
     * @param callback callback executed on fight start
     */
    void onFightStart(@NotNull UUID playerUUID,
                      @NotNull Consumer<String> callback);

    /**
     * Forcefully ends the player's current fight.
     *
     * @param player the player whose fight should be ended
     * @param reason the reason why the fight was ended
     * @return true if the fight was successfully ended, false otherwise
     */
    boolean endFight(@NotNull Player player, @NotNull ApiGameEndReason reason);
    /**
     * Starts a duel in Default mode (Random Location) between two players.
     *
     * @param player1 The first player (initiator).
     * @param player2 The second player (target).
     * @return true if the duel was successfully started,
     *         false if the players are busy or no locations are available.
     */
    boolean startDefaultMatch(@NotNull Player player1, @NotNull Player player2);

    /**
     * Starts a duel in Arena mode on a RANDOM free arena.
     *
     * @param player1 The first player (initiator).
     * @param player2 The second player (target).
     * @return true if the duel was successfully started,
     *         false if the players are busy or no free arenas are available.
     */
    boolean startArenaMatch(@NotNull Player player1, @NotNull Player player2);

    /**
     * Starts a duel in Arena mode on a SPECIFIC arena.
     *
     * @param player1   The first player (initiator).
     * @param player2   The second player (target).
     * @param arenaName The arena name (case-sensitive if configured that way).
     * @return true if the duel was started,
     *         false if the arena is busy, does not exist, or the players are busy.
     */
    boolean startArenaMatch(@NotNull Player player1, @NotNull Player player2, @NotNull String arenaName);

    /**
     * Gets the duration of the player's current fight in seconds.
     *
     * @param playerUUID UUID of the player
     * @return fight duration in seconds
     */
    long getFightDuration(@NotNull UUID playerUUID);

    /**
     * Teleports a player to a location, bypassing internal plugin restrictions.
     * * This method ensures the teleportation is not cancelled by SpacePvP
     * event listeners (such as combat checks or game states).
     *
     * @param player   The player to teleport.
     * @param location The target destination.
     */
    void forceTeleport(Player player, Location location);
}