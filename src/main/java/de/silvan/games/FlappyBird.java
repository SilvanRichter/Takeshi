package de.silvan.games;

import de.silvan.takeshi.Takeshi;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
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

import java.util.Random;

public class FlappyBird implements Listener {

    private boolean gameStarted = false;
    private ArmorStand birdArmorStand;
    private int score = 0;
    private Random random = new Random();
    Location goldBlock = new Location(Bukkit.getWorld("TAKESHI_1"), 7, 104, 56);

    public void start(Player player) {
        if (gameStarted) {
            player.sendMessage("The game is already running!");
            return;
        }

        gameStarted = true;
        score = 0;  // Reset score at the start of the game
        Location startLocation = new Location(player.getWorld(), 0, 60, 0);  // Starting location for the bird

        // Spawn bird (armor stand)
        birdArmorStand = (ArmorStand) player.getWorld().spawnEntity(startLocation, EntityType.ARMOR_STAND);
        birdArmorStand.setInvisible(true);
        birdArmorStand.setGravity(false);  // We'll simulate gravity ourselves
        birdArmorStand.setSmall(true);
        birdArmorStand.setInvulnerable(true);

        // Set player's head on the bird
        ItemStack birdHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) birdHead.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(player.getUniqueId()));
        birdHead.setItemMeta(skullMeta);
        birdArmorStand.setHelmet(birdHead);

        // Start gravity, collision detection, and obstacle generation tasks
        new BukkitRunnable() {
            @Override
            public void run() {
                if (gameStarted) {
                    applyGravity();
                    checkCollision(player);
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(Takeshi.instance, 0L, 1L);  // Run every tick

        new BukkitRunnable() {
            @Override
            public void run() {
                if (gameStarted) {
                    generateObstacle(Bukkit.getWorld("TAKESHI_1"));
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(Takeshi.instance, 0L, 100L);  // Run every 5 seconds (100 ticks)
    }

    public void applyGravity() {
        Location currentLocation = birdArmorStand.getLocation();
        Location newLocation = currentLocation.subtract(0, 0.1, 0);  // Move the bird downwards
        birdArmorStand.teleport(newLocation);
    }

    public void checkCollision(Player player) {
        Block blockBelowBird = getBlockBelowPlayer(birdArmorStand);
        if (blockBelowBird.getType() != Material.AIR) {
            player.sendMessage("Collision detected! Game over.");
            showGameOverScreen(player);
            gameStarted = false;
            birdArmorStand.remove();
        } else {
            incrementScore(player);
        }
    }

    public void incrementScore(Player player) {
        score++;
        player.sendMessage("Score: " + score);
    }

    public void showGameOverScreen(Player player) {
        player.sendTitle("Game Over", "Your score: " + score, 10, 70, 20);
    }

    public void generateObstacle(World world) {
        int poleHeight = 20;  // Height of the pole
        int gapSize = 4;  // Size of the gap
        int gapPosition = random.nextInt(poleHeight - gapSize);  // Random position for the gap

        for (int y = 0; y < poleHeight; y++) {
            if (y < gapPosition || y >= gapPosition + gapSize) {
                Location obstacleLocation = new Location(world, 0, y + 20, 0);  // Adjust y position to fit within the world
                world.getBlockAt(obstacleLocation).setType(Material.GREEN_CONCRETE);  // Set the block to an obstacle material
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        //if (getBlockBelowPlayer(player).getLocation().equals(goldBlock)) {
        if (gameStarted) {
            if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR) {
                birdArmorStand.setVelocity(birdArmorStand.getVelocity().setY(0.5));  // Jump
            }
        }
        //}
    }

    public Block getBlockBelowPlayer(Entity entity) {
        Location playerLocation = new Location(entity.getLocation().getWorld(),
                entity.getLocation().getBlockX(), entity.getLocation().getBlockY(), entity.getLocation().getBlockZ());
        Location blockBelowLocation = playerLocation.subtract(0, 1, 0);
        Block blockBelow = blockBelowLocation.getBlock();
        return blockBelow;
    }
}