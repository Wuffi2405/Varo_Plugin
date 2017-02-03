package de.wuffitv.varo.event;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import de.wuffitv.varo.util.MetaData;

public class VARO_BlockPlaceEvent implements Listener{
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
//		if(MetaData.players_ingame.contains(event.getPlayer())){
//			//
//		}else if(!MetaData.players_ingame.contains(event.getPlayer())){
//			event.setCancelled(true);
//			event.getPlayer().sendMessage(ChatColor.GOLD + "Du kannst noch keine Blöcke setzen.\nWarte bis das Event beginnt!");
//		}
		
		if(MetaData.players.contains(event.getPlayer())){
			/**
			 * Plazieren unterbinden
			 * Nachricht an den Spieler
			 */
			if(!MetaData.players_ingame.contains(event.getPlayer())){
				event.setCancelled(true);
				event.getPlayer().sendMessage(ChatColor.GOLD + "Du kannst noch keine Blöcke setzen.\nWarte bis das Event beginnt!");
			}
		}
	}
	
}
