package dev.ua.klaidi4_.spacepvpapi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.UUID;

public interface SpacePvPAPI {

    /**
     * Gets the total number of wins for a specified player.
     * Returns 0 if the player is not found.
     */
    int getWins(@NotNull UUID playerUUID);

    /**
     * Gets the total number of losses for a specified player.
     * Returns 0 if the player is not found.
     */
    int getLosses(@NotNull UUID playerUUID);

    /**
     * Gets the total amount of points (elo/score) for a specified player.
     * Returns 0 if the player is not found.
     */
    int getPoints(@NotNull UUID playerUUID);

    /**
     * Gets the current win streak for a specified player.
     * Returns 0 if the player is not found.
     */
    int getCurrentWinStreak(@NotNull UUID playerUUID);

    /**
     * Gets the Kill/Death ratio for a specified player.
     * Calculated as (Kills / Deaths).
     * Returns 0.0 if the player is not found or has no stats.
     */
    double getKDRadio(@NotNull UUID playerUUID);

    /**
     * Gets the API instance.
     * @return The API instance or null if not loaded.
     */
    @Nullable
    static SpacePvPAPI get() {
        return Holder.instance;
    }
    /**
     * Registers the API implementation.
     * INTERNAL USE ONLY.
     */
    static void register(SpacePvPAPI implementation) {
        Holder.instance = implementation;
    }
    /**
     * Unregisters the API.
     * INTERNAL USE ONLY.
     */
    static void unregister() {
        Holder.instance = null;
    }

    class Holder {
        private static SpacePvPAPI instance;
    }
}