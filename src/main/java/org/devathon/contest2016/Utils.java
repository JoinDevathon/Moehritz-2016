package org.devathon.contest2016;

import org.bukkit.block.BlockFace;

public class Utils {

    public static BlockFace rotateLeft(BlockFace face) {
        switch (face) {
            case NORTH:
                return BlockFace.WEST;
            case EAST:
                return BlockFace.SOUTH;
            case SOUTH:
                return BlockFace.EAST;
            case WEST:
                return BlockFace.NORTH;
            default:
                return face;
        }
    }

    public static BlockFace rotateRight(BlockFace face) {
        return rotateLeft(face).getOppositeFace();
    }

}
