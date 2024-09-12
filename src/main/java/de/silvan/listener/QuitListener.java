package de.silvan.listener;

import de.silvan.progressbar.ProgressBar;
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
        ProgressBar.isDone.put(player, false);
        Takeshi.instance.getBar().removePlayer1(player);
        Takeshi.instance.getBar().removePlayer2(player);
        Takeshi.instance.getBar().removeStartScreen(player);
        Takeshi.instance.getBar().removeStartScreen(player);
        event.setQuitMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.GOLD + " left the game!");
    }
}
