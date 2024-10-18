package de.silvan.listener;

import de.silvan.takeshi.Takeshi;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getItem().getType() == Material.BAMBOO && event.getPlayer().getWorld().equals(Bukkit.getWorld("TAKESHI_1"))) {
            // Name of the "Teleport to Checkpoint" is "Magical Wand to teleport to the last checkpoint".
            // 0-x checkpoints -> first all the checkpoints of player 1 and then all the checkpoint of player 2.
            switch (Takeshi.instance.checkPointSystem.getLastCheckPoint(event.getPlayer())) {
                case 0:
                    Location checkPoint0 = new Location(Bukkit.getWorld("TAKESHI_1"), 0, 0,0, 0, 0);
                    event.getPlayer().teleport(checkPoint0);
                    break;
                case 1:
                    Location checkPoint1 = new Location(Bukkit.getWorld("TAKESHI_1"), 0, 0,0, 0, 0);
                    event.getPlayer().teleport(checkPoint1);
                    break;
                case 2:
                    Location checkPoint2 = new Location(Bukkit.getWorld("TAKESHI_1"), 0, 0,0, 0, 0);
                    event.getPlayer().teleport(checkPoint2);
                    break;
                case 3:
                    Location checkPoint3 = new Location(Bukkit.getWorld("TAKESHI_1"), 0, 0,0, 0, 0);
                    event.getPlayer().teleport(checkPoint3);
                    break;
                case 4:
                    Location checkPoint4 = new Location(Bukkit.getWorld("TAKESHI_1"), 0, 0,0, 0, 0);
                    event.getPlayer().teleport(checkPoint4);
                    break;
            }
        }
    }
}
