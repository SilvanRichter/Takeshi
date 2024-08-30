package de.silvan.tablist;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TablistManager {
    public static TablistManager tablistManager;
    public void setTablist(Player player) {
        tablistManager = this;
        player.setPlayerListHeaderFooter("\n" + "" + "\n" + "&cT&6A&8K&2E&3S&fH&5I" /* TAKESHI */ + "\n" + "",
                "\n" + ChatColor.AQUA + "Made completely by " + ChatColor.GOLD + "Silvan" + ChatColor.AQUA + "!");
    }
}
