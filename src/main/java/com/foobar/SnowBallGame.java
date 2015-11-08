package com.foobar;

import org.bukkit.plugin.java.JavaPlugin;
import com.foobar.GameListener;

public class SnowBallGame extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new GameListener(), this);
    }

    @Override
    public void onDisable() {

    }
}
