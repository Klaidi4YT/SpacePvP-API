package dev.ua.klaidi4_.spacepvpapi;

import org.jetbrains.annotations.NotNull;
import java.util.UUID;

public interface SpacePvPProvider {

    /**
     * Gets the total number of wins for a specified player.
     * @return 0 if the player is not found.
     */
    int getWins(@NotNull UUID playerUUID);
    /**
     * Gets the total number of losses for a specified player.
     * @return 0 if the player is not found.
     */
    int getLosses(@NotNull UUID playerUUID);
    /**
     * Gets the total amount of points (elo/score).
     * @return 0 if the player is not found.
     */
    int getPoints(@NotNull UUID playerUUID);
    /**
     * Gets the current win streak.
     * @return 0 if the player is not found.
     */
    int getCurrentWinStreak(@NotNull UUID playerUUID);
    /**
     * Gets the Kill/Death ratio (Kills / Deaths).
     * @return 0.0 if not found.
     */
    double getKDRadio(@NotNull UUID playerUUID);
}