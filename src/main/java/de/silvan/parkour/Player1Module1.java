package de.silvan.parkour;

import de.silvan.players.Players;
import de.silvan.takeshi.Takeshi;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Player1Module1 {
    public static void start(Player player) {
        final int[] progress = {0};
        new BukkitRunnable() {
            @Override
            public void run() {
                if ((player.getLocation().getZ() >= 4) && (player.getLocation().getZ() <= 21)) {
                    String message = "§4RUN!";
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));

                    if (getBlockBelowPlayer(player).getType() == Material.RED_CONCRETE) {
                        if (player == Players.getPlayer(0)) {
                            player.teleport(new Location(Bukkit.getWorld("TAKESHI_1"), 3.5, 103, 1.5));
                        }
                        if (player == Players.getPlayer(1)) {
                            player.teleport(new Location(Bukkit.getWorld("TAKESHI_1"), 3.5, 103, 1.5));
                        }
                    }
                    if (progress[0] <  48) {
                        progress[0] = progress[0] + 1;

                    }
                }
            }
        }.runTaskTimer(Takeshi.instance, 10, 10);
    }
    public static Block getBlockBelowPlayer(Player player) {
        Location playerLocation = new Location(player.getLocation().getWorld(),
                player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
        Location blockBelowLocation = playerLocation.subtract(0, 1, 0);
        Block blockBelow = blockBelowLocation.getBlock();
        return blockBelow;
    }
}
