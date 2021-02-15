package me.Stefan456789.PlayerInteraction;

import me.Stefan456789.CustomItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class DrinkEffects implements Listener {

    private CustomItems main;
    public DrinkEffects(CustomItems main){
        this.main = main;
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void playerItemConsumeEvent(PlayerItemConsumeEvent e) {
        if(e.getItem().getType().equals(Material.POTION) && e.getItem().getItemMeta().getCustomModelData() != 0){
            Player player = e.getPlayer();
            if((int) (Math.random()*10) == 1) {
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 1,(float) (Math.random()*2+0.5));
            }
            if((int) (Math.random()*10) == 1) {
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT, 1,(float) (Math.random()*2+0.5));
            }
            if((int) (Math.random()*5) == 1) {
                player.addPotionEffect(PotionEffectType.POISON.createEffect(20,1),true);
            }
            if((int) (Math.random()*5) == 1) {
                player.addPotionEffect(PotionEffectType.CONFUSION.createEffect(140,255),true);
            }

            Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(main, new Runnable() {
                public void run() {
                    if (player.getInventory().contains(Material.GLASS_BOTTLE)){
                        player.setItemInHand(new ItemStack(Material.AIR));
                    }
                }
            }, 1L);

        }
    }
}
