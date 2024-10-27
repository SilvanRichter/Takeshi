package de.silvan.listener;

import de.silvan.takeshi.Takeshi;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getItem().getType() == Material.BAMBOO && event.getPlayer().getWorld().equals(Bukkit.getWorld("TAKESHI_1"))) {
            Takeshi.instance.checkPointSystem.teleportToLastCheckPoint(event.getPlayer());
        }
        if (event.getItem().getType() == Material.COMPASS && event.getPlayer().getWorld().equals(Bukkit.getWorld("TAKESHI_1"))) {
            Takeshi.instance.checkPointSystem.teleportToLastCheckPoint(event.getPlayer());
            event.getPlayer().sendMessage(ChatColor.BLUE + "The holy magical wand has granted you the permission" +
                    " to get to the last checkpoint, say thanks!");
        }
    }
}
