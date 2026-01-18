package dev.ua.klaidi4_.spacepvpapi;

import org.jetbrains.annotations.NotNull;
import java.util.UUID;

public interface SpacePvPAPI {
    /**
     * Gets the total number of wins for a specified player.
     * If the player is not found, returns 0.
     */
    int getWins(@NotNull UUID playerUUID);
    /**
     * Gets the total number of losses for a specified player.
     * If the player is not found, returns 0.
     */
    int getLosses(@NotNull UUID playerUUID);
    /**
     * Gets the total amount of points for a specified player.
     * If the player is not found, returns 0.
     */
    int getPoints(@NotNull UUID playerUUID);
    /**
     * Gets the current win streak for a specified player.
     * If the player is not found, returns 0.
     */
    int getCurrentWinStreak(@NotNull UUID playerUUID);
    /**
     * Gets the Kill/Death ratio for a specified player.
     * Usually calculated as kills divided by deaths.
     * If the player is not found, returns 0.0.
     */
    double getKDRadio(@NotNull UUID playerUUID);
    /**
     * Checks if the specified player is currently in the Default Armor Queue.
     * Returns true ONLY if the player is in the queue AND it is the default mode.
     */
    boolean isInDefaultArmorQueue(@NotNull UUID playerUUID);

    /**
     * Checks if the specified player is currently in the Armor Queue.
     * Returns true ONLY if the player is in the queue AND it is the armor mode.
     */
    boolean isInArmorQueue(@NotNull UUID playerUUID);
}