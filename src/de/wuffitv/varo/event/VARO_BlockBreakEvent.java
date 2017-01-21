package de.wuffitv.varo.event;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import de.wuffitv.varo.MetaData;

public class VARO_BlockBreakEvent implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		if(MetaData.players.contains(event.getPlayer())){
			/**
			 * Abbauen unterbinden
			 * Nachricht an den Spieler
			 */
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.GOLD + "Du kannst noch keine Blöcke abbauen. \n Warte bis das Event beginnt!");
		}
	}
	
}
