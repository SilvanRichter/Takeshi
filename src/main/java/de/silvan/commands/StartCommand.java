package de.silvan.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (Bukkit.getWorld("TAKESHI_1").getPlayers().size() == 2) {

        } else {
            sender.sendMessage(ChatColor.RED + "There are not 2 players on TAKESHI_1!");
            return false;
        }

        return false;
    }
}
