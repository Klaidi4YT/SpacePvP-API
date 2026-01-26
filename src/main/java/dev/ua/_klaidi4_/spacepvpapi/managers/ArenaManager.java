package dev.ua._klaidi4_.spacepvpapi.managers;

import dev.ua._klaidi4_.spacepvpapi.enums.ApiArenaStatus;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public interface ArenaManager {

    /**
     * Checks if the player is currently waiting in the Arena (FFA) Queue.
     *
     * @param playerUUID The UUID of the player.
     * @return true if in arena queue, false otherwise.
     */
    boolean isInArenaQueue(@NotNull UUID playerUUID);

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
     * Checks if there is at least one arena with status READY.
     * @return true if an arena is available, false otherwise.
     */
    boolean hasFreeArena();
    /**
     * Gets a list of all configured arena names.
     */
    @NotNull
    List<String> getArenaNames();

    /**
     * Checks if a specific arena is currently READY (Status == READY).
     * This is a convenience method for getArenaStatus(name) == ArenaStatus.READY.
     *
     * @param arenaName The name of the arena.
     */
    boolean isArenaReady(@NotNull String arenaName);


    /**
     * Gets the global Lobby location for PvP arenas.
     *
     * @return The lobby location or null if not set.
     */
    @Nullable
    Location getArenaLobby();

    /**
     * Gets the first corner (Pos1) of the arena region.
     *
     * @param arenaName The name of the arena.
     * @return Location of pos1 or null if arena not found/not set.
     */
    @Nullable
    Location getArenaPos1(@NotNull String arenaName);

    /**
     * Gets the second corner (Pos2) of the arena region.
     *
     * @param arenaName The name of the arena.
     * @return Location of pos2 or null if arena not found/not set.
     */
    @Nullable
    Location getArenaPos2(@NotNull String arenaName);

    /**
     * Gets the spawn point for Player 1.
     *
     * @param arenaName The name of the arena.
     * @return Location of spawn 1 or null if arena not found/not set.
     */
    @Nullable
    Location getArenaPlayer1Spawn(@NotNull String arenaName);

    /**
     * Gets the spawn point for Player 2.
     *
     * @param arenaName The name of the arena.
     * @return Location of spawn 2 or null if arena not found/not set.
     */
    @Nullable
    Location getArenaPlayer2Spawn(@NotNull String arenaName);

    /**
     * Gets the center location of the arena.
     *
     * @param arenaName The name of the arena.
     * @return Center location or null if arena not found/not set.
     */
    @Nullable
    Location getArenaCenter(@NotNull String arenaName);

    /**
     * Gets the name of the schematic file associated with this arena.
     *
     * @param arenaName The name of the arena.
     * @return Schematic filename or null if arena not found.
     */
    @Nullable
    String getArenaSchematic(@NotNull String arenaName);

    /**
     * Checks if the arena is fully configured and confirmed.
     *
     * @param arenaName The name of the arena.
     * @return true if confirmed, false otherwise or if arena not found.
     */
    boolean isArenaConfirmed(@NotNull String arenaName);

    /**
     * Gets the current status of the arena (READY, BUSY, EDITING, etc.).
     *
     * @param arenaName The name of the arena.
     * @return The ArenaStatus or null if arena not found.
     */
    @Nullable
    ApiArenaStatus getArenaStatus(@NotNull String arenaName);
}