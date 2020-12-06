package org.china2b2t.elytralimiter;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class ElytraMain extends JavaPlugin implements Listener{
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable(){
		// onDisable invoked!
    }
	
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if(event.getPlayer().isGliding()) {
            Vector x = event.getTo().toVector();
            Vector y = event.getFrom().toVector();

            Vector z = x.subtract(y);
            if((Math.abs(z.getX()) > 1 || Math.abs(z.getZ()) > 1) && z.getY() == 0) {
                event.setCancelled(true);
            }
        }
    }
}
