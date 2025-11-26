package org.example;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class FeatherJump extends JavaPlugin implements Listener {


    //enable
    @Override
    public void onEnable() {
        Bukkit.getLogger().info("FeatherJump has been enabled");
        Bukkit.getPluginManager().registerEvents(this, this);
    }


    //disable
    @Override
    public void onDisable() {
        Bukkit.getLogger().info("FeatherJump has been disabled.");
    }

    //on event
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (!event.getAction().toString().contains("RIGHT_CLICK")) return;

        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand().getType() != Material.FEATHER) return;

        //vector for going upward
        player.setVelocity(new Vector(0, 1.3, 0));

        player.sendMessage("Woooooosh!");
    }
}
