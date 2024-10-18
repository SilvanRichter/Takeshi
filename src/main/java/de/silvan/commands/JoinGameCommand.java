package de.silvan.commands;

import de.silvan.players.Players;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinGameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You have to be a player to execute this command!");
            return false;
        }

        if (Bukkit.getWorld("TAKESHI_1").getPlayers().size() >= 2) {
            sender.sendMessage(ChatColor.RED + "There are already 2 player in this game!");
            return false;
        }
        Location spawn1 = new Location(Bukkit.getWorld("TAKESHI_1"), 0, 0,0, 0, 0);
        Location spawn2 = new Location(Bukkit.getWorld("TAKESHI_1"), 0, 0,0, 0, 0);
        if (Players.getPlayer(0) == null) ((Player) sender).teleport(spawn1);
        else ((Player) sender).teleport(spawn2);
        return false;
    }
}