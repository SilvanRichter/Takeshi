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

public class FlappyBird implements Listener {

    private boolean gameStarted;
    private ArmorStand birdArmorStand;
    private int score = 0;
    Location goldBlock = new Location(Bukkit.getWorld("TAKESHI_1"), 7, 104, 56);

    public void start(Player player) {
        if (gameStarted) {
            player.sendMessage("The game is already running!");
            return;
        }
        Bukkit.broadcastMessage("Starting!");
        gameStarted = true;

        score = 0;  // Reset score at the start of the game
        Location startLocation = new Location(player.getWorld(), 18, 108, 52);  // Starting location for the bird

        // Spawn bird (armor stand)
        birdArmorStand = (ArmorStand) player.getWorld().spawnEntity(startLocation, EntityType.ARMOR_STAND);
        birdArmorStand.setInvisible(true);
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
                    String message = "§4Flappy $bBird$9!";
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                    checkCollision(player);
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(Takeshi.instance, 0L, 1L);  // Run every tick
    }

    public void checkCollision(Player player) {
        Block blockBelowBird = getBlockBelow(birdArmorStand);
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
        // 30 Sekunden → 60 x 30 = 1800
        if (score >= 1800) {
            gameStarted = false;
            showGameOverScreen(player);
            Bukkit.broadcastMessage("You won!");
        }
    }

    public void showGameOverScreen(Player player) {
        player.sendTitle("Game Over", "Your score: " + score, 10, 70, 20);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (getBlockBelow(player).getLocation().equals(goldBlock)) {
            if (gameStarted) {
                if (event.getAction() == Action.LEFT_CLICK_AIR) {
                    birdArmorStand.setVelocity(new Vector(0, 0.6, 0));  // Jump
                }
            }
        }
    }

    public Block getBlockBelow(Entity entity) {
        Location playerLocation = new Location(entity.getLocation().getWorld(),
                entity.getLocation().getBlockX(), entity.getLocation().getBlockY(), entity.getLocation().getBlockZ());
        Location blockBelowLocation = playerLocation.subtract(0, 1, 0);
        Block blockBelow = blockBelowLocation.getBlock();
        return blockBelow;
    }
}