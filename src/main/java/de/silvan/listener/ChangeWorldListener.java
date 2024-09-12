package de.silvan.listener;

import de.silvan.progressbar.ProgressBar;
import de.silvan.takeshi.Takeshi;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class ChangeWorldListener implements Listener {
    @EventHandler
    public void onChangeWorld(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();

        if (player.getWorld() == Bukkit.getWorld("TAKESHI_1")) {
            if (Bukkit.getWorld("TAKESHI_1").getPlayers().size() >= 2) {
                player.sendMessage(ChatColor.RED + "There are already 2 players on this Takeshi Map. You have been teleported to the lobby.");
                player.teleport(new Location(Bukkit.getWorld("LOBBY"), 0, 100, 0));
            }
        }
        ProgressBar.isDone.put(player, false);
        if (player.getWorld().getName().contains("TAKESHI")) {
            if (Takeshi.instance.getBar().getBarPlayer1().getPlayers().isEmpty()) Takeshi.instance.getBar().addPlayer1(player);
            else if (Takeshi.instance.getBar().getBarPlayer2().getPlayers().isEmpty()) Takeshi.instance.getBar().addPlayer2(player);
        } else {
            Takeshi.instance.getBar().removePlayer1(player);
            Takeshi.instance.getBar().removePlayer2(player);
            Takeshi.instance.getBar().removeEndScreen(player);
            Takeshi.instance.getBar().removeStartScreen(player);
        }
    }
}
