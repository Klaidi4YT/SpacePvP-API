package dev.ua._klaidi4_.spacepvpapi.managers;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface KitManager {

    /**
     * Get a list of all available kit names.
     *
     * @return A list of kit names found in the configuration.
     */
    @NotNull
    List<String> getKitNames();

    /**
     * Get the inventory contents of a kit (without armor).
     * Useful for GUI previews.
     *
     * @param kitName name of the kit.
     * @return array of ItemStacks or {@code null} if the kit was not found.
     */
    @Nullable
    ItemStack[] getKitContents(@NotNull String kitName);

    /**
     * Get the armor contents of a kit.
     *
     * @param kitName name of the kit.
     * @return array of armor ItemStacks or {@code null} if the kit was not found.
     */
    @Nullable
    ItemStack[] getKitArmor(@NotNull String kitName);

    /**
     * Check whether a kit with the given name exists in the configuration.
     *
     * @param kitName name of the kit.
     * @return true if the kit exists, false otherwise.
     */
    boolean isKitExists(@NotNull String kitName);
}