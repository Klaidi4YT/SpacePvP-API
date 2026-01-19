package dev.ua.klaidi4_.spacepvpapi;

import dev.ua.klaidi4_.spacepvpapi.enums.GameEndReason;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public interface SpacePvPProvider {

    /**
     * Gets the total number of wins for a specified player.
     *
     * @param playerUUID The UUID of the player.
     * @return The number of wins, or 0 if not found.
     */
    int getWins(@NotNull UUID playerUUID);

    /**
     * Gets the total number of losses for a specified player.
     *
     * @param playerUUID The UUID of the player.
     * @return The number of losses, or 0 if not found.
     */
    int getLosses(@NotNull UUID playerUUID);

    /**
     * Gets the current win streak.
     *
     * @param playerUUID The UUID of the player.
     * @return The current win streak, or 0 if not found.
     */
    int getCurrentWinStreak(@NotNull UUID playerUUID);

    /**
     * Gets the Kill/Death ratio (Kills / Deaths).
     *
     * @param playerUUID The UUID of the player.
     * @return The KD ratio, or 0.0 if not found/no games played.
     */
    double getKDRadio(@NotNull UUID playerUUID);

    /**
     * Gets the total amount of points (elo/score).
     *
     * @param playerUUID The UUID of the player.
     * @return The total points, or 0 if not found.
     */
    int getPoints(@NotNull UUID playerUUID);

    /**
     * Adds (or subtracts) points to a player.
     *
     * @param playerUUID The UUID of the player.
     * @param amount     The amount to add. Use negative numbers to subtract.
     */
    void addPoints(@NotNull UUID playerUUID, int amount);

    /**
     * Sets the exact amount of points for a player.
     *
     * @param playerUUID The UUID of the player.
     * @param amount     The new points value.
     */
    void setPoints(@NotNull UUID playerUUID, int amount);
    /**
     * Sets the exact amount of wins for a player.
     * Useful for migrations or admin commands.
     *
     * @param playerUUID The UUID of the player.
     * @param amount     The new wins value.
     */
    void setWins(@NotNull UUID playerUUID, int amount);

    /**
     * Sets the exact amount of losses for a player.
     *
     * @param playerUUID The UUID of the player.
     * @param amount     The new losses value.
     */
    void setLosses(@NotNull UUID playerUUID, int amount);

    /**
     * Sets the current win streak for a player.
     * Useful for restoring streaks after bugs or issues.
     *
     * @param playerUUID The UUID of the player.
     * @param amount     The new streak value.
     */
    void setCurrentWinStreak(@NotNull UUID playerUUID, int amount);
    /**
     * Resets the player's points to the default value (usually 0).
     *
     * @param playerUUID The UUID of the player.
     */
    void resetPoints(@NotNull UUID playerUUID);

    /**
     * Removes points from a player.
     *
     * @param playerUUID The UUID of the player.
     * @param amount     The positive amount of points to remove.
     */
    void removePoints(@NotNull UUID playerUUID, int amount);

    /**
     * Checks if the player is currently waiting in the Default (1vs1) Queue.
     *
     * @param playerUUID The UUID of the player.
     * @return true if in queue, false otherwise.
     */
    boolean isInDefaultQueue(@NotNull UUID playerUUID);

    /**
     * Checks if the player is currently waiting in the Arena (FFA) Queue.
     *
     * @param playerUUID The UUID of the player.
     * @return true if in arena queue, false otherwise.
     */
    boolean isInArenaQueue(@NotNull UUID playerUUID);

    /**
     * Checks if the player is currently in ANY queue that requires Armor/Items.
     *
     * @param playerUUID The UUID of the player.
     * @return true if the player is in Default or Arena queue with Armor mode enabled.
     */
    boolean isArmorMode(@NotNull UUID playerUUID);

    /**
     * Checks if the player is currently in the countdown phase for a Default Duel.
     *
     * @param playerUUID The UUID of the player.
     * @return true if in countdown.
     */
    boolean isInDefaultCountdown(@NotNull UUID playerUUID);

    /**
     * Checks if the player is currently fighting in a Default Duel (after countdown).
     *
     * @param playerUUID The UUID of the player.
     * @return true if fighting.
     */
    boolean isInDefaultFight(@NotNull UUID playerUUID);

    /**
     * Gets the UUID of the opponent in a Default Duel.
     * Works during both Countdown and Active Fight.
     *
     * @param playerUUID The UUID of the player.
     * @return UUID of opponent or null if not in a duel.
     */
    @Nullable
    UUID getDefaultOpponent(@NotNull UUID playerUUID);

    /**
     * Checks if the player is currently in the countdown phase for an Arena Match.
     *
     * @param playerUUID The UUID of the player.
     * @return true if in countdown.
     */
    boolean isInArenaCountdown(@NotNull UUID playerUUID);

    /**
     * Checks if the player is currently fighting in an Arena Match (after countdown).
     *
     * @param playerUUID The UUID of the player.
     * @return true if fighting.
     */
    boolean isInArenaFight(@NotNull UUID playerUUID);

    /**
     * Gets the UUID of the opponent in an Arena Match.
     * Works during both Countdown and Active Fight.
     *
     * @param playerUUID The UUID of the player.
     * @return UUID of opponent or null if not in an arena match.
     */
    @Nullable
    UUID getArenaOpponent(@NotNull UUID playerUUID);

    /**
     * Gets the name of the arena the player is currently fighting in (or counting down).
     *
     * @param playerUUID The UUID of the player.
     * @return Arena name or null if not in an arena match.
     */
    @Nullable
    String getCurrentArenaName(@NotNull UUID playerUUID);
    /**
     * Gets a list of all configured arena names.
     */
    @NotNull
    List<String> getArenaNames();

    /**
     * Checks if a specific arena is currently READY.
     *
     * @param arenaName The name of the arena.
     */
    boolean isArenaReady(@NotNull String arenaName);
    /**
     * Checks if the player is physically inside any PvP Cabin.
     *
     * @param playerUUID The UUID of the player.
     * @return true if inside a cabin region.
     */
    boolean isInCabin(@NotNull UUID playerUUID);

    /**
     * Checks if the player is currently in an active fight inside a cabin
     * (Status is BUSY).
     *
     * @param playerUUID The UUID of the player.
     * @return true if in a cabin fight.
     */
    boolean isInCabinFight(@NotNull UUID playerUUID);

    /**
     * Gets the name of the cabin the player is currently in.
     *
     * @param playerUUID The UUID of the player.
     * @return Cabin name or null if not in a cabin.
     */
    @Nullable
    String getCabinName(@NotNull UUID playerUUID);

    /**
     * Gets the opponent of the player inside a cabin.
     *
     * @param playerUUID The UUID of the player.
     * @return UUID of the opponent or null.
     */
    @Nullable
    UUID getCabinOpponent(@NotNull UUID playerUUID);

    /**
     * Executes the callback when the player finishes the current
     * or the next fight.
     *
     * @param playerUUID UUID of the player
     * @param callback callback executed on fight end
     */
    void onFightEnd(@NotNull UUID playerUUID,
                    @NotNull Consumer<GameEndReason> callback);

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
    boolean endFight(@NotNull Player player, @NotNull GameEndReason reason);

    /**
     * Gets the duration of the player's current fight in seconds.
     *
     * @param playerUUID UUID of the player
     * @return fight duration in seconds
     */
    long getFightDuration(@NotNull UUID playerUUID);
    /**
     * Get a list of all available kit names.
     *
     * @return A list of kit names found in the configuration.
     */
    @NotNull
    List<String> getKitNames();

    /**
     * Get the inventory contents of a kit (without armor).
     * Useful for GUI previews.
     *
     * @param kitName name of the kit.
     * @return array of ItemStacks or {@code null} if the kit was not found.
     */
    @Nullable
    ItemStack[] getKitContents(@NotNull String kitName);

    /**
     * Get the armor contents of a kit.
     *
     * @param kitName name of the kit.
     * @return array of armor ItemStacks or {@code null} if the kit was not found.
     */
    @Nullable
    ItemStack[] getKitArmor(@NotNull String kitName);

    /**
     * Check whether a kit with the given name exists in the configuration.
     *
     * @param kitName name of the kit.
     * @return true if the kit exists, false otherwise.
     */
    boolean isKitExists(@NotNull String kitName);
}