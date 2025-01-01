package de.silvan.commands;

import de.silvan.parkour.Player1Module1;
import de.silvan.players.Players;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WatchCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            /*
            if (!Players.isWatching.containsKey(player)) {
                Players.isWatching.put(player, false);
            }
            if (Players.isWatching.get(player)) {
                player.teleport(Players.locationBeforeWatching.get(player));
                player.setGameMode(GameMode.SURVIVAL);
                Players.isWatching.put(player, false);
            } else {
                Players.locationBeforeWatching.put(player, player.getLocation());
                player.setGameMode(GameMode.SPECTATOR);
                if (Players.getPlayer(0) == null) {
                    player.sendMessage(ChatColor.RED + "No player to watch. 1");
                    return false;
                }
                if (Players.getPlayer(1) == null) {
                    player.sendMessage(ChatColor.RED + "No player to watch. 2");
                    return false;
                }
                if (Players.getPlayer(0) == player) {
                    player.setSpectatorTarget(Players.getPlayer(1));
                    return true;
                } else if (Players.getPlayer(1) == player) {
                    player.setSpectatorTarget(Players.getPlayer(0));
                    return true;
                } else {
                    player.sendMessage(ChatColor.RED + "Error in WatchCommand!");
                }
            }

             */
        } else sender.sendMessage(ChatColor.RED + "You have to be a player to execute this command!");
        return false;
    }
}
