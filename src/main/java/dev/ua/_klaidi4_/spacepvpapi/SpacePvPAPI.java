package dev.ua._klaidi4_.spacepvpapi;

import org.jetbrains.annotations.Nullable;

public final class SpacePvPAPI {

    private static SpacePvPProvider provider;

    private SpacePvPAPI() {
        throw new UnsupportedOperationException("Cannot instantiate SpacePvPAPI class");
    }

    /**
     * Retrieves the implementation of the SpacePvP provider.
     *
     * The provider instance, or null if SpacePvP is not loaded.
     */
    @Nullable
    public static SpacePvPProvider get() {
        return provider;
    }

    /**
     * Checks if the API is currently hooked and ready to use.
     *
     * true if the API is registered, false otherwise.
     */
    public static boolean isRegistered() {
        return provider != null;
    }

    /**
     * INTERNAL USE ONLY.
     * Called by the SpacePvP plugin to register the API implementation.
     */
    public static void register(SpacePvPProvider implementation) {
        provider = implementation;
    }

    /**
     * INTERNAL USE ONLY.
     * Called by the SpacePvP plugin to unregister the API.
     */
    public static void unregister() {
        provider = null;
    }
}