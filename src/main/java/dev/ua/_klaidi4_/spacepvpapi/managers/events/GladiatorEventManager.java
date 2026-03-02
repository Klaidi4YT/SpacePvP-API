package dev.ua._klaidi4_.spacepvpapi.managers.events;

import dev.ua._klaidi4_.spacepvpapi.enums.ApiGladiatorsStatus;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public interface GladiatorEventManager {

    /**
     * Checks if the Gladiator event is currently active.
     */
    boolean isEventActive();

    /**
     * Gets the name of the arena currently hosting the event.
     * @return Arena name or null if event is not active.
     */
    @Nullable
    String getActiveArenaName();

    /**
     * Gets the current status of the active Gladiator event.
     * @return Status or null if no arena is active.
     */
    @Nullable
    ApiGladiatorsStatus getEventStatus();

    /**
     * Gets a list of UUIDs of players currently participating in the event.
     */
    @NotNull
    List<UUID> getPlayersInEvent();

    /**
     * Checks if a specific player is in the Gladiator event.
     */
    boolean isPlayerInEvent(@NotNull UUID playerUUID);

    /**
     * Forces the Gladiator event to start.
     * @return true if successfully started, false if already active or no arenas available.
     */
    boolean startEvent();

    /**
     * Forces the Gladiator event to stop.
     * @param reasonMessage Message to broadcast (can be null).
     */
    void stopEvent(@Nullable String reasonMessage);

    /**
     * Adds a player to the Gladiator event.
     * @return true if joined, false if event is not in WAITING status, full, or player already joined.
     */
    boolean joinEvent(@NotNull Player player);

    /**
     * Removes a player from the Gladiator event.
     * @return true if left, false if player was not in the event.
     */
    boolean leaveEvent(@NotNull Player player);
}