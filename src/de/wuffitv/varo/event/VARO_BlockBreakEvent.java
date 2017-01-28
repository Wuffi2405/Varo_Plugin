package de.wuffitv.varo.event;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import de.wuffitv.varo.util.MetaData;

public class VARO_BlockBreakEvent implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		if(MetaData.players.contains(event.getPlayer())){
			/**
			 * Abbauen unterbinden
			 * Nachricht an den Spieler
			 */
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.GOLD + "Du kannst noch keine Blöcke abbauen. \nWarte bis das Event beginnt!");
		}
	}
	
}
