package dev.ua._klaidi4_.spacepvpapi.managers;

import org.jetbrains.annotations.NotNull;
import java.util.UUID;

public interface StatsManager {

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
}