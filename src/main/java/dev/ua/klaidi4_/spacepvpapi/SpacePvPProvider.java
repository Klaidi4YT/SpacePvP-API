package dev.ua.klaidi4_.spacepvpapi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface SpacePvPProvider {

    /**
     * Gets the total number of wins for a specified player.
     * 0 if the player is not found.
     */
    int getWins(@NotNull UUID playerUUID);
    /**
     * Gets the total number of losses for a specified player.
     * 0 if the player is not found.
     */
    int getLosses(@NotNull UUID playerUUID);
    /**
     * Gets the current win streak.
     * 0 if the player is not found.
     */

    int getCurrentWinStreak(@NotNull UUID playerUUID);
    /**
     * Gets the Kill/Death ratio (Kills / Deaths).
     * 0.0 if not found.
     */
    double getKDRadio(@NotNull UUID playerUUID);
    /**
     * Gets the total amount of points (elo/score).
     * 0 if the player is not found.
     */
    int getPoints(@NotNull UUID playerUUID);
    /**
     * Adds (or subtracts) points to a player.
     * amount The amount to add. Use negative numbers to subtract.
     */
    void addPoints(@NotNull UUID playerUUID, int amount);
    /**
     * Sets the exact amount of points for a player.
     * amount The new points value.
     */
    void setPoints(@NotNull UUID playerUUID, int amount);
    /**
     * Resets the player's points to the default value (usually 0).
     */
    void resetPoints(@NotNull UUID playerUUID);
    /**
     * Checks if the player is currently waiting in the Default (1vs1) Queue.
     */
    /**
     * Removes points from a player.
     * playerUUID The UUID of the player.
     * amount The positive amount of points to remove.
     */
    void removePoints(@NotNull UUID playerUUID, int amount);
    boolean isInDefaultQueue(@NotNull UUID playerUUID);
    /**
     * Checks if the player is currently waiting in the Arena (FFA) Queue.
     */
    boolean isInArenaQueue(@NotNull UUID playerUUID);
    /**
     * Checks if the player is currently in ANY queue that requires Armor/Items.
     * Returns true if the player is in Default or Arena queue with Armor mode enabled.
     */
    boolean isArmorMode(@NotNull UUID playerUUID);
    /**
     * Checks if the player is currently in the countdown phase for a Default Duel.
     */
    boolean isInDefaultCountdown(@NotNull UUID playerUUID);
    /**
     * Checks if the player is currently fighting in a Default Duel (after countdown).
     */
    boolean isInDefaultFight(@NotNull UUID playerUUID);
    /**
     * Gets the UUID of the opponent in a Default Duel.
     * Works during both Countdown and Active Fight.
     * @return UUID of opponent or null if not in a duel.
     */
    @Nullable
    UUID getDefaultOpponent(@NotNull UUID playerUUID);
    /**
     * Checks if the player is currently in the countdown phase for an Arena Match.
     */
    boolean isInArenaCountdown(@NotNull UUID playerUUID);
    /**
     * Checks if the player is currently fighting in an Arena Match (after countdown).
     */
    boolean isInArenaFight(@NotNull UUID playerUUID);
    /**
     * Gets the UUID of the opponent in an Arena Match.
     * Works during both Countdown and Active Fight.
     * UUID of opponent or null if not in an arena match.
     */
    @Nullable
    UUID getArenaOpponent(@NotNull UUID playerUUID);
    /**
     * Gets the name of the arena the player is currently fighting in (or counting down).
     * Arena name or null if not in an arena match.
     */
    @Nullable
    String getCurrentArenaName(@NotNull UUID playerUUID);
    /**
     * Checks if the player is physically inside any PvP Cabin.
     */
    boolean isInCabin(@NotNull UUID playerUUID);
    /**
     * Checks if the player is currently in an active fight inside a cabin
     * (Status is BUSY).
     */
    boolean isInCabinFight(@NotNull UUID playerUUID);
    /**
     * Gets the name of the cabin the player is currently in.
     * Cabin name or null if not in a cabin.
     */
    @Nullable
    String getCabinName(@NotNull UUID playerUUID);
    /**
     * Gets the opponent of the player inside a cabin.
     * UUID of the opponent or null.
     */
    @Nullable
    UUID getCabinOpponent(@NotNull UUID playerUUID);
}