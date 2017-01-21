package de.wuffitv.varo.event;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

public class VARO_BlockBreakEvent implements Listener {

	public static Plugin plugin;
	
	@SuppressWarnings("static-access")
	public VARO_BlockBreakEvent(Plugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerDeath(BlockBreakEvent e) {

		Player p = e.getPlayer();
		
		if(VARO_PlayerJoinEvent.players.contains(p)){
			
			e.setCancelled(true);
			
		}

		
		

	}

}
