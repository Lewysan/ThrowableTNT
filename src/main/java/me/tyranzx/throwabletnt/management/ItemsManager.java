package me.tyranzx.throwabletnt.management;

import me.tyranzx.throwabletnt.utilities.StellarSource;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemsManager extends StellarSource {

    public static void darTNTItem(Player p){
        ItemStack tnt = new ItemStack(Material.TNT, 1);
        ItemMeta meta = tnt.getItemMeta();
        meta.setDisplayName(c("&cTNT Arrojable"));
        List<String> lore = new ArrayList<>();
        lore.add(c("&7Click derecho para"));
        lore.add(c("&7arrojar la tnt."));
        meta.setLore(lore);
        tnt.setItemMeta(meta);

        p.getInventory().addItem(tnt);
    }
}
