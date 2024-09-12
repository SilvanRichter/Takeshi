package de.silvan.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 1) {
                switch (args[0]) {
                    case "LOBBY":
                        player.teleport(new Location(Bukkit.getWorld("LOBBY"), 0, 100, 0));
                        return true;
                    case "TAKESHI_1":
                        player.teleport(new Location(Bukkit.getWorld("TAKESHI_1"), -1, 112, 2));
                        return true;
                    default:
                        sender.sendMessage(ChatColor.RED + "/world <server>");
                        return true;
                }
            } else sender.sendMessage(ChatColor.RED + "/world <server>");
        }
        return false;
    }
}