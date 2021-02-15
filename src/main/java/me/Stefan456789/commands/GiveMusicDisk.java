package me.Stefan456789.commands;

import me.Stefan456789.CustomItems;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GiveMusicDisk implements CommandExecutor, TabCompleter {

    private CustomItems main;

    public GiveMusicDisk(CustomItems main) {
        this.main = main;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        ItemStack item = new ItemStack(Material.MUSIC_DISC_11);

        for (int x = 0; x < main.diskList.length; x++) {
            String nameGuess = args[0];

            for (int z = 1; z < args.length; z++) {
                nameGuess = nameGuess + " " + args[z];
            }

            if (!main.diskList[x].equals(nameGuess)) continue;

            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.DARK_PURPLE + main.diskList[x]);
            meta.setCustomModelData(x + 1);
            item.setItemMeta(meta);


            sender.getServer().getPlayer(sender.getName()).getInventory().addItem(item);

            return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {

        List<String> suggestion = new ArrayList<String>();


        for (String guess : main.diskList) {
            if (guess.toLowerCase().startsWith(args[0].toLowerCase()))
                suggestion.add(guess);
        }


        return suggestion;


    }
}

