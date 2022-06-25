package com.tomdougiamas.koolkill;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ToggleExecutor implements CommandExecutor {
    KoolKill plugin;
    public ToggleExecutor(KoolKill p) {
        this.plugin = p;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) return false;

        switch (args[0]) {
            case "off" -> {
                plugin.enabled = false;
                sender.sendPlainMessage("KoolKill Disabled");
                return true;
            }
            case "on" -> {
                plugin.enabled = true;
                sender.sendPlainMessage("KoolKill Enabled");
                return true;
            }
        }

        return false;
    }
}
