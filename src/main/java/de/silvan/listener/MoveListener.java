package de.silvan.listener;

import de.silvan.takeshi.Takeshi;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class MoveListener implements Listener {







    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getWorld().equals(Bukkit.getWorld("TAKESHI_1")) || player.getWorld().equals(Bukkit.getWorld("LOBBY"))) {
            if (!(player.getGameMode() == GameMode.CREATIVE) || !(player.getGameMode() == GameMode.SPECTATOR)) {
                switch (player.getWorld().getName()) {
                    case "LOBBY":
                        if (player.getLocation().getY() <= 75)
                            player.teleport(new Location(Bukkit.getWorld("LOBBY"), 0, 100, 0));
                        break;
                    case "TAKESHI_1":
                        if (player.getLocation().getY() <= 102) {
                            Takeshi.instance.checkPointSystem.teleportToLastCheckPoint(player);
                        }
                        break;
                }
            }
        }

        Location checkPoint0 = new Location(Bukkit.getWorld("TAKESHI_1"), 4.5, 105, 35.5);
        Location checkPoint1 = new Location(Bukkit.getWorld("TAKESHI_1"), 5.5, 105,56.5);
        Location checkPoint2 = new Location(Bukkit.getWorld("TAKESHI_1"), 3.5, 107,87.5);
        Location checkPoint3 = new Location(Bukkit.getWorld("TAKESHI_1"), 1.5, 107,96.5);

        Location checkPoint4 = new Location(Bukkit.getWorld("TAKESHI_1"), -6.5, 106,27.5);
        Location checkPoint5 = new Location(Bukkit.getWorld("TAKESHI_1"), -4.5, 107,74.5);
        Location checkPoint6 = new Location(Bukkit.getWorld("TAKESHI_1"), -4.5, 108, 94.5);
        Location checkPoint7 = new Location(Bukkit.getWorld("TAKESHI_1"), -3.5, 108,74.5);


        Location player1LapisLazuli1 = new Location(Bukkit.getWorld("TAKESHI_1"), 3, 107, 29);
        Location player1LapisLazuli2 = new Location(Bukkit.getWorld("TAKESHI_1"), 0, 106, 54);

        Location player2LapisLazuli1 = new Location(Bukkit.getWorld("TAKESHI_1"), -7, 105, 28);
        Location player2LapisLazuli2 = new Location(Bukkit.getWorld("TAKESHI_1"), -6, 105, 28);
        Location player2LapisLazuli3 = new Location(Bukkit.getWorld("TAKESHI_1"), -2, 102, 86);
        Location player2LapisLazuli4 = new Location(Bukkit.getWorld("TAKESHI_1"), -8, 107, 99);

        Location player1Diamond1 = new Location(Bukkit.getWorld("TAKESHI_1"), 0, 102, 62);
        Location player1Diamond2 = new Location(Bukkit.getWorld("TAKESHI_1"), 0, 108, 62);

        Location player2Diamond1 = new Location(Bukkit.getWorld("TAKESHI_1"), -6, 106, 65);
        Location player2Diamond2 = new Location(Bukkit.getWorld("TAKESHI_1"), 5, 106, 65);
        Location player2Diamond3 = new Location(Bukkit.getWorld("TAKESHI_1"), 6, 106, 77);
        Location player2Diamond4 = new Location(Bukkit.getWorld("TAKESHI_1"), -5, 106, 71);

        Location player1Emerald1 = new Location(Bukkit.getWorld("TAKESHI_1"), 5, 104, 40);

        Location player2Emerald1 = new Location(Bukkit.getWorld("TAKESHI_1"), -5, 103, 37);
        Location player2Emerald3 = new Location(Bukkit.getWorld("TAKESHI_1"), -2, 102, 78);
        Location player2Emerald5 = new Location(Bukkit.getWorld("TAKESHI_1"), -5, 105, 99);

        Location leftToPlayer = player.getLocation().add(0.2, 0, 0);
        Location rightToPlayer = player.getLocation().subtract(0.2, 0, 0);

        switch (getBlockBelowPlayer(player).getType()) {
            case LAPIS_BLOCK:
                if (getBlockBelowPlayer(player).getLocation().equals(player2LapisLazuli1) || getBlockBelowPlayer(player).getLocation().equals(player2LapisLazuli2)) {
                    player.addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 20, 10, false, false, false)));
                    player.spawnParticle(Particle.FLAME, player.getLocation(), 10);
                }
                if (getBlockBelowPlayer(player).getLocation().equals(player2LapisLazuli3)) {
                    player.addPotionEffect((new PotionEffect(PotionEffectType.JUMP, 20, 4, false, false, false)));
                    player.spawnParticle(Particle.GLOW, player.getLocation(), 10);
                }
                if (getBlockBelowPlayer(player).getLocation().equals(player2LapisLazuli4)) {
                    player.addPotionEffect((new PotionEffect(PotionEffectType.SLOW_FALLING, 40, 0, false, false, false)));
                    player.spawnParticle(Particle.CLOUD, player.getLocation(), 10);
                }
                if (getBlockBelowPlayer(player).getLocation().equals(player1LapisLazuli1)) {
                    player.addPotionEffect((new PotionEffect(PotionEffectType.SLOW_FALLING, 55 , 0, false, false, false)));
                    player.addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 55, 4, false, false, false)));
                    player.spawnParticle(Particle.CLOUD, leftToPlayer, 10);
                    player.spawnParticle(Particle.FLAME, rightToPlayer, 10);
                }
                if (getBlockBelowPlayer(player).getLocation().equals(player1LapisLazuli2)) {
                    player.addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 20, 4, false, false, false)));
                    player.spawnParticle(Particle.FLAME, player.getLocation(), 10);
                }
                break;
            case DIAMOND_BLOCK:
                if (getBlockBelowPlayer(player).getLocation().equals(player1Diamond1)) {
                    player.teleport(player1Diamond2.add(0.5, 1, 0.5));
                    player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 100, 1);
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, SoundCategory.MASTER, 100, 1);
                }
                if (getBlockBelowPlayer(player).getLocation().equals(player2Diamond1)) {
                    player.teleport(player2Diamond2.add(.5, 1, 0.5));
                    player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 100, 1);
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, SoundCategory.MASTER, 100, 1);
                }
                if (getBlockBelowPlayer(player).getLocation().equals(player2Diamond3)) {
                    player.teleport(player2Diamond4.add(.5, 1, 0.5));
                    player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 100, 1);
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, SoundCategory.MASTER, 100, 1);
                }
                break;
            case EMERALD_BLOCK:
                if (getBlockBelowPlayer(player).getLocation().equals(player1Emerald1)) {
                    player.setVelocity(new Vector(0.09, 1, -0.91));
                }
                if (getBlockBelowPlayer(player).getLocation().equals(player2Emerald1)) {
                    player.setVelocity(new Vector(0.09, 1.333, 1.04));
                }
                if (getBlockBelowPlayer(player).getLocation().equals(player2Emerald3)) {
                    player.setVelocity(new Vector(0, 1.45, 1.2));
                }
                if (getBlockBelowPlayer(player).getLocation().equals(player2Emerald5)) {
                    player.setVelocity(new Vector(-0.18, 0.8, 3.35));
                }
                break;
            case AMETHYST_BLOCK:
                Bukkit.broadcastMessage("0");
                if (getBlockBelowPlayer(player).getLocation().equals(checkPoint0)) {
                    Takeshi.instance.checkPointSystem.setLastCheckPoint(player, Takeshi.instance.checkPointSystem.checkPoint0);
                    Bukkit.broadcastMessage("1");
                }
                if (getBlockBelowPlayer(player).getLocation().equals(checkPoint1)) {
                    Takeshi.instance.checkPointSystem.setLastCheckPoint(player, Takeshi.instance.checkPointSystem.checkPoint1);
                    Bukkit.broadcastMessage("2");
                }
                if (getBlockBelowPlayer(player).getLocation().equals(checkPoint2)) {
                    Takeshi.instance.checkPointSystem.setLastCheckPoint(player, Takeshi.instance.checkPointSystem.checkPoint2);
                    Bukkit.broadcastMessage("3");
                }
                if (getBlockBelowPlayer(player).getLocation().equals(checkPoint3)) {
                    Takeshi.instance.checkPointSystem.setLastCheckPoint(player, Takeshi.instance.checkPointSystem.checkPoint3);
                    Bukkit.broadcastMessage("4");
                }
                if (getBlockBelowPlayer(player).getLocation().equals(checkPoint4)) {
                    Takeshi.instance.checkPointSystem.setLastCheckPoint(player, Takeshi.instance.checkPointSystem.checkPoint4);
                    Bukkit.broadcastMessage("5");
                }
                if (getBlockBelowPlayer(player).getLocation().equals(checkPoint5)) {
                    Takeshi.instance.checkPointSystem.setLastCheckPoint(player, Takeshi.instance.checkPointSystem.checkPoint5);
                    Bukkit.broadcastMessage("6");
                }
                if (getBlockBelowPlayer(player).getLocation().equals(checkPoint6)) {
                    Takeshi.instance.checkPointSystem.setLastCheckPoint(player, Takeshi.instance.checkPointSystem.checkPoint6);
                    Bukkit.broadcastMessage("7");
                }
                if (getBlockBelowPlayer(player).getLocation().equals(checkPoint7)) {
                    Takeshi.instance.checkPointSystem.setLastCheckPoint(player, Takeshi.instance.checkPointSystem.checkPoint7);
                    Bukkit.broadcastMessage("8");
                }
                break;
        }
    }
    public Block getBlockBelowPlayer(Player player) {
        Location playerLocation = new Location(player.getLocation().getWorld(),
                player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
        Location blockBelowLocation = playerLocation.subtract(0, 1, 0);
        Block blockBelow = blockBelowLocation.getBlock();
        return blockBelow;
    }
}