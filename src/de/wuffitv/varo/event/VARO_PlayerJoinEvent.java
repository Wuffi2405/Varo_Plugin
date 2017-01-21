package de.wuffitv.varo.event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.wuffitv.varo.MetaData;

public class VARO_PlayerJoinEvent implements Listener {

	/**
	 * Wenn der Spieler joint
	 */
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		/**
		 * init Variables
		 */
		Player player = e.getPlayer();

		/**
		 * create Join Message
		 * 
		 */

		e.setJoinMessage(ChatColor.RED + player.getDisplayName() + ChatColor.WHITE + " has joined the game");

		/**
		 * lists
		 */
		if(!MetaData.players.contains(player)){
		MetaData.players.add(player);

		}
	}

}
