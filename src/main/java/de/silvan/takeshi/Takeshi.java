package de.silvan.takeshi;

import de.silvan.chechpointsystem.CheckPointSystem;
import de.silvan.commands.*;
import de.silvan.games.FlappyBird;
import de.silvan.listener.*;
import de.silvan.progressbar.ProgressBar;
import de.silvan.tablist.TablistManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Takeshi extends JavaPlugin {

    public static Takeshi instance;
    private TablistManager tablistManager;
    public ProgressBar bar;
    public FlappyBird flappyBird;
    public CheckPointSystem checkPointSystem;

    @Override
    public void onEnable() {
        instance = this;
        tablistManager = new TablistManager();
        bar = new ProgressBar();
        flappyBird = new FlappyBird();
        checkPointSystem = new CheckPointSystem();
        bar.createBar();

        //TODO: Watch Compass to view the other player (just the /spectate command)
        //TODO: Start System
        //TODO: Add "CheckPoint Wand" and "Watch Compass" to the player's inv
        //TODO: Checkpoint System

        PluginManager pl = Bukkit.getPluginManager();
        pl.registerEvents(new JoinListener(), this);
        pl.registerEvents(new ChangeWorldListener(), this);
        pl.registerEvents(new MoveListener(), this);
        pl.registerEvents(new DamageListener(), this);
        pl.registerEvents(new InteractListener(), this);
        pl.registerEvents(this.flappyBird, this);

        getCommand("warp").setExecutor(new WarpCommand());
        getCommand("w").setExecutor(new WarpCommand());
        getCommand("welt").setExecutor(new WarpCommand());
        getCommand("world").setExecutor(new WarpCommand());
        getCommand("lobby").setExecutor(new LobbyCommand());
        getCommand("l").setExecutor(new LobbyCommand());
        getCommand("hub").setExecutor(new LobbyCommand());
        getCommand("watch").setExecutor(new WatchCommand());
        getCommand("startflappybird").setExecutor(new StartFlappyBird());
        getCommand("start").setExecutor(new StartCommand());
        getCommand("joingame").setExecutor(new JoinGameCommand());
    }

    public TablistManager getTablistManager() {
        return tablistManager;
    }

    public ProgressBar getBar() { return bar; }
}
