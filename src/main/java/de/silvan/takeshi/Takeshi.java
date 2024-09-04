package de.silvan.takeshi;

import de.silvan.commands.LobbyCommand;
import de.silvan.commands.WarpCommand;
import de.silvan.listener.ChangeWorldListener;
import de.silvan.listener.InventoryListener;
import de.silvan.listener.JoinListener;
import de.silvan.progressbar.ProgressBar;
import de.silvan.tablist.TablistManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Takeshi extends JavaPlugin {

    public static Takeshi instance;
    private TablistManager tablistManager;
    public ProgressBar bar;

    @Override
    public void onEnable() {
        instance = this;
        tablistManager = new TablistManager();
        bar = new ProgressBar();
        bar.createBar();

        PluginManager pl = Bukkit.getPluginManager();
        pl.registerEvents(new JoinListener(), this);
        pl.registerEvents(new InventoryListener(), this);
        pl.registerEvents(new ChangeWorldListener(), this);

        getCommand("warp").setExecutor(new WarpCommand());
        getCommand("w").setExecutor(new WarpCommand());
        getCommand("welt").setExecutor(new WarpCommand());
        getCommand("world").setExecutor(new WarpCommand());
        getCommand("lobby").setExecutor(new LobbyCommand());
        getCommand("l").setExecutor(new LobbyCommand());
        getCommand("hub").setExecutor(new LobbyCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public TablistManager getTablistManager() {
        return tablistManager;
    }

    public ProgressBar getBar() { return bar; }
}
