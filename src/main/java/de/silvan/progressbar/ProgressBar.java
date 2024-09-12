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
        new BukkitRunnable() {
            @Override
            public void run() {
                //Player 1
                if (!(Players.getPlayer(0) == null)) {
                    if (!isDone.containsKey(Players.getPlayer(0))) {
                        isDone.put(Players.getPlayer(0), false);
                    }
                    if (!isDone.get(Players.getPlayer(0))) {
                        z1[0] = (Players.getPlayer(0).getLocation().getZ()) / 132;
                         if (z1[0] < 0) {
                            barPlayer1.setProgress(0.0);
                            barPlayer1.setTitle(ChatColor.RED + "Fortschritt: " + ChatColor.BLUE + Math.round(z1[0] * 100) + ChatColor.DARK_BLUE + "%");
                        } else if (Players.getPlayer(0).getLocation().getZ() >= 132) {
                            isDone.put(Players.getPlayer(0), true);
                            removePlayer1(Players.getPlayer(0));
                            addEndScreen(Players.getPlayer(0));
                        } else if (Players.getPlayer(0).getLocation().getZ() <= 4) {
                            addStartScreen(Players.getPlayer(0));
                            removePlayer1(Players.getPlayer(0));
                        } else {
                            addPlayer1(Players.getPlayer(0));
                            removeStartScreen(Players.getPlayer(0));
                            barPlayer1.setProgress(z1[0]);
                            barPlayer1.setTitle(ChatColor.RED + "Fortschritt: " + ChatColor.BLUE + Math.round(z1[0] * 100) + ChatColor.DARK_BLUE + "%");
                        }
                    }
                }
                //Player 2
                if (!(Players.getPlayer(1) == null)) {
                    if (!isDone.containsKey(Players.getPlayer(1))) {
                        isDone.put(Players.getPlayer(1), false);
                    }
                    if (!isDone.get(Players.getPlayer(1))) {
                        z1[0] = (Players.getPlayer(1).getLocation().getZ()) / 132;
                        if (z1[0] < 0) {
                            barPlayer2.setProgress(0.0);
                            barPlayer2.setTitle(ChatColor.RED + "Fortschritt: " + ChatColor.BLUE + Math.round(z1[0] * 100) + ChatColor.DARK_BLUE + "%");
                        } else if (Players.getPlayer(1).getLocation().getZ() >= 132) {
                            isDone.put(Players.getPlayer(1), true);
                            removePlayer2(Players.getPlayer(1));
                            addEndScreen(Players.getPlayer(1));
                        } else if (Players.getPlayer(1).getLocation().getZ() <= 4) {
                            addStartScreen(Players.getPlayer(1));
                            removePlayer2(Players.getPlayer(1));
                        } else {
                            addPlayer2(Players.getPlayer(1));
                            removeStartScreen(Players.getPlayer(1));
                            barPlayer2.setProgress(z1[0]);
                            barPlayer2.setTitle(ChatColor.RED + "Fortschritt: " + ChatColor.BLUE + Math.round(z1[0] * 100) + ChatColor.DARK_BLUE + "%");
                        }
                    }
                }
            }
        }.runTaskTimer(Takeshi.instance,  0, 0);
    }
}