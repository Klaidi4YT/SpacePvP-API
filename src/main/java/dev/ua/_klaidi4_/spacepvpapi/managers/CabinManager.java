package dev.ua._klaidi4_.spacepvpapi.managers;

import dev.ua._klaidi4_.spacepvpapi.enums.CabinsStatus;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public interface CabinManager {

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
     * Gets the global Lobby location for Cabins.
     *
     * @return The lobby location or null if not set.
     */
    @Nullable
    Location getCabinsLobby();

    /**
     * Gets a list of all configured cabin names.
     */
    @NotNull
    List<String> getCabinNames();

    /**
     * Gets the first corner (Pos1) of the cabin region.
     *
     * @param cabinName The name of the cabin.
     * @return Location of pos1 or null if cabin not found/not set.
     */
    @Nullable
    Location getCabinPos1(@NotNull String cabinName);

    /**
     * Gets the second corner (Pos2) of the cabin region.
     *
     * @param cabinName The name of the cabin.
     * @return Location of pos2 or null if cabin not found/not set.
     */
    @Nullable
    Location getCabinPos2(@NotNull String cabinName);

    /**
     * Gets the center location of the cabin (teleport point).
     *
     * @param cabinName The name of the cabin.
     * @return Center location or null if cabin not found/not set.
     */
    @Nullable
    Location getCabinCenter(@NotNull String cabinName);

    /**
     * Gets the list of door locations for a specific cabin.
     *
     * @param cabinName The name of the cabin.
     * @return List of door locations (empty if cabin not found or no doors).
     */
    @NotNull
    List<Location> getCabinDoorLocations(@NotNull String cabinName);

    /**
     * Checks if the cabin is fully configured and confirmed.
     *
     * @param cabinName The name of the cabin.
     * @return true if confirmed, false otherwise.
     */
    boolean isCabinConfirmed(@NotNull String cabinName);

    /**
     * Gets the current status of the cabin (READY, BUSY, OPENING).
     *
     * @param cabinName The name of the cabin.
     * @return The CabinsStatus or null if cabin not found.
     */
    @Nullable
    CabinsStatus getCabinStatus(@NotNull String cabinName);

    /**
     * Checks if a specific cabin is currently READY.
     * Convenience method.
     *
     * @param cabinName The name of the cabin.
     */
    boolean isCabinReady(@NotNull String cabinName);
}