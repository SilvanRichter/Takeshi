package de.silvan.players;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Players {
    public static HashMap<Player, Boolean> isWatching = new HashMap<>();
    public static HashMap<Player, Location> locationBeforeWatching = new HashMap<>();

    public static Player getPlayer(int playerNumber) {
        try {
            return Bukkit.getWorld("TAKESHI_1").getPlayers().get(playerNumber);
        } catch (IndexOutOfBoundsException e) {
            //Bukkit.broadcastMessage(playerNumber + " playerNumber exception");
        }
        return null;
    }
}
