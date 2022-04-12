package me.tyranzx.throwabletnt.commands;

import me.tyranzx.throwabletnt.StellarCore;
import me.tyranzx.throwabletnt.utilities.StellarSource;
import me.tyranzx.throwabletnt.management.ItemsManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PersonalCommands extends StellarSource implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arg) {
        int args = arg.length;
        if (!(sender instanceof Player)) {
            sender.sendMessage(c("&cSolo jugadores tienen acceso a este comando."));
            return true;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("throwabletnt.pcommands")){
            p.sendMessage(c("&4&l● &cNo tienes permiso para este comando."));
            return true;
        }
        if (command.getName().equalsIgnoreCase("ttnt")){
            if (args == 0){
                ItemsManager.darTNTItem(p);
                p.sendMessage(c("&a&l● &f¡Has obtenido una &c&lTNT &farrojable!"));
                return true;
            }
            if (arg[0].equalsIgnoreCase("reload")){
                if (args == 1){
                    StellarCore.settings.reloadConfig();
                    p.sendMessage(c("&e&l● &fLa configuración ha sido &amodificada &fe &aimportada &fcorrectamente."));
                    return true;
                }
            }
        }
        return false;
    }
}
