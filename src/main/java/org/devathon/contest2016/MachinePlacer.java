package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class MachinePlacer {

    private final Player player;
    private final BukkitRunnable runnable;

    public MachinePlacer(Player player) {
        this.player = player;

        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                updateAnimation();
            }
        };
        runnable.runTaskTimer(DevathonPlugin.getInstance(), 1L, 5L);

    }

    private void updateAnimation() {
        Block playerBlock = player.getLocation().getBlock();
        Vector playerDirection = player.getLocation().getDirection();

        BlockFace machineDirection;
        if (playerDirection.getX() >= 0) {
            if (playerDirection.getZ() >= 0) {

            }
        }
    }
}
