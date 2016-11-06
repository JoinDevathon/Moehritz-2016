package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class MachinePlacer {

    private final Player player;
    private final BukkitRunnable runnable;

    private boolean placed;

    public MachinePlacer(Player player) {
        this.player = player;

        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                updateAnimation();
            }
        };
        runnable.runTaskTimer(DevathonPlugin.getInstance(), 1L, 2L);

    }

    private void updateAnimation() {
        Block playerBlock = player.getLocation().getBlock();
        float playerDirection = player.getLocation().getYaw() + 180;

        // The direction the machine will be facing, based on the player orientation
        BlockFace machineFacing;
        player.sendMessage(String.valueOf(playerDirection));
        if (Math.abs(playerDirection) < 45) {
            machineFacing = BlockFace.SOUTH;
        } else if (Math.abs(playerDirection) > 135) {
            machineFacing = BlockFace.NORTH;
        } else if (playerDirection > 0) {
            machineFacing = BlockFace.WEST;
        } else {
            machineFacing = BlockFace.EAST;
        }

        // Base block of the machine, one block in front of the player; (width/2) to the left
        Block frontDownLeft = playerBlock.getRelative(machineFacing.getOppositeFace()).getRelative(Utils.rotateRight(machineFacing), TempStatics.width / 2);

        Material target = placed ? Material.AIR : Material.OBSIDIAN;

        // Blocks for testing (tmp)
        Block frontDownRight = frontDownLeft.getRelative(Utils.rotateLeft(machineFacing), TempStatics.width);
        Block frontUpLeft = frontDownLeft.getRelative(BlockFace.UP, TempStatics.height);
        Block frontUpRight = frontDownRight.getRelative(BlockFace.UP, TempStatics.height);

        Block backDownLeft = frontDownLeft.getRelative(machineFacing.getOppositeFace(), TempStatics.depth);
        Block backDownRight = frontDownRight.getRelative(machineFacing.getOppositeFace(), TempStatics.depth);
        Block backUpLeft = frontUpLeft.getRelative(machineFacing.getOppositeFace(), TempStatics.depth);
        Block backUpRight = frontUpRight.getRelative(machineFacing.getOppositeFace(), TempStatics.depth);

        World world = player.getWorld();
        world.spawnParticle(Particle.HEART, backDownLeft.getLocation(), 1);
        world.spawnParticle(Particle.HEART, backDownRight.getLocation(), 1);
        world.spawnParticle(Particle.HEART, backUpLeft.getLocation(), 1);
        world.spawnParticle(Particle.HEART, backUpRight.getLocation(), 1);
        world.spawnParticle(Particle.HEART, frontUpLeft.getLocation(), 1);
        world.spawnParticle(Particle.HEART, frontUpRight.getLocation(), 1);
        world.spawnParticle(Particle.HEART, frontDownLeft.getLocation(), 1);
        world.spawnParticle(Particle.HEART, frontDownRight.getLocation(), 1);

        player.sendMessage(machineFacing.name());
    }


}
