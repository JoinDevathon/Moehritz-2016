package org.devathon.contest2016;

import org.bukkit.plugin.java.JavaPlugin;

public class DevathonPlugin extends JavaPlugin {

    private static DevathonPlugin instance;

    @Override
    public void onEnable() {
        getLogger().info("Loading my fantastic machine!");

        instance = this;
    }

    @Override
    public void onDisable() {

    }

    public static DevathonPlugin getInstance() {
        return instance;
    }
}

