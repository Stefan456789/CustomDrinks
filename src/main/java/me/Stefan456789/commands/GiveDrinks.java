package me.Stefan456789.commands;

import me.Stefan456789.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GiveDrinks implements CommandExecutor, TabCompleter, Listener {


    public String[] drinkList = {"Margarita", "Mai Tai", "White_Russian", "Caipirinha", "Screwdriver", "Bloody Mary", "Whisky Sour", "Old Fashioned", "Manhatten", "Martini", "Daiquiri", "Cosmopoutan", "Singapore Sling", "Mojito", "Mint Julep", "Tom Collins", "Pina Colada", "Sea Breeze", "Cuba Libre", "Bellini"};


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        String[] drinks = drinkList;
        ItemStack item = new ItemStack(Material.POTION);
        if ((args.length >= 2 || args.length <= 3) && sender.getServer().getPlayer(args[0]).isOnline()) {
            for (int x = 0; x < drinks.length; x++) {
                if (args.length == 2) if (!drinks[x].equals(args[1])) continue;
                if (args.length == 3) if (!drinks[x].equals(args[1] + " " + args[2])) continue;

                PotionMeta pmeta = (PotionMeta) item.getItemMeta();
                pmeta.setDisplayName(ChatColor.DARK_PURPLE + drinks[x]);
                pmeta.setColor(Color.fromRGB(255,255,255));
                pmeta.setCustomModelData(x+1);
                pmeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                item.setItemMeta(pmeta);
                sender.getServer().getPlayer(args[0]).getInventory().addItem(item);

                return true;
            }



        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        String[] drinks = drinkList;
        List<String> suggestion = new ArrayList<String>();

        if (args.length == 1) {
            OfflinePlayer[] ofPlayers = sender.getServer().getOfflinePlayers();
            for (int x = 0; x < ofPlayers.length; x++) {
                if(ofPlayers[x].isOnline()) {
                    String guess = ofPlayers[x].getName();
                    if (guess.toLowerCase().startsWith(args[0].toLowerCase()))
                        suggestion.add(guess);
                }
            }

        }

        if (args.length == 2) {
            for (String guess : drinks) {
                if (guess.toLowerCase().startsWith(args[1].toLowerCase()))
                    suggestion.add(guess);
            }

        }

        return suggestion;


    }
}
