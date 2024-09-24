package de.silvan.games;

import de.silvan.takeshi.Takeshi;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class SpaceInvaders implements Listener {

    private boolean gameStarted;
    private ArmorStand shipArmorStand;
    private int wave = 0;
    Location goldBlock = new Location(Bukkit.getWorld("TAKESHI_1"), 7, 106, 87);

    public void start(Player player) {
        if (gameStarted) {
            player.sendMessage("The game is already running!");
            return;
        }
        Bukkit.broadcastMessage("Starting!");
        gameStarted = true;

        wave = 0;  // Reset score at the start of the game
        Location startLocation = new Location(player.getWorld(), 18, 108, 52);  // Starting location for the bird

        // Spawn bird (armor stand)
        shipArmorStand = (ArmorStand) player.getWorld().spawnEntity(startLocation, EntityType.ARMOR_STAND);
        shipArmorStand.setInvisible(true);
        shipArmorStand.setSmall(true);
        shipArmorStand.setInvulnerable(true);

        // Set player's head on the ship
        ItemStack shipHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) shipHead.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(player.getUniqueId()));
        shipHead.setItemMeta(skullMeta);
        shipArmorStand.setHelmet(shipHead);

        new BukkitRunnable() {
            @Override
            public void run() {
                if (gameStarted) {
                    String message = "§4Flappy $bBird$9!";
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));

                } else {
                    cancel();
                }
            }
        }.runTaskTimer(Takeshi.instance, 0L, 1L);  // Run every tick
    }

    public void showGameOverScreen(Player player) {
        player.sendTitle("Game Over", "The Wave: " + wave, 10, 70, 20);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (getBlockBelow(player).getLocation().equals(goldBlock)) {
            if (gameStarted) {
                if (event.getAction() == Action.LEFT_CLICK_AIR) {
                    shoot(player);
                }
            }
        }
    }

    public void shoot(Player player) {
        Location shootLocation = shipArmorStand.getLocation().add(0, 1, 0); // Adjust as needed
        ArmorStand projectile = (ArmorStand) player.getWorld().spawnEntity(shootLocation, EntityType.ARMOR_STAND);
        projectile.setInvisible(true);
        projectile.setSmall(true);
        projectile.setInvulnerable(true);
        projectile.setVelocity(new Vector(0, 1, 0)); // Adjust direction and speed as needed

        new BukkitRunnable() {
            @Override
            public void run() {
                if (projectile.isDead() || !gameStarted) {
                    projectile.remove();
                    cancel();
                } else {
                    checkProjectileCollision(projectile);
                }
            }
        }.runTaskTimer(Takeshi.instance, 0L, 1L); // Run every tick
    }

    public void checkProjectileCollision(ArmorStand projectile) {
        //Block blockAhead = getBlockAhead(projectile);
        //if (blockAhead.getType() != Material.AIR) {
        projectile.remove();
        // Handle collision (e.g., destroy target, increase score)
    }

    public Block getBlockBelow(Entity entity) {
        Location playerLocation = new Location(entity.getLocation().getWorld(),
                entity.getLocation().getBlockX(), entity.getLocation().getBlockY(), entity.getLocation().getBlockZ());
        Location blockBelowLocation = playerLocation.subtract(0, 1, 0);
        Block blockBelow = blockBelowLocation.getBlock();
        return blockBelow;
    }
}
