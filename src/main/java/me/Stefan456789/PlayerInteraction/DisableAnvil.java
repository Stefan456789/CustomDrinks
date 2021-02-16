package me.Stefan456789.PlayerInteraction;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import java.util.Objects;

public class DisableAnvil implements Listener {
    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        if (event.getInventory().getType() == InventoryType.ANVIL) {
            if (event.getSlotType() == InventoryType.SlotType.RESULT) {
                if (Objects.requireNonNull(Objects.requireNonNull(event.getInventory().getItem(0)).getItemMeta()).getCustomModelData() != 0) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
