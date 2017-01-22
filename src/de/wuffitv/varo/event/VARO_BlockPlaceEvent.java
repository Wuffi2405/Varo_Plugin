package de.wuffitv.varo.event;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import de.wuffitv.varo.MetaData;

public class VARO_BlockPlaceEvent implements Listener{
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		if(MetaData.players.contains(event.getPlayer())){
			/**
			 * Plazieren unterbinden
			 * Nachricht an den Spieler
			 */
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.GOLD + "Du kannst noch keine Blöcke setzen.\nWarte bis das Event beginnt!");
		}
	}
	
}
