package de.silvan.progressbar;

import de.silvan.takeshi.Takeshi;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ProgressBar {
    private BossBar barPlayer1;
    private BossBar barPlayer2;

    public void addPlayer1(Player player) {
        barPlayer1.addPlayer(player);
    }
    public void addPlayer2(Player player) {
        barPlayer1.addPlayer(player);
    }
    public void removePlayer1(Player player) {
        barPlayer1.removePlayer(player);
    }
    public void removePlayer2(Player player) {
        barPlayer1.removePlayer(player);
    }
    public BossBar getBarPlayer1() {
        return barPlayer1;
    }
    public BossBar getBarPlayer2() {
        return barPlayer2;
    }
    public void createBar() {
        barPlayer1 = Bukkit.createBossBar(ChatColor.RED + "Progress", BarColor.BLUE, BarStyle.SOLID);
        barPlayer1.setVisible(true);
        barPlayer2 = Bukkit.createBossBar(ChatColor.RED + "Progress", BarColor.BLUE, BarStyle.SOLID);
        barPlayer2.setVisible(true);
        cast();
    }
    public void cast() {
        new BukkitRunnable() {
            @Override
            public void run() {

            }
        }.runTaskTimer(Takeshi.instance, 20, 20);
    }
}
