package de.silvan.listener;

import de.silvan.takeshi.Takeshi;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Takeshi.instance.getTablistManager().setTablist(player);
    }
}
