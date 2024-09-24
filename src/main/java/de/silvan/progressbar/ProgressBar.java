package de.silvan.progressbar;

import de.silvan.players.Players;
import de.silvan.takeshi.Takeshi;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class ProgressBar {
    private BossBar barPlayer1;
    private BossBar barPlayer2;
    private BossBar barStart;
    private BossBar barEnd;
    public static HashMap<Player, Boolean> isDone = new HashMap<>();

    public void addPlayer1(Player player) {
        barPlayer1.addPlayer(player);
    }
    public void addPlayer2(Player player) {
        barPlayer1.addPlayer(player);
    }
    public void addStartScreen(Player player) {
        barStart.addPlayer(player);
    }
    public void addEndScreen(Player player) {
        barEnd.addPlayer(player);
    }
    public void removePlayer1(Player player) {
        barPlayer1.removePlayer(player);
    }
    public void removePlayer2(Player player) {
        barPlayer1.removePlayer(player);
    }
    public void removeStartScreen(Player player) {
        barStart.removePlayer(player);
    }
    public void removeEndScreen(Player player) {
        barEnd.removePlayer(player);
    }
    public BossBar getBarPlayer1() {
        return barPlayer1;
    }
    public BossBar getBarPlayer2() {
        return barPlayer2;
    }
    public BossBar getBarStart() {
        return barStart;
    }
    public BossBar getBarEnd() {
        return barEnd;
    }

    public void createBar() {
        barPlayer1 = Bukkit.createBossBar(ChatColor.RED + "Fortschritt: " + ChatColor.BLUE + "0" + ChatColor.DARK_AQUA + "%", BarColor.BLUE, BarStyle.SOLID);
        barPlayer1.setVisible(true);
        barPlayer2 = Bukkit.createBossBar(ChatColor.RED + "Fortschritt: " + ChatColor.BLUE + "0" + ChatColor.DARK_AQUA + "%", BarColor.BLUE, BarStyle.SOLID);
        barPlayer2.setVisible(true);
        barStart = Bukkit.createBossBar(ChatColor.RED + "Let's Go!", BarColor.RED, BarStyle.SOLID);
        barStart.setVisible(true);
        barEnd = Bukkit.createBossBar(ChatColor.RED + "Done! Congratulations!", BarColor.GREEN, BarStyle.SOLID);
        barEnd.setVisible(true);
        cast();
    }

    public void cast() {
        final double[] z1 = {0.0};
        final double[] z2 = {0.0};
        new BukkitRunnable() {
            @Override
            public void run() {
                //Player 1
                if (Players.getPlayer(0) != null) {
                    updateBossbar(Players.getPlayer(0), z1, z2);
                }
                //Player 2
                if (Players.getPlayer(1) != null) {
                    updateBossbar(Players.getPlayer(1), z1, z2);
                }
            }
        }.runTaskTimer(Takeshi.instance, 0, 0);
    }

     public void updateBossbar(Player player, double[] z1, double[] z2) {
        if (player.equals(Players.getPlayer(0))) {
            z1[0] = (player.getLocation().getZ()) / 132;
            if (!isDone.containsKey(player)) {
                isDone.put(player, false);
            }
            if (!isDone.get(player)) {
                z1[0] = (player.getLocation().getZ()) / 132;
                if (z1[0] < 0) {
                    barPlayer1.setProgress(0.0);
                    barPlayer1.setTitle(ChatColor.RED + "Fortschritt: " + ChatColor.BLUE + Math.round(z1[0] * 100) + ChatColor.DARK_BLUE + "%");
                } else if (player.getLocation().getZ() >= 132) {
                    isDone.put(player, true);
                    removePlayer1(player);
                    addEndScreen(player);
                } else if (player.getLocation().getZ() <= 4) {
                    addStartScreen(player);
                    removePlayer1(player);
                } else {
                    addPlayer1(player);
                    removeStartScreen(player);
                    barPlayer1.setProgress(z1[0]);
                    barPlayer1.setTitle(ChatColor.RED + "Fortschritt: " + ChatColor.BLUE + Math.round(z1[0] * 100) + ChatColor.DARK_BLUE + "%");
                }
            }
        }
         if (player.equals(Players.getPlayer(1))) {
             z2[0] = (player.getLocation().getZ()) / 132;
             if (!isDone.containsKey(player)) {
                 isDone.put(player, false);
             }
             if (!isDone.get(player)) {
                 z2[0] = (player.getLocation().getZ()) / 132;
                 if (z2[0] < 0) {
                     barPlayer2.setProgress(0.0);
                     barPlayer2.setTitle(ChatColor.RED + "Fortschritt: " + ChatColor.BLUE + Math.round(z2[0] * 100) + ChatColor.DARK_BLUE + "%");
                 } else if (player.getLocation().getZ() >= 132) {
                     isDone.put(player, true);
                     removePlayer2(player);
                     addEndScreen(player);
                 } else if (player.getLocation().getZ() <= 4) {
                     addStartScreen(player);
                     removePlayer2(player);
                 } else {
                     addPlayer2(player);
                     removeStartScreen(player);
                     barPlayer2.setProgress(z2[0]);
                     barPlayer2.setTitle(ChatColor.RED + "Fortschritt: " + ChatColor.BLUE + Math.round(z2[0] * 100) + ChatColor.DARK_BLUE + "%");
                 }
             }
         }
     }
}