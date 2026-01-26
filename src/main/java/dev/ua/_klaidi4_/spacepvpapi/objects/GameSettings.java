package dev.ua._klaidi4_.spacepvpapi.objects;

import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameSettings {

    private final Integer countdownSeconds;
    private final String displayType;
    private final BarColor bossBarColor;
    private final BarStyle bossBarStyle;
    private final Map<Integer, String> countdownColors;
    private final Map<Integer, String> countdownSounds;
    private final String finishSound;
    private final List<String> damageWhitelist;
    private final Map<Integer, String> countdownSubtitles;
    private final Integer titleFadeIn;
    private final Integer titleStay;
    private final Integer titleFadeOut;
    private final boolean useConfig;
    private final boolean updateStats;
    private final boolean useVictoryMessages;
    private final boolean useKit;
    private final String kitName;
    private final boolean clearInventory;
    private final boolean useRegenerationArena;
    private final Integer regenDelaySeconds;
    private GameSettings(Builder builder) {
        this.countdownSeconds = builder.countdownSeconds;
        this.displayType = builder.displayType;
        this.bossBarColor = builder.bossBarColor;
        this.bossBarStyle = builder.bossBarStyle;
        this.countdownColors = builder.countdownColors;
        this.countdownSounds = builder.countdownSounds;
        this.finishSound = builder.finishSound;
        this.damageWhitelist = builder.damageWhitelist;
        this.countdownSubtitles = builder.countdownSubtitles;
        this.titleFadeIn = builder.titleFadeIn;
        this.titleStay = builder.titleStay;
        this.titleFadeOut = builder.titleFadeOut;
        this.useConfig = builder.useConfig;
        this.updateStats = builder.updateStats;
        this.useVictoryMessages = builder.useVictoryMessages;
        this.useKit = builder.useKit;
        this.kitName = builder.kitName;
        this.clearInventory = builder.clearInventory;
        this.useRegenerationArena = builder.useRegenerationArena;
        this.regenDelaySeconds = builder.regenDelaySeconds;
    }

    /**
     * Gets the configured countdown duration in seconds.
     */
    public @Nullable Integer getCountdownSeconds() {
        return countdownSeconds;
    }

    /**
     * Gets the display type for the countdown (e.g., TITLE, BOSS_BAR, ACTION_BAR).
     */
    public @Nullable String getDisplayType() {
        return displayType;
    }

    /**
     * Gets the configured BossBar color.
     */
    public @Nullable BarColor getBossBarColor() {
        return bossBarColor;
    }

    /**
     * Gets the configured BossBar style.
     */
    public @Nullable BarStyle getBossBarStyle() {
        return bossBarStyle;
    }

    /**
     * Gets the map of colors used for specific countdown seconds.
     */
    public @Nullable Map<Integer, String> getCountdownColors() {
        return countdownColors;
    }

    /**
     * Gets the map of sounds used for specific countdown seconds.
     */
    public @Nullable Map<Integer, String> getCountdownSounds() {
        return countdownSounds;
    }

    /**
     * Gets the sound configuration string to play when the countdown finishes.
     */
    public @Nullable String getFinishSound() {
        return finishSound;
    }

    /**
     * Gets the list of damage causes that are allowed during the fight.
     */
    public @Nullable List<String> getDamageWhitelist() {
        return damageWhitelist;
    }

    /**
     * Gets the map of subtitles used for specific countdown seconds.
     */
    public @Nullable Map<Integer, String> getCountdownSubtitles() {
        return countdownSubtitles;
    }

    /**
     * Gets the title fade-in time in ticks.
     */
    public @Nullable Integer getTitleFadeIn() {
        return titleFadeIn;
    }

    /**
     * Gets the title stay time in ticks.
     */
    public @Nullable Integer getTitleStay() {
        return titleStay;
    }

    /**
     * Gets the title fade-out time in ticks.
     */
    public @Nullable Integer getTitleFadeOut() {
        return titleFadeOut;
    }

    /**
     * Checks if the settings should use config.yml as a fallback for missing values.
     *
     * If true, missing values will be taken from the plugin configuration.
     * If false, missing values will use hardcoded empty defaults.
     */
    public boolean shouldUseConfig() {
        return useConfig;
    }
    /**
     * Checks if player statistics (wins, losses, points) should be updated after the match.
     */
    public boolean shouldUpdateStats() {
        return updateStats;
    }
    /**
     * Creates a new Builder instance to configure GameSettings.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }
    /**
     * Should victory messages be sent for this match?
     * @return true/false if set, or null if it should fallback to config.
     */
    public @Nullable boolean getUseVictoryMessages() {
        return useVictoryMessages;
    }

    /**
     * Should a kit be given to players in this match?
     * @return true/false if set, or null if it should fallback to config.
     */
    public @Nullable boolean getUseKit() {
        return useKit;
    }
    /**
     * Gets the specific kit name to use.
     * @return Kit name or null (if using default/config kit).
     */
    public @Nullable String getKitName() {
        return kitName;
    }
    /**
     * Should the inventory be cleared after the battle?
     * @return true/false or null (fallback to config)
     */
    public @Nullable boolean getClearInventory() {
        return clearInventory;
    }
    /**
     * Should the arena be regenerated after the match?
     * @return true/false or null (fallback to config).
     */
    public @Nullable boolean getUseRegenerationArena() {
        return useRegenerationArena;
    }

    /**
     * Time in seconds to wait after the match ends before regenerating/teleporting.
     * @return seconds or null (fallback to config).
     */
    public @Nullable Integer getRegenDelaySeconds() {
        return regenDelaySeconds;
    }
    public static class Builder {
        private Integer countdownSeconds;
        private String displayType;
        private BarColor bossBarColor;
        private BarStyle bossBarStyle;
        private Map<Integer, String> countdownColors = new HashMap<>();
        private Map<Integer, String> countdownSounds = new HashMap<>();
        private String finishSound;
        private List<String> damageWhitelist = new ArrayList<>();
        private Map<Integer, String> countdownSubtitles = new HashMap<>();
        private Integer titleFadeIn;
        private Integer titleStay;
        private Integer titleFadeOut;
        private boolean useConfig = true;
        private boolean updateStats = true;
        private boolean useVictoryMessages = true;
        private boolean useKit = false;
        private String kitName = null;
        private boolean clearInventory = false;
        private boolean useRegenerationArena = true;
        private Integer regenDelaySeconds = null;
        /**
         * Sets the duration of the countdown in seconds.
         *
         * @param seconds duration in seconds
         * @return this builder
         */
        public Builder setCountdown(int seconds) {
            this.countdownSeconds = seconds;
            return this;
        }

        /**
         * Sets the display type for the countdown.
         *
         * @param type display type (e.g., "TITLE", "ACTION_BAR", "BOSS_BAR")
         * @return this builder
         */
        public Builder setDisplayType(@NotNull String type) {
            this.displayType = type;
            return this;
        }

        /**
         * Configures the BossBar color and style.
         *
         * @param color the color of the boss bar
         * @param style the style of the boss bar
         * @return this builder
         */
        public Builder setBossBar(@NotNull BarColor color, @NotNull BarStyle style) {
            this.bossBarColor = color;
            this.bossBarStyle = style;
            return this;
        }

        /**
         * Adds a specific color for a specific second of the countdown.
         *
         * @param second the second (e.g., 5, 4, 3)
         * @param hexColor the HEX color string
         * @return this builder
         */
        public Builder addColor(int second, @NotNull String hexColor) {
            this.countdownColors.put(second, hexColor);
            return this;
        }

        /**
         * Sets the map of colors for all countdown seconds.
         *
         * @param colors map of seconds to HEX colors
         * @return this builder
         */
        public Builder setColors(@NotNull Map<Integer, String> colors) {
            this.countdownColors = new HashMap<>(colors);
            return this;
        }

        /**
         * Adds a specific sound for a specific second of the countdown.
         *
         * @param second the second (e.g., 5, 4, 3)
         * @param soundConfig sound configuration string (e.g., "SOUND:VOLUME:PITCH")
         * @return this builder
         */
        public Builder addSound(int second, @NotNull String soundConfig) {
            this.countdownSounds.put(second, soundConfig);
            return this;
        }

        /**
         * Sets the sound to play when the countdown finishes (fight starts).
         *
         * @param soundConfig sound configuration string
         * @return this builder
         */
        public Builder setFinishSound(@NotNull String soundConfig) {
            this.finishSound = soundConfig;
            return this;
        }

        /**
         * Adds a damage cause to the whitelist (e.g., "FALL", "FIRE").
         *
         * @param damageCause the damage cause to allow
         * @return this builder
         */
        public Builder addWhitelistedDamage(@NotNull String damageCause) {
            this.damageWhitelist.add(damageCause);
            return this;
        }

        /**
         * Sets the complete list of whitelisted damage causes.
         *
         * @param whitelist list of allowed damage causes
         * @return this builder
         */
        public Builder setDamageWhitelist(@NotNull List<String> whitelist) {
            this.damageWhitelist = new ArrayList<>(whitelist);
            return this;
        }

        /**
         * Adds a subtitle text for a specific second of the countdown.
         *
         * @param second the second (e.g., 5, 4, 3)
         * @param subtitle the subtitle text
         * @return this builder
         */
        public Builder addSubtitle(int second, @NotNull String subtitle) {
            this.countdownSubtitles.put(second, subtitle);
            return this;
        }

        /**
         * Sets the map of subtitles for all countdown seconds.
         *
         * @param subtitles map of seconds to subtitle text
         * @return this builder
         */
        public Builder setSubtitles(@NotNull Map<Integer, String> subtitles) {
            this.countdownSubtitles = new HashMap<>(subtitles);
            return this;
        }

        /**
         * Sets the animation timings for titles.
         *
         * @param fadeIn time to fade in (ticks)
         * @param stay time to stay on screen (ticks)
         * @param fadeOut time to fade out (ticks)
         * @return this builder
         */
        public Builder setTitleAnimation(int fadeIn, int stay, int fadeOut) {
            this.titleFadeIn = fadeIn;
            this.titleStay = stay;
            this.titleFadeOut = fadeOut;
            return this;
        }

        /**
         * Sets whether to use the plugin's configuration as a fallback.
         *
         * If true (default), missing settings are taken from config.yml.
         * If false, missing settings use hardcoded empty defaults.
         *
         * @param useConfig true to use config fallback, false to strictly use provided values
         * @return this builder
         */
        public Builder setUseConfig(boolean useConfig) {
            this.useConfig = useConfig;
            return this;
        }
        /**
         * Sets whether player statistics (wins, losses, points) should be updated after the match.
         *
         * If true (default), the plugin will record wins, losses, and award points.
         * If false, the match will count as unranked (no stats or points changes).
         *
         * @param updateStats true to update stats, false to disable
         * @return this builder
         */
        public Builder setUpdateStats(boolean updateStats) {
            this.updateStats = updateStats;
            return this;
        }
        /**
         * Sets whether victory messages are enabled.
         * @param enable true to enable, false to disable.
         */
        public Builder setUseVictoryMessages(boolean enable) {
            this.useVictoryMessages = enable;
            return this;
        }

        /**
         * Sets whether kits should be used.
         * @param useKit true to give kits, false to disable.
         */
        public Builder setUseKit(boolean useKit) {
            this.useKit = useKit;
            return this;
        }
        /**
         * Sets a specific kit name to use.
         * Automatically sets useKit to true if a name is provided.
         */
        public Builder setKitName(@Nullable String kitName) {
            this.kitName = kitName;
            if (kitName != null && !kitName.isEmpty()) {
                this.useKit = true;
            }
            return this;
        }
        /**
         * Sets whether the inventory should be cleared after the battle.
         */
        public Builder setClearInventory(boolean clear) {
            this.clearInventory = clear;
            return this;
        }
        /**
         * Sets whether the arena should be regenerated after the match.
         */
        public Builder setUseRegenerationArena(boolean enable) {
            this.useRegenerationArena = enable;
            return this;
        }

        /**
         * Sets the delay in seconds before the arena regenerates/players are kicked.
         */
        public Builder setRegenDelaySeconds(int seconds) {
            this.regenDelaySeconds = seconds;
            return this;
        }

        public GameSettings build() {
            return new GameSettings(this);
        }
    }
}