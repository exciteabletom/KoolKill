package com.tomdougiamas.koolkill;

import com.destroystokyo.paper.Title;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class KoolKillHandlers implements Listener {
    KoolKill plugin;
    public KoolKillHandlers(KoolKill p) {
        plugin = p;
    }
    @EventHandler
    public void onPlayerKill(EntityDamageByEntityEvent e) {
        if (!plugin.enabled) return;
        // Make sure both entities are players
        if (e.getEntityType() != EntityType.PLAYER || e.getDamager().getType() != EntityType.PLAYER)
            return;

        Player victim = (Player) e.getEntity();
        Player attacker = (Player) e.getDamager();
        if (victim.getHealth() - e.getFinalDamage() <= 0.0) {
            attacker.playSound(attacker.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 2F, 0.0F);
            Title message = new Title("§4You slaughtered %s!".formatted(victim.getName()), null, 10, 30, 10);
            message.send(attacker);
            for (int i = 0; i < 4; i++) {
                victim.getWorld().strikeLightningEffect(victim.getLocation());
            }
            attacker.playSound(attacker.getLocation(), Sound.AMBIENT_CAVE, 2F, 0.0F);
        }
    }
}
