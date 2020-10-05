package me.thyraxx;

import org.bukkit.Tag;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class AutoSwitchForCorrectBlock extends JavaPlugin {


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new OnBlockDamageEventListener(), this);

        System.out.println("SAND: " + Tag.SAND.getValues());
    }


    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "AutoSwitchForCorrectBlock Disabled");
    }
}
