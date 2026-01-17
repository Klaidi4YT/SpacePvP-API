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

}