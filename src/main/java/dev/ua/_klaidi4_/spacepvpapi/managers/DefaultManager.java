package dev.ua._klaidi4_.spacepvpapi.managers;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.UUID;

public interface DefaultManager {

    /**
     * Checks if the player is currently waiting in the Default (1vs1) Queue.
     *
     * @param playerUUID The UUID of the player.
     * @return true if in queue, false otherwise.
     */
    boolean isInDefaultQueue(@NotNull UUID playerUUID);

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
}