package me.Stefan456789;

import me.Stefan456789.PlayerInteraction.DisableAnvil;
import me.Stefan456789.commands.GiveDrinks;
import me.Stefan456789.PlayerInteraction.DisableAnvil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        getServer().getConsoleSender().sendMessage("[Stefan] plugin loaded!!!");
        GiveDrinks dHandler = new GiveDrinks();


        getCommand("drink").setExecutor(dHandler);
        getCommand("drink").setTabCompleter(dHandler);
        Bukkit.getServer().getPluginManager().registerEvents(new DisableAnvil(), this);
    }

}
