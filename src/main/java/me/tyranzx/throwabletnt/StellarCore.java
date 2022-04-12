package me.tyranzx.throwabletnt;

import me.tyranzx.throwabletnt.commands.PersonalCommands;
import me.tyranzx.throwabletnt.management.ConfigManager;
import me.tyranzx.throwabletnt.utilities.StellarSource;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class StellarCore extends JavaPlugin {

    public static ConfigManager settings = ConfigManager.getInstance();
    public static StellarCore core;

    @Override
    public void onEnable() {
        core = this;
        this.registerCommands();
        this.registerListeners();
        this.registerConfigFiles();
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(StellarSource.c("&cThrowableTNT &fha sido activado"));
                Bukkit.getConsoleSender().sendMessage(StellarSource.c(" &8| &6Version: &e1.0"));
                Bukkit.getConsoleSender().sendMessage(StellarSource.c(" &8| &6Hecho por: &eTyranzx"));
        Bukkit.getConsoleSender().sendMessage(" ");
    }
    private void registerCommands(){
        this.getCommand("ttnt").setExecutor(new PersonalCommands());
    }
    private void registerListeners(){
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new TNTCore(this), this);
    }
    private void registerConfigFiles(){
        settings.setup(this);
    }
}
