package me.Stefan456789;

import me.Stefan456789.PlayerInteraction.DisableAnvil;
import me.Stefan456789.PlayerInteraction.DrinkEffects;
import me.Stefan456789.PlayerInteraction.PlayMusic;
import me.Stefan456789.commands.CustomItemsState;
import me.Stefan456789.commands.GiveDrinks;
import me.Stefan456789.commands.GiveMusicDisk;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class CustomItems extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        getServer().getConsoleSender().sendMessage("[CustomItems] plugin loaded!");

        GiveDrinks dHandler = new GiveDrinks(this);

        getCommand("drink").setExecutor(dHandler);
        getCommand("drink").setTabCompleter(dHandler);

        GiveMusicDisk diskHandler = new GiveMusicDisk(this);

        getCommand("disc").setExecutor(diskHandler);
        getCommand("disc").setTabCompleter(diskHandler);

        CustomItemsState stateHandler = new CustomItemsState(this);

        getCommand("customItemsState").setExecutor(stateHandler);
        getCommand("customItemsState").setTabCompleter(stateHandler);

        Bukkit.getServer().getPluginManager().registerEvents(new DisableAnvil(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new DrinkEffects(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayMusic(this), this);
    }

    public String[] drinkList = {"Margarita", "Mai Tai", "White_Russian", "Caipirinha", "Screwdriver", "Bloody Mary", "Whisky Sour", "Old Fashioned", "Manhatten", "Martini", "Daiquiri", "Cosmopoutan", "Singapore Sling", "Mojito", "Mint Julep", "Tom Collins", "Pina Colada", "Sea Breeze", "Cuba Libre", "Bellini"};
    public String[] diskList = {"Jack Wins feat. Caitlyn_Scarlett - Animals Extended Mix", "For U 2 Original Mix", "Kaskade Chemical Surf POW POW POW", "David Guetta Martin Garrix Brooks - Like I Do", "Lucky Luke - F.E.E.L", "Crisis Era - If U Like feat. SLVR", "Electric Mantis - Daybreak Majestic Color", "Martin Garrix feat. Mike Yung - Dreamer Brooks Remix", "Travis_Scott HVME - Goosebumps Remix - Official Audio"};
    public boolean state = true;
}
