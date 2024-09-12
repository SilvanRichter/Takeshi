package de.silvan.parkour;

import de.silvan.takeshi.Takeshi;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Player1Module1 {
    public static void start(Player player) {

        final boolean[] inGame = {false};
        final int[] progress = {0};
        new BukkitRunnable() {
            @Override
            public void run() {
                if ((player.getLocation().getZ() >= 4) && (player.getLocation().getZ() <= 21)) {
                    String message = "§4§lRUN!";
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    inGame[0] = true;

                    // 8 Sekunden -> 8 x 20 = 160
                    if (progress[0] >= 160) {
                        progress[0] = progress[0] + 1;

                    }
                } else inGame[0] = false;
            }
        }.runTaskTimer(Takeshi.instance, 0, 0);
    }
}
