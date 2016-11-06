package org.devathon.contest2016;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlaceMachineListener implements Listener {

    @EventHandler
    public void playerLogin(PlayerLoginEvent event) {
        new MachinePlacer(event.getPlayer());
    }

}
