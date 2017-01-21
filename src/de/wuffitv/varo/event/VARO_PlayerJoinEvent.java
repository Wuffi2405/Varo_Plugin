package de.wuffitv.varo.event;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class VARO_PlayerJoinEvent implements Listener {

	public static Plugin plugin;
	public static List<Player> players;

	@SuppressWarnings("static-access")
	public VARO_PlayerJoinEvent(Plugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerDeath(PlayerJoinEvent e) {

		Player p = e.getPlayer();

		
		
		if (!players.contains(p)) {
			players.add(p);
		}

	}

}
