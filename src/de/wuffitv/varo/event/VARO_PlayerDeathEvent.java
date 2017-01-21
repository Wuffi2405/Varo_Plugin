package de.wuffitv.varo.event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

import de.wuffitv.varo.MetaData;

public class VARO_PlayerDeathEvent implements Listener {

	public static Plugin plugin;

	@SuppressWarnings("static-access")
	public VARO_PlayerDeathEvent(Plugin plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerDeath(PlayerDeathEvent event) {

		/**
		 * Vermeidung des Todes
		 * 
		 */

		if (MetaData.players.contains(event.getEntity().getPlayer())) {

			event.getEntity().getPlayer().setHealth(20);
			event.getEntity().getPlayer().setFoodLevel(20);
			event.setKeepInventory(true);
			event.setDeathMessage(null);
		} else {

			if (event.getEntity().getKiller() instanceof Player) {
				/**
				 * init Vaiables
				 */
				String killer = (String) event.getEntity().getKiller().getName();
				Player player = (Player) event.getEntity().getPlayer();

				/**
				 * create DeathMessage set Chatmessage
				 */
				String msg = org.bukkit.ChatColor.RED + player.getDisplayName() + ChatColor.WHITE + " wurde von "
						+ ChatColor.GREEN + killer + ChatColor.WHITE + " getötet";
				event.setDeathMessage(msg);

				/**
				 * Player heilen --> stirbt sonst beim nächsten joinene Player
				 * wird gekickt Player wird gebannt
				 */
				player.setHealth(20);
				player.kickPlayer("Du bist gestorben durch " + killer);
				player.setBanned(true);
			} else {
				/**
				 * init Variables
				 */
				Player player = (Player) event.getEntity().getPlayer();

				/**
				 * create DeathMessage
				 */
				String deathMessage = event.getDeathMessage().replace(player.getDisplayName(), "");
				event.setDeathMessage(ChatColor.RED + " " + player.getDisplayName() + ChatColor.WHITE + deathMessage);

				/**
				 * Player heilen --> stirbt sonst beim nächsten joinen Player
				 * wird gekickt Player wird gebannt
				 */
				player.setHealth(20);
				player.kickPlayer("Du bist gestorben");
				player.setBanned(true);
			}

		}

	}

}
