package de.wuffitv.varo.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

import de.wuffitv.varo.util.MetaData;

public class VARO_PlayerLeaveEvent {
	
	@EventHandler
	public void onLeave(PlayerQuitEvent event){
		Player player = event.getPlayer();
		
		if(MetaData.players.contains(player)){
			MetaData.players.remove(player);
		}
		if(MetaData.players_bereit.contains(player)){
			MetaData.players_bereit.remove(player);
		}
//		if(MetaData.players_ingame.contains(player)){
//			MetaData.players_ingame.remove(player);
//		}
		if(MetaData.players_online.contains(player)){
			MetaData.players_ingame.remove(player);
		}
	}
	
}
