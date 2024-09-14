package de.silvan.parkour;

import de.silvan.players.Players;
import de.silvan.takeshi.Takeshi;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.type.Slab;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Player1Module1 {

    public static Location block1 = new Location(Bukkit.getWorld("TAKESHI_1"), 3, 102, 4);
    public static Location block2 = new Location(Bukkit.getWorld("TAKESHI_1"), 3, 102, 5);
    public static Location block3 = new Location(Bukkit.getWorld("TAKESHI_1"), 3, 102, 6);
    public static Location block4 = new Location(Bukkit.getWorld("TAKESHI_1"), 2, 102, 6);
    public static Location block5 = new Location(Bukkit.getWorld("TAKESHI_1"), 1, 102, 6);
    public static Location block6 = new Location(Bukkit.getWorld("TAKESHI_1"), 0, 102, 7);
    public static Location block7 = new Location(Bukkit.getWorld("TAKESHI_1"), 0, 102, 8);
    public static Location block8 = new Location(Bukkit.getWorld("TAKESHI_1"), 0, 102, 9);
    public static Location block9 = new Location(Bukkit.getWorld("TAKESHI_1"), 1, 102, 9);
    public static Location block10 = new Location(Bukkit.getWorld("TAKESHI_1"), 2, 102, 9);
    public static Location block11 = new Location(Bukkit.getWorld("TAKESHI_1"), 3, 102, 9);
    public static Location block12 = new Location(Bukkit.getWorld("TAKESHI_1"), 4, 102, 9);
    public static Location block13 = new Location(Bukkit.getWorld("TAKESHI_1"), 4, 102, 8);
    public static Location block14 = new Location(Bukkit.getWorld("TAKESHI_1"), 5, 102, 8);
    public static Location block15 = new Location(Bukkit.getWorld("TAKESHI_1"), 6, 102, 8);
    public static Location block16 = new Location(Bukkit.getWorld("TAKESHI_1"), 6, 102, 9);
    public static Location block17 = new Location(Bukkit.getWorld("TAKESHI_1"), 6, 102, 10);
    public static Location block18 = new Location(Bukkit.getWorld("TAKESHI_1"), 6, 102, 11);
    public static Location block19 = new Location(Bukkit.getWorld("TAKESHI_1"), 5, 102, 11);
    public static Location block20 = new Location(Bukkit.getWorld("TAKESHI_1"), 5, 102, 12);
    public static Location block21 = new Location(Bukkit.getWorld("TAKESHI_1"), 4, 102, 12);
    public static Location block22 = new Location(Bukkit.getWorld("TAKESHI_1"), 3, 102, 12);
    public static Location block23 = new Location(Bukkit.getWorld("TAKESHI_1"), 2, 102, 12);
    public static Location block24 = new Location(Bukkit.getWorld("TAKESHI_1"), 1, 102, 12);
    public static Location block25 = new Location(Bukkit.getWorld("TAKESHI_1"), 1, 102, 13);
    public static Location block26 = new Location(Bukkit.getWorld("TAKESHI_1"), 1, 102, 14);
    public static Location block27 = new Location(Bukkit.getWorld("TAKESHI_1"), 2, 102, 14);
    public static Location block28 = new Location(Bukkit.getWorld("TAKESHI_1"), 3, 102, 14);
    public static Location block29 = new Location(Bukkit.getWorld("TAKESHI_1"), 3, 102, 15);
    public static Location block30 = new Location(Bukkit.getWorld("TAKESHI_1"), 3, 102, 16);
    public static Location block31 = new Location(Bukkit.getWorld("TAKESHI_1"), 2, 102, 16);
    public static Location block32 = new Location(Bukkit.getWorld("TAKESHI_1"), 2, 102, 17);
    public static Location block33 = new Location(Bukkit.getWorld("TAKESHI_1"), 2, 102, 18);
    public static Location block34 = new Location(Bukkit.getWorld("TAKESHI_1"), 3, 102, 18);
    public static Location block35 = new Location(Bukkit.getWorld("TAKESHI_1"), 4, 102, 18);
    public static Location block36 = new Location(Bukkit.getWorld("TAKESHI_1"), 5, 102, 18);
    public static Location block37 = new Location(Bukkit.getWorld("TAKESHI_1"), 5, 103, 17); // Stair
    public static Location block38 = new Location(Bukkit.getWorld("TAKESHI_1"), 5, 104, 16); // Stair
    public static Location block39 = new Location(Bukkit.getWorld("TAKESHI_1"), 5, 104, 15);
    public static Location block40 = new Location(Bukkit.getWorld("TAKESHI_1"), 4, 104, 15); // Slab (high)
    public static Location block41 = new Location(Bukkit.getWorld("TAKESHI_1"), 3, 104, 15); // Slab (high)
    public static Location block42 = new Location(Bukkit.getWorld("TAKESHI_1"), 2, 105, 15); // Slab (low)
    public static Location block43 = new Location(Bukkit.getWorld("TAKESHI_1"), 1, 105, 15); // Slab (low)
    public static Location block44 = new Location(Bukkit.getWorld("TAKESHI_1"), 1, 105, 16); // Stair
    public static Location block45 = new Location(Bukkit.getWorld("TAKESHI_1"), 1, 106, 17); // Stair
    public static Location block46 = new Location(Bukkit.getWorld("TAKESHI_1"), 1, 107, 18); // Stair
    public static Location block47 = new Location(Bukkit.getWorld("TAKESHI_1"), 1, 107, 19);

    public static void start(Player player) {
        final int[] progress = {0};
        new BukkitRunnable() {
            @Override
            public void run() {
                if ((player.getLocation().getZ() >= 4) && (player.getLocation().getZ() <= 21)) {
                    String message = "§4RUN!";
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));

                    if (getBlockBelowPlayer(player).getType() == Material.RED_CONCRETE ||
                            getBlockBelowPlayer(player).getType() == Material.PURPUR_STAIRS ||
                            getBlockBelowPlayer(player).getType() == Material.PURPUR_SLAB) {
                        reset();
                        if (player == Players.getPlayer(0)) {
                            player.teleport(new Location(Bukkit.getWorld("TAKESHI_1"), 3.5, 103, 1.5));
                        }
                        if (player == Players.getPlayer(1)) {
                            player.teleport(new Location(Bukkit.getWorld("TAKESHI_1"), 3.5, 103, 1.5));
                        }
                    }
                    if (progress[0] < 48) {
                        progress[0] = progress[0] + 1;
                        nextBlock();
                    }
                } else reset();
            }
        }.runTaskTimer(Takeshi.instance, 4, 4);
    }
    public static Block getBlockBelowPlayer(Player player) {
        Location playerLocation = new Location(player.getLocation().getWorld(),
                player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
        Location blockBelowLocation = playerLocation.subtract(0, 1, 0);
        Block blockBelow = blockBelowLocation.getBlock();
        return blockBelow;
    }
    public static void reset() {
        block1.getBlock().setType(Material.SMOOTH_QUARTZ);
        block2.getBlock().setType(Material.SMOOTH_QUARTZ);
        block3.getBlock().setType(Material.SMOOTH_QUARTZ);
        block4.getBlock().setType(Material.SMOOTH_QUARTZ);
        block5.getBlock().setType(Material.SMOOTH_QUARTZ);
        block6.getBlock().setType(Material.SMOOTH_QUARTZ);
        block7.getBlock().setType(Material.SMOOTH_QUARTZ);
        block8.getBlock().setType(Material.SMOOTH_QUARTZ);
        block9.getBlock().setType(Material.SMOOTH_QUARTZ);
        block10.getBlock().setType(Material.SMOOTH_QUARTZ);
        block11.getBlock().setType(Material.SMOOTH_QUARTZ);
        block12.getBlock().setType(Material.SMOOTH_QUARTZ);
        block13.getBlock().setType(Material.SMOOTH_QUARTZ);
        block14.getBlock().setType(Material.SMOOTH_QUARTZ);
        block15.getBlock().setType(Material.SMOOTH_QUARTZ);
        block16.getBlock().setType(Material.SMOOTH_QUARTZ);
        block17.getBlock().setType(Material.SMOOTH_QUARTZ);
        block18.getBlock().setType(Material.SMOOTH_QUARTZ);
        block19.getBlock().setType(Material.SMOOTH_QUARTZ);
        block20.getBlock().setType(Material.SMOOTH_QUARTZ);
        block21.getBlock().setType(Material.SMOOTH_QUARTZ);
        block22.getBlock().setType(Material.SMOOTH_QUARTZ);
        block23.getBlock().setType(Material.SMOOTH_QUARTZ);
        block24.getBlock().setType(Material.SMOOTH_QUARTZ);
        block25.getBlock().setType(Material.SMOOTH_QUARTZ);
        block26.getBlock().setType(Material.SMOOTH_QUARTZ);
        block27.getBlock().setType(Material.SMOOTH_QUARTZ);
        block28.getBlock().setType(Material.SMOOTH_QUARTZ);
        block29.getBlock().setType(Material.SMOOTH_QUARTZ);
        block30.getBlock().setType(Material.SMOOTH_QUARTZ);
        block31.getBlock().setType(Material.SMOOTH_QUARTZ);
        block32.getBlock().setType(Material.SMOOTH_QUARTZ);
        block33.getBlock().setType(Material.SMOOTH_QUARTZ);
        block34.getBlock().setType(Material.SMOOTH_QUARTZ);
        block35.getBlock().setType(Material.SMOOTH_QUARTZ);
        block36.getBlock().setType(Material.SMOOTH_QUARTZ);

        block37.getBlock().setType(Material.SMOOTH_QUARTZ_STAIRS);
        setStair(block37, BlockFace.NORTH);
        block38.getBlock().setType(Material.SMOOTH_QUARTZ_STAIRS);
        setStair(block38, BlockFace.NORTH);

        block39.getBlock().setType(Material.SMOOTH_QUARTZ);

        setSlab(block40, true, Material.SMOOTH_QUARTZ_SLAB);
        setSlab(block41, true, Material.SMOOTH_QUARTZ_SLAB);
        setSlab(block42, false, Material.SMOOTH_QUARTZ_SLAB);
        setSlab(block43, false, Material.SMOOTH_QUARTZ_SLAB);

        block44.getBlock().setType(Material.SMOOTH_QUARTZ_STAIRS);
        setStair(block44, BlockFace.SOUTH);
        block45.getBlock().setType(Material.SMOOTH_QUARTZ_STAIRS);
        setStair(block45, BlockFace.SOUTH);
        block46.getBlock().setType(Material.SMOOTH_QUARTZ_STAIRS);
        setStair(block46, BlockFace.SOUTH);
        block47.getBlock().setType(Material.SMOOTH_QUARTZ);

    }
    public static void nextBlock() {
        if (block1.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block1.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block2.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block2.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block3.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block3.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block4.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block4.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block5.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block5.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block6.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block6.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block7.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block7.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block8.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block8.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block9.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block9.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block10.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block10.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block11.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block11.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block12.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block12.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block13.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block13.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block14.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block14.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block15.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block15.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block16.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block16.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block17.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block17.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block18.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block18.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block19.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block19.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block20.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block20.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block21.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block21.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block22.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block22.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block23.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block23.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block24.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block24.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block25.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block25.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block26.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block26.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block27.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block27.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block28.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block28.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block29.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block29.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block30.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block30.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block31.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block31.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block32.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block32.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block33.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block33.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block34.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block34.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block35.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block35.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block36.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block36.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block37.getBlock().getType() == Material.SMOOTH_QUARTZ_STAIRS) {
            block37.getBlock().setType(Material.PURPUR_STAIRS);
            setStair(block37, BlockFace.NORTH);
            return;
        }
        if (block38.getBlock().getType() == Material.SMOOTH_QUARTZ_STAIRS) {
            block38.getBlock().setType(Material.PURPUR_STAIRS);
            setStair(block38, BlockFace.NORTH);
            return;
        }
        if (block39.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block39.getBlock().setType(Material.RED_CONCRETE);
            return;
        }
        if (block40.getBlock().getType() == Material.SMOOTH_QUARTZ_SLAB) {
            setSlab(block40, true, Material.PURPUR_SLAB);
            return;
        }
        if (block41.getBlock().getType() == Material.SMOOTH_QUARTZ_SLAB) {
            setSlab(block41, true, Material.PURPUR_SLAB);
            return;
        }
        if (block42.getBlock().getType() == Material.SMOOTH_QUARTZ_SLAB) {
            setSlab(block42, false, Material.PURPUR_SLAB);
            return;
        }
        if (block43.getBlock().getType() == Material.SMOOTH_QUARTZ_SLAB) {
            setSlab(block43, false, Material.PURPUR_SLAB);
            return;
        }
        if (block44.getBlock().getType() == Material.SMOOTH_QUARTZ_STAIRS) {
            block44.getBlock().setType(Material.PURPUR_STAIRS);
            setStair(block44, BlockFace.SOUTH);
            return;
        }
        if (block45.getBlock().getType() == Material.SMOOTH_QUARTZ_STAIRS) {
            block45.getBlock().setType(Material.PURPUR_STAIRS);
            setStair(block45, BlockFace.SOUTH);
            return;
        }
        if (block46.getBlock().getType() == Material.SMOOTH_QUARTZ_STAIRS) {
            block46.getBlock().setType(Material.PURPUR_STAIRS);
            setStair(block46, BlockFace.SOUTH);
            return;
        }
        if (block47.getBlock().getType() == Material.SMOOTH_QUARTZ) {
            block47.getBlock().setType(Material.RED_CONCRETE);
        }
    }
    public static void setSlab(Location location, boolean isTop, Material material) {
        Block block = location.getBlock();
        block.setType(material);
        Slab slabData = (Slab) block.getBlockData();
        if (isTop) {
            slabData.setType(Slab.Type.TOP);
        } else {
            slabData.setType(Slab.Type.BOTTOM);
        }
        block.setBlockData(slabData);
    }
    public static void setStair(Location loc, BlockFace facing) {
        if(loc.getBlock().getBlockData() instanceof Directional) {
            Directional dir = (Directional)loc.getBlock().getBlockData();
            dir.setFacing(facing);
            loc.getBlock().setBlockData(dir);
        }
    }
}
