# ⚔️ SpacePvP-API

![Java 17](https://img.shields.io/badge/Java-17%2B-orange?style=flat)
[![JitPack](https://jitpack.io/v/Klaidi4YT/SpacePvP-API.svg?style=flat)](https://jitpack.io/#Klaidi4YT/SpacePvP-API)
[![SpigotMC](https://img.shields.io/badge/SpigotMC-Resource-orange?style=flat&logo=spigotmc)](https://www.spigotmc.org/resources/spacepvp.124417/)

**SpacePvP-API** is the comprehensive developer interface for the **SpacePvP** plugin.
It allows you to deeply integrate PvP mechanics, manipulate player statistics, manage queues, control arena states, and listen to custom game events.

## 📝 Requirements

* **Java 17** or newer
* **SpacePvP** plugin installed and running on the server

---

## 📦 Installation

This library is hosted on [JitPack](https://jitpack.io).

### Step 1. Add the JitPack repository

**Maven** (`pom.xml`):
```xml
<repositories>
    <repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
     </repository>
</repositories>
```

**Gradle Groovy** (`build.gradle`):
```groovy
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}
```

**Gradle Kotlin** (`build.gradle.kts`):
```kotlin
repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}
```

---

### Step 2. Add the dependency

Replace `Tag` with the latest release version (e.g. `1.0.0`).

**Maven** (`pom.xml`):
```xml
<dependency>
    <groupId>com.github.Klaidi4YT</groupId>
    <artifactId>SpacePvP-API</artifactId>
    <version>Tag</version>
    <scope>provided</scope>
</dependency>
```

**Gradle Groovy** (`build.gradle`):
```groovy
dependencies {
    compileOnly 'com.github.Klaidi4YT:SpacePvP-API:Tag'
}
```

**Gradle Kotlin** (`build.gradle.kts`):
```kotlin
dependencies {
    compileOnly("com.github.Klaidi4YT:SpacePvP-API:Tag")
}
```

---

## ⚡ API Initialization

Before using any methods, you must obtain the instance of `SpacePvPProvider`.
**Always** check if the API is registered to avoid errors if the core plugin is missing.

```java
import dev.ua.klaidi4_.spacepvpapi.SpacePvPAPI;
import dev.ua.klaidi4_.spacepvpapi.SpacePvPProvider;

public class MyPlugin extends JavaPlugin {
    
    private SpacePvPProvider api;

    @Override
    public void onEnable() {
        if (!SpacePvPAPI.isRegistered()) {
            getLogger().severe("SpacePvP not found! Disabling plugin...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // Initialize the API provider
        this.api = SpacePvPAPI.get();
        getLogger().info("Hooked into SpacePvP successfully!");
    }
}
```

---

## 📊 Player Statistics

Methods for retrieving and modifying player statistics (Wins, Losses, Streaks, Elo).

| Return Type | Method | Description |
| :--- | :--- | :--- |
| `int` | `getWins(UUID uuid)` | Gets the total wins of a player. |
| `int` | `getLosses(UUID uuid)` | Gets the total losses of a player. |
| `int` | `getCurrentWinStreak(UUID uuid)` | Gets the current active win streak. |
| `double` | `getKDRadio(UUID uuid)` | Gets the Kill/Death ratio. |
| `int` | `getPoints(UUID uuid)` | Gets the current points (Elo). |
| `void` | `addPoints(UUID uuid, int amount)` | Adds points to a player (use negative to subtract). |
| `void` | `removePoints(UUID uuid, int amount)` | Removes points from a player. |
| `void` | `setPoints(UUID uuid, int amount)` | Sets the exact amount of points. |
| `void` | `setWins(UUID uuid, int amount)` | Sets the exact amount of wins. |
| `void` | `setLosses(UUID uuid, int amount)` | Sets the exact amount of losses. |
| `void` | `setCurrentWinStreak(UUID uuid, int amount)` | Sets the win streak manually. |
| `void` | `resetPoints(UUID uuid)` | Resets points to the default value. |

### Example Usage:
```java
UUID uuid = player.getUniqueId();

// 1. Get Stats
int elo = api.getPoints(uuid);
double kd = api.getKDRadio(uuid);

// 2. Modify Stats
if (elo > 1000) {
    api.addPoints(uuid, 50); // Bonus
    player.sendMessage("You received 50 bonus points!");
}

// 3. Reset Streak
api.setCurrentWinStreak(uuid, 0);
```

---

## ⏳ Queue System

Methods to check if a player is waiting in a queue.

| Return Type | Method | Description |
| :--- | :--- | :--- |
| `boolean` | `isInDefaultQueue(UUID uuid)` | Checks if player is in the 1vs1 Queue. |
| `boolean` | `isInArenaQueue(UUID uuid)` | Checks if player is in the FFA/Arena Queue. |
| `boolean` | `isArmorMode(UUID uuid)` | Returns `true` if the queue requires Armor (BuildUHC/Combo/etc). |

### Example Usage:
```java
UUID uuid = player.getUniqueId();

if (api.isInDefaultQueue(uuid)) {
    player.sendMessage("§cYou cannot execute commands while in the 1vs1 queue.");
    return;
}

if (api.isInArenaQueue(uuid)) {
    player.sendMessage("§eSearching for arena match...");
}
```

---

## ⚔️ Active Game Logic

Methods to check the status of active fights (Duels, FFA, or Cabins).

### 1. Default Duels (1vs1)
| Return Type | Method | Description |
| :--- | :--- | :--- |
| `boolean` | `isInDefaultCountdown(UUID uuid)` | Checks if the 1vs1 countdown is running. |
| `boolean` | `isInDefaultFight(UUID uuid)` | Checks if the 1vs1 fight is active. |
| `UUID` | `getDefaultOpponent(UUID uuid)` | Gets the opponent's UUID (returns `null` if none). |

### 2. Arena Matches (FFA/Team)
| Return Type | Method | Description |
| :--- | :--- | :--- |
| `boolean` | `isInArenaCountdown(UUID uuid)` | Checks if the arena countdown is running. |
| `boolean` | `isInArenaFight(UUID uuid)` | Checks if the arena fight is active. |
| `String` | `getCurrentArenaName(UUID uuid)` | Gets the name of the current arena. |
| `UUID` | `getArenaOpponent(UUID uuid)` | Gets the opponent in the arena (if applicable). |

### 3. Cabins (Physical Waiting Rooms)
| Return Type | Method | Description |
| :--- | :--- | :--- |
| `boolean` | `isInCabin(UUID uuid)` | Checks if player is physically inside a cabin region. |
| `boolean` | `isInCabinFight(UUID uuid)` | Checks if player is fighting inside a cabin. |
| `String` | `getCabinName(UUID uuid)` | Gets the name of the cabin. |
| `UUID` | `getCabinOpponent(UUID uuid)` | Gets the opponent inside the cabin. |

### Example Usage:
```java
UUID uuid = player.getUniqueId();

// 1vs1 Logic
if (api.isInDefaultFight(uuid)) {
    UUID opponentId = api.getDefaultOpponent(uuid);
    Player opponent = Bukkit.getPlayer(opponentId);
    
    if (opponent != null) {
        player.sendMessage("Current opponent: " + opponent.getName());
    }
}

// Arena Logic
if (api.isInArenaFight(uuid)) {
    String map = api.getCurrentArenaName(uuid);
    player.sendMessage("Playing on map: " + map);
}
```

---

## 🏟️ Arenas & Kits Configuration

Methods to retrieve configuration data about maps and kits.

| Return Type | Method | Description |
| :--- | :--- | :--- |
| `List<String>` | `getArenaNames()` | Returns a list of all arena names. |
| `boolean` | `isArenaReady(String name)` | Checks if an arena is setup and ready. |
| `List<String>` | `getKitNames()` | Returns a list of all kit names. |
| `boolean` | `isKitExists(String name)` | Checks if a kit exists. |
| `ItemStack[]` | `getKitContents(String name)` | Gets the main inventory items of a kit. |
| `ItemStack[]` | `getKitArmor(String name)` | Gets the armor items of a kit. |

### Example Usage:
```java
// List available kits
for (String kitName : api.getKitNames()) {
    getLogger().info("Kit available: " + kitName);
}

// Check if specific arena is ready
if (api.isArenaReady("SpaceStation")) {
    player.sendMessage("The SpaceStation arena is open!");
}
```

---

## 🎮 Game Control & Callbacks

Advanced methods to control the flow of the game or attach callbacks.

| Return Type | Method | Description |
| :--- | :--- | :--- |
| `boolean` | `endFight(Player p, GameEndReason r)` | Forcefully ends a fight for a player. |
| `long` | `getFightDuration(UUID uuid)` | Gets the duration of current fight in seconds. |
| `void` | `onFightStart(UUID u, Consumer<String>)` | Executes code when a fight starts. |
| `void` | `onFightEnd(UUID u, Consumer<Reason>)` | Executes code when a fight ends. |

### Example Usage:
```java
// Force end a game by Admin
api.endFight(player, GameEndReason.AdminForce);

// Display duration
long seconds = api.getFightDuration(player.getUniqueId());
player.sendMessage("Fight lasted: " + seconds + "s");

// Callback on start
api.onFightStart(player.getUniqueId(), (arenaName) -> {
    player.sendTitle("FIGHT!", "Map: " + arenaName, 10, 20, 10);
});
```

---

## 🔔 Events

The API fires standard Bukkit events that you can listen to using `@EventHandler`.

### List of Events

| Event Class | Description | Cancellable |
| :--- | :--- | :---: |
| `PvPGameStartEvent` | Fired when a match physically begins (after the countdown). | ❌ |
| `PvPGameEndEvent` | Fired when a match finishes (Win, Loss, Disconnect, Time limit). | ❌ |
| `ArenaQueueJoinEvent` | Fired when a player attempts to join the Arena queue. | ✅ |
| `ArenaQueueLeaveEvent` | Fired when a player leaves the Arena queue. | ❌ |
| `DefaultQueueJoinEvent` | Fired when a player attempts to join the 1vs1 queue. | ✅ |
| `DefaultQueueLeaveEvent` | Fired when a player leaves the 1vs1 queue. | ❌ |

### Listener Example:
```java
import dev.ua.klaidi4_.spacepvpapi.events.*;

@EventHandler
public void onDuelStart(PvPGameStartEvent event) {
    Player p1 = event.getPlayer1();
    Player p2 = event.getPlayer2();
    String arena = event.getArenaName();
    
    Bukkit.broadcastMessage("⚔️ Duel started: " + p1.getName() + " vs " + p2.getName() + " on " + arena);
}

@EventHandler
public void onQueueJoin(DefaultQueueJoinEvent event) {
    Player player = event.getPlayer();
    
    // Example: Prevent joining queue without permissions
    if (!player.hasPermission("spacepvp.play")) {
        event.setCancelled(true);
        player.sendMessage("§cYou don't have permission to play!");
    }
}
```




