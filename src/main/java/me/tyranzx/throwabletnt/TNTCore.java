package me.tyranzx.throwabletnt;

import me.tyranzx.throwabletnt.utilities.StellarSource;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class TNTCore extends StellarSource implements Listener {

    protected final StellarCore core;

    public TNTCore(StellarCore core) {
        this.core = core;
    }

    @EventHandler
    public void clickearTNT(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            if (e.getPlayer().getInventory().getItemInHand().getType().equals(Material.TNT)) {
                if (e.getPlayer().getInventory().getItemInHand().getItemMeta().getDisplayName().equals(c("&cTNT Arrojable"))) {
                    FallingBlock tnt = e.getPlayer().getWorld().spawnFallingBlock(e.getPlayer().getLocation(), Material.TNT, (byte) 0);
                    tnt.setDropItem(StellarCore.settings.config.getBoolean("TNT.dropear-item"));
                    tnt.setVelocity(e.getPlayer().getLocation().getDirection().multiply(StellarCore.settings.config.getInt("TNT.multiplicador")));
                    ttnt.add(tnt);
                    e.getPlayer().getInventory().remove(e.getPlayer().getInventory().getItemInHand());
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onFallTNT(EntityChangeBlockEvent e) {
        if (e.getEntity() instanceof FallingBlock) {
            if (ttnt.contains(e.getEntity())) {
                e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), Float.parseFloat(StellarCore.settings.config.getString("TNT.power")), StellarCore.settings.config.getBoolean("TNT.fuego"));
                e.setCancelled(true);
                e.getEntity().remove();
                ttnt.remove(e.getEntity());
            }
        }
    }
}
