package de.silvan.takeshi;

import de.silvan.commands.WarpCommand;
import de.silvan.tablist.TablistManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Takeshi extends JavaPlugin {

    public static Takeshi instance;
    private TablistManager tablistManager;

    @Override
    public void onEnable() {
        instance = this;
        tablistManager = new TablistManager();
        getCommand("warp").setExecutor(new WarpCommand());
        getCommand("w").setExecutor(new WarpCommand());
        getCommand("welt").setExecutor(new WarpCommand());
        getCommand("world").setExecutor(new WarpCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public TablistManager getTablistManager() {
        return tablistManager;
    }

}
