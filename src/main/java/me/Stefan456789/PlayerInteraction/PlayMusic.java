package me.Stefan456789.PlayerInteraction;

import me.Stefan456789.CustomItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Jukebox;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class PlayMusic implements Listener {

    private CustomItems main;

    public PlayMusic(CustomItems main) {
        this.main = main;
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void playerInteractEvent(PlayerInteractEvent e) {
        if ((e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) && e.getClickedBlock().getBlockData().getMaterial().equals(Material.JUKEBOX)) {
            Jukebox jukebox = (Jukebox) e.getClickedBlock().getState();

            if (jukebox.isPlaying() && jukebox.getRecord().getItemMeta().getCustomModelData() != 0) {
                e.getPlayer().sendMessage("execute as " + e.getPlayer().getName() + " at " + e.getPlayer().getName() + " run stopsound @a[distance=..64] record minecraft:music_disc." + jukebox.getRecord().getItemMeta().getCustomModelData());
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "execute as " + e.getPlayer().getName() + " at " + e.getPlayer().getName() + " run stopsound @a[distance=..64] record minecraft:music_disc." + jukebox.getRecord().getItemMeta().getCustomModelData());

            }
            if (!jukebox.isPlaying() && e.getPlayer().getItemInHand().getItemMeta().getCustomModelData() != 0 && e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                String cmd2 = "execute as " + e.getPlayer().getName() + " at " + e.getPlayer().getName() + " run playsound minecraft:music_disc." + e.getPlayer().getItemInHand().getItemMeta().getCustomModelData() + " record @a[distance=..64]";
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), cmd2);


                String cmd1 = "execute as " + e.getPlayer().getName() + " at " + e.getPlayer().getName() + " run stopsound @a[distance=..64] record minecraft:music_disc.11";

                e.getPlayer().getServer().getScheduler().runTask(main, new Runnable() {
                    @Override
                    public void run() {
                        e.getPlayer().getServer().dispatchCommand(e.getPlayer().getServer().getConsoleSender(), cmd1);
                    }
                });

            }
        }
    }
}

