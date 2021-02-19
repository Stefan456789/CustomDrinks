package me.Stefan456789.PlayerInteraction;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import java.util.Objects;

public class DisableAnvil implements Listener {
    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent e) {
        if (e.getInventory().getType() == InventoryType.ANVIL) {
            if (e.getSlotType() == InventoryType.SlotType.RESULT  && e.getInventory().getItem(0).hasItemMeta() && e.getInventory().getItem(0).getItemMeta().hasCustomModelData()) {
                if (e.getInventory().getItem(0).getItemMeta().getCustomModelData() != 0) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
