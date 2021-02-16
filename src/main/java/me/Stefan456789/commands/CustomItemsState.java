package me.Stefan456789.commands;

import me.Stefan456789.CustomItems;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class CustomItemsState implements CommandExecutor, TabCompleter {

    private CustomItems main;

    public CustomItemsState(CustomItems main) {
        this.main = main;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender.isOp()) {
            if (args[0].equalsIgnoreCase("ON")) {
                main.state = true;
                return true;
            } else if (args[0].equalsIgnoreCase("OFF")) {
                main.state = false;
                return true;
            }
        } else {
            sender.sendMessage("You do not have permissions to perform this command!");
            return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        List<String> suggestion = new ArrayList<String>();
        String[] guessList = {"ON", "OFF"};

        for(String guess : guessList){
            if (args[0].toLowerCase().startsWith(args[0].toLowerCase())) suggestion.add(guess);
        }
        return suggestion;
    }
}
