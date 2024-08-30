package de.silvan.commands;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.silvan.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.UUID;

public class WarpCommand implements CommandExecutor {

    public Inventory warpInv = Bukkit.createInventory(null, 6 * 9, "Warp Inventory");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (s.equals("world") || s.equals("welt")) {
                if (args.length == 1) {
                    switch (args[0]) {
                        case "LOBBY":
                            player.teleport(new Location(Bukkit.getWorld("LOBBY"), 0, 100, 0));
                            return true;
                        case "TAKESHI_1":
                            player.teleport(new Location(Bukkit.getWorld("TAKESHI_1"), 0, 100, 0));
                            return true;
                        default:
                            sender.sendMessage(ChatColor.RED + "/world <server>");
                            return true;
                    }
                }
            }

            if (player.isOp()) {
                fillOutEdgeAndRest();

                String worldTexture = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDM4Y2YzZjhlNTRhZmMzYjNmOTFkMjBhNDlmMzI0ZGNhMTQ4NjAwN2ZlNTQ1Mzk5MDU1NTI0YzE3OTQxZjRkYyJ9fX0=";

                warpInv.setItem(10, createSkull(worldTexture, ChatColor.GREEN + "Lobby", ChatColor.GRAY + "Click to teleport to lobby", "warplobby"));
                warpInv.setItem(11, createSkull(worldTexture, ChatColor.GREEN + "Takeshi Map 1", ChatColor.GRAY + "Click to teleport to Takeshi Map 1", "warptakeshi1"));
                player.openInventory(warpInv);
            }
            return true;
        }
        return false;
    }
    public ItemStack createSkull(String headTexture, String name, String lore, String localizedName) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
        if (headTexture.isEmpty()) return head;

        SkullMeta meta = (SkullMeta) head.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Collections.singletonList(lore));
        meta.setLocalizedName(localizedName);
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        profile.getProperties().put("textures", new Property("textures", headTexture));

        try {
            Field field = meta.getClass().getDeclaredField("profile");
            field.setAccessible(true);
            field.set(meta, profile);
        } catch (IllegalArgumentException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        head.setItemMeta(meta);
        return head;
    }


    private void fillOutEdgeAndRest() {
        ItemStack grayStainedGlassPane = new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE, 1).setDisplayname(" ").build();
        ItemStack whiteStainedGlassPane = new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE, 1).setDisplayname(" ").build();

        for (int i = 0; i < warpInv.getSize(); i++) {
            warpInv.setItem(i, whiteStainedGlassPane);
        }

        warpInv.setItem(0, grayStainedGlassPane);
        warpInv.setItem(1, grayStainedGlassPane);
        warpInv.setItem(2, grayStainedGlassPane);
        warpInv.setItem(3, grayStainedGlassPane);
        warpInv.setItem(4, grayStainedGlassPane);
        warpInv.setItem(5, grayStainedGlassPane);
        warpInv.setItem(6, grayStainedGlassPane);
        warpInv.setItem(7, grayStainedGlassPane);
        warpInv.setItem(8, grayStainedGlassPane);
        warpInv.setItem(9, grayStainedGlassPane);
        warpInv.setItem(18, grayStainedGlassPane);
        warpInv.setItem(27, grayStainedGlassPane);
        warpInv.setItem(36, grayStainedGlassPane);
        warpInv.setItem(17, grayStainedGlassPane);
        warpInv.setItem(26, grayStainedGlassPane);
        warpInv.setItem(35, grayStainedGlassPane);
        warpInv.setItem(44, grayStainedGlassPane);
        warpInv.setItem(45, grayStainedGlassPane);
        warpInv.setItem(46, grayStainedGlassPane);
        warpInv.setItem(47, grayStainedGlassPane);
        warpInv.setItem(48, grayStainedGlassPane);
        warpInv.setItem(49, grayStainedGlassPane);
        warpInv.setItem(50, grayStainedGlassPane);
        warpInv.setItem(51, grayStainedGlassPane);
        warpInv.setItem(52, grayStainedGlassPane);
        warpInv.setItem(53, grayStainedGlassPane);
    }
}
