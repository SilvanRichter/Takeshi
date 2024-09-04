package de.silvan.listener;

import de.silvan.takeshi.Takeshi;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Takeshi.instance.getTablistManager().setTablist(player);

        player.teleport(new Location(Bukkit.getWorld("LOBBY"), 0, 100, 0));

        if (player.getWorld().getName().contains("TAKESHI")) {
            if (Takeshi.instance.getBar().getBarPlayer1().getPlayers().isEmpty()) Takeshi.instance.getBar().addPlayer1(player); else
                if (Takeshi.instance.getBar().getBarPlayer2().getPlayers().isEmpty()) Takeshi.instance.getBar().addPlayer2(player);
        } else {
            if (Takeshi.instance.getBar().getBarPlayer1().getPlayers().contains(player)) Takeshi.instance.getBar().removePlayer1(player);
            if (Takeshi.instance.getBar().getBarPlayer2().getPlayers().contains(player)) Takeshi.instance.getBar().removePlayer2(player);
        }
        event.setJoinMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.GOLD + " joined the game!");
    }
}
