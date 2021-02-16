package me.Stefan456789.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import me.Stefan456789.CustomItems;

import java.util.ArrayList;
import java.util.List;

public class GiveDrinks implements CommandExecutor, TabCompleter, Listener {

    private CustomItems main;

    public GiveDrinks(CustomItems customItems) {
        this.main = customItems;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (main.state) {
            if ((args.length == 1 || args.length == 2)) {
                ItemStack item = new ItemStack(Material.POTION);
                for (int x = 0; x < main.drinkList.length; x++) {
                    if (args.length == 1) if (!main.drinkList[x].equals(args[0])) continue;
                    if (args.length == 2) if (!main.drinkList[x].equals(args[0] + " " + args[1])) continue;

                    PotionMeta pmeta = (PotionMeta) item.getItemMeta();
                    pmeta.setDisplayName(ChatColor.DARK_PURPLE + main.drinkList[x]);
                    pmeta.setColor(Color.fromRGB(255, 255, 255));
                    pmeta.setCustomModelData(x + 1);
                    pmeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                    item.setItemMeta(pmeta);
                    sender.getServer().getPlayer(sender.getName()).getInventory().addItem(item);

                    return true;
                }
                sender.sendMessage("This drink does not exist!");
            }
            return false;
        }
        sender.sendMessage("This command is currently disabled, contact an Admin!");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {

        List<String> suggestion = new ArrayList<String>();
        if (args.length <= 2) {
            for (String guess : main.drinkList) {
                if (guess.toLowerCase().startsWith(args[0].toLowerCase()))
                    suggestion.add(guess);
            }
        }


        return suggestion;


    }
}
