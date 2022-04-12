package me.tyranzx.throwabletnt.management;

import me.tyranzx.throwabletnt.StellarCore;
import me.tyranzx.throwabletnt.utilities.StellarSource;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager extends StellarSource {

    private ConfigManager () { }
    static ConfigManager instance = new ConfigManager();
    public static ConfigManager getInstance(){
        return instance;
    }
    public File cfile;
    public FileConfiguration config;

    public void setup(StellarCore core){
        cfile = new File(core.getDataFolder(), "config.yml");
        config = core.getConfig();
        config.options().copyDefaults(true);
        saveConfig();
    }
    public void saveConfig(){
        try{
            config.save(cfile);
        }catch (IOException ex){
            ex.printStackTrace();
        } finally {
            Bukkit.getConsoleSender().sendMessage(c("&aArchivos de configuracion (config.yml) ha sido guardado."));
        }
    }
    public void reloadConfig(){
        config = YamlConfiguration.loadConfiguration(cfile);
    }
}
