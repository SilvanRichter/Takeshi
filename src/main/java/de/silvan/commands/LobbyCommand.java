package de.silvan.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LobbyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You have to be a player to execute this command");
            return true;
        }
        Location lobby = new Location(Bukkit.getWorld("LOBBY"), 0, 100, 0);
        Player player = (Player) sender;
        if (player.getWorld() == Bukkit.getWorld("LOBBY")) {
            player.sendMessage(ChatColor.RED + "You are already in the lobby -> Teleported to the spawn!");
            player.teleport(lobby);
            return true;
        }
        player.teleport(lobby);
        return false;
    }
}
