package de.silvan.listener;

import de.silvan.takeshi.Takeshi;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (Takeshi.instance.getBar().getBarPlayer1().getPlayers().contains(player)) Takeshi.instance.getBar().removePlayer1(player);
        if (Takeshi.instance.getBar().getBarPlayer2().getPlayers().contains(player)) Takeshi.instance.getBar().removePlayer2(player);
        event.setQuitMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.GOLD + " left the game!");
    }
}
