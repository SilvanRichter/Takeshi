package de.silvan.commands;

import de.silvan.takeshi.Takeshi;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class startFlappyBird implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Takeshi.instance.flappyBird.start(player);
        }
        return false;
    }
}
