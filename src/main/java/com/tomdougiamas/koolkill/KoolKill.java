package com.tomdougiamas.koolkill;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class KoolKill extends JavaPlugin {
    public boolean enabled = true;

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("koolkill")).setExecutor(new ToggleExecutor(this));
        getServer().getPluginManager().registerEvents(new KoolKillHandlers(this), this);
    }
}
