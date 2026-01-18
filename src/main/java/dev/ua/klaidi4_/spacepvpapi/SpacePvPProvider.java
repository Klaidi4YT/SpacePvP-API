package dev.ua.klaidi4_.spacepvpapi;

import org.jetbrains.annotations.Nullable;

public class SpacePvPProvider {
    private static SpacePvPAPI instance = null;

    private SpacePvPProvider() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }
    /**
     * Gets the API instance.
     * Returns null if the plugin is not currently loaded.
     */
    @Nullable
    public static SpacePvPAPI get() {
        return instance;
    }
    /**
     * Internal use only. Called by SpacePvP on enable.
     */
    public static void register(SpacePvPAPI implementation) {
        instance = implementation;
    }
    /**
     * Internal use only. Called by SpacePvP on disable.
     */
    public static void unregister() {
        instance = null;
    }
}