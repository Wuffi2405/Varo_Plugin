package de.wuffitv.varo.event;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.wuffitv.varo.util.MetaData;

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
		 */

		if (MetaData.players_ingame.contains(player)) {
			e.setJoinMessage(ChatColor.GREEN + player.getDisplayName() + ChatColor.WHITE + " ist wieder da");
		} else {

			/**
			 * add Player to List
			 */

			e.setJoinMessage(ChatColor.GREEN + player.getDisplayName() + ChatColor.WHITE + " has joined the game");
			if(!MetaData.players.contains(player)){
			MetaData.players.add(player);
			}

			/**
			 * Spieler zum spawn teleportieren
			 */
			player.teleport(new Location(player.getWorld(), MetaData.spawn_x, MetaData.spawn_y, MetaData.spawn_z));
			player.sendMessage("Du wurdest hinzugefügt!");

			/**
			 * survival bei join
			 */
			player.setGameMode(GameMode.SURVIVAL);

		}

	}

}
