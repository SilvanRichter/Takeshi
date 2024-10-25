package de.silvan.listener;

import de.silvan.takeshi.Takeshi;
import org.bukkit.Bukkit;
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
    }
}
