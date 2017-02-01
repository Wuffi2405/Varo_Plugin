package de.wuffitv.varo.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

import de.wuffitv.varo.util.ChatMessage;
import de.wuffitv.varo.util.MetaData;

public class VARO_PlayerDeathEvent implements Listener {

	public static Plugin plugin;

	@SuppressWarnings("static-access")
	public VARO_PlayerDeathEvent(Plugin plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {

		/**
		 * Vermeidung des Todes
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
				 * set Chatmessage
				 */
				event.setDeathMessage(ChatMessage.VARO_PlayerDeathEvent_DieByPlayer(player, killer));
				
				if(MetaData.players.contains(player)){
					MetaData.players.remove(player);
				}
				if(MetaData.players_bereit.contains(player)){
					MetaData.players_bereit.remove(player);
				}
				if(MetaData.players_ingame.contains(player)){
					MetaData.players_ingame.remove(player);
				}
				if(MetaData.players_online.contains(player)){
					MetaData.players_ingame.remove(player);
				}
				
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
				 * set DeathMessage
				 */
				event.setDeathMessage(ChatMessage.VARO_PlayerDeathEvent_DieByNatur(player, event.getDeathMessage()));
				
				if(MetaData.players.contains(player)){
					MetaData.players.remove(player);
				}
				if(MetaData.players_bereit.contains(player)){
					MetaData.players_bereit.remove(player);
				}
				if(MetaData.players_ingame.contains(player)){
					MetaData.players_ingame.remove(player);
				}
				if(MetaData.players_online.contains(player)){
					MetaData.players_ingame.remove(player);
				}
				
				/**
				 * Player heilen --> stirbt sonst beim nächsten joinen Player
				 * wird gekickt Player wird gebannt
				 */
				player.setHealth(20);
				player.kickPlayer("Du bist gestorben");
				player.setBanned(true);
			}

		}
		
		/**
		 * Gewinner anzeigen Funktion
		 */
//		if(Bukkit.getServer().getOnlinePlayers().size() == 2){
////			if(Teams.playersHaveSameTeam() == true){
////				
////			}
//		}
	}

}
