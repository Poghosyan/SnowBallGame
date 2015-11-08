package com.foobar;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class GameListener implements Listener {
    @EventHandler
    public void joinSpawn(PlayerJoinEvent e) {
        Player player           = e.getPlayer();
        World world             = player.getWorld();
        Location spawnLocation  = new Location(world, -783, 72, 44);
        world.setSpawnLocation(-783, 72, 44);
        player.getInventory().clear();
        Material snowball = Material.SNOW_BALL;
        ItemStack snowballs = new ItemStack(snowball, 50);
        player.getInventory().addItem(snowballs);
        player.teleport(player.getWorld().getSpawnLocation());
    }

    @EventHandler
    public void respawn(PlayerRespawnEvent e) {
        //System.out.print("PLAYER RESPAWN");
        Player player           = e.getPlayer();
        World world             = player.getWorld();
        Location spawnLocation  = new Location(world, -783, 72, 44);
        player.teleport(spawnLocation);
    }

    @EventHandler
    public void damage(EntityDamageByEntityEvent e) {
        if(e.getEntityType() == EntityType.PLAYER) {
            Player player = (Player) e.getEntity();
            player.damage(20);
        }
    }

    @EventHandler
    public void barrier(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        World world             = player.getWorld();
        Location spawnLocation  = new Location(world, -783, 72, 44);
        if(player.getLocation().distance(spawnLocation) > 20) {
            player.teleport(player.getLocation().add(-2, 0, -2));
        }
    }
}
