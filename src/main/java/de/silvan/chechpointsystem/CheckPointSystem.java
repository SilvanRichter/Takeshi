package de.silvan.chechpointsystem;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class CheckPointSystem {
    private HashMap<Player, Integer> lastCheckPoint = new HashMap<>();

    public Integer getLastCheckPoint(Player player) {
        return lastCheckPoint.get(player);
    }

    public void setLastCheckPoint(Player player, Integer checkPointNumber) {
        lastCheckPoint.put(player, checkPointNumber);
    }
}
