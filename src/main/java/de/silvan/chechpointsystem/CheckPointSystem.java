package de.silvan.chechpointsystem;

import de.silvan.players.Players;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class CheckPointSystem {
    public HashMap<Player, Location> lastCheckPoint = new HashMap<>();

    public Location start0 = new Location(Bukkit.getWorld("TAKESHI_1"), 3.5, 103, 2.5, 0, 0);
    public Location start1 = new Location(Bukkit.getWorld("TAKESHI_1"), -4.5, 103, 2.5, 0, 0);

    public Location checkPoint0 = new Location(Bukkit.getWorld("TAKESHI_1"), 4.5, 105, 35.5, -10, 20);
    public Location checkPoint1 = new Location(Bukkit.getWorld("TAKESHI_1"), 5.5, 105,56.5, 0, 0);
    public Location checkPoint2 = new Location(Bukkit.getWorld("TAKESHI_1"), 3.5, 107,87.5, -25, 5);
    public Location checkPoint3 = new Location(Bukkit.getWorld("TAKESHI_1"), 1.5, 107,96.5, -72, 15);

    public Location checkPoint4 = new Location(Bukkit.getWorld("TAKESHI_1"), -6.5, 106,27.5, -10, 10);
    public Location checkPoint5 = new Location(Bukkit.getWorld("TAKESHI_1"), -4.5, 107,74.5, 0, 0);
    public Location checkPoint6 = new Location(Bukkit.getWorld("TAKESHI_1"), -4.5, 108, 94.5, 30, 10);
    public Location checkPoint7 = new Location(Bukkit.getWorld("TAKESHI_1"), -3.5, 108,74.5, 180, 0);

    public Location getLastCheckPoint(Player player) {
        return lastCheckPoint.get(player);
    }

    public void setLastCheckPoint(Player player, Location checkPointLocation) {
        lastCheckPoint.put(player, checkPointLocation);
    }

    public void teleportToLastCheckPoint(Player player) {
        Location lastCheckPoint = this.lastCheckPoint.get(player);
        if (start0.getWorld() == null) player.sendMessage("start0.getWorld() is null");
        if (lastCheckPoint != null && lastCheckPoint.getWorld() != null) {
            player.teleport(lastCheckPoint);
        } else {
            player.sendMessage("Error: Line 39, CheckPointSystem.java");
            player.sendMessage("lastCheckPoint = start0");
            lastCheckPoint = start0;
            if (lastCheckPoint == null) player.sendMessage("lastCheckPoint = null"); else player.sendMessage(ChatColor.RED + lastCheckPoint.toString());
            if (lastCheckPoint.getWorld() == null) player.sendMessage("lastCheckPoint.getWorld() = null"); else player.sendMessage(ChatColor.GREEN + lastCheckPoint.getWorld().getName());
        }
    }
    public void tp(Player player) {
        if (lastCheckPoint.get(player) == null) {
            if (Players.getPlayer(0).equals(player)) {
                lastCheckPoint.put(player, start0);
            }
            if (Players.getPlayer(1).equals(player)) {
                lastCheckPoint.put(player, start1);
            }
        }
        player.teleport(getLastCheckPoint(player));
    }
}
