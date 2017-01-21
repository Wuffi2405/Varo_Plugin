package de.wuffitv.varo.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
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

		e.setJoinMessage(ChatColor.GREEN + player.getDisplayName() + ChatColor.WHITE + " has joined the game");

		/**
		 * add Player to List
		 */

		MetaData.players.add(player);

		if (!MetaData.players_dummy_online_start.contains(player)) {

			MetaData.players_dummy_online_start.add(player);

		}
		if(MetaData.DEBUG == true){
			player.sendMessage("Du wurdest hinzugefügt!");
		}
		player.teleport(new Location(player.getWorld(), MetaData.spawn_x, MetaData.spawn_y, MetaData.spawn_z));

		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "" + player + "wurde der Liste hinzugefügt");
		// player.sendMessage("Du wurdest hinzugefügt!");

	}

}
