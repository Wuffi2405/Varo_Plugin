package de.wuffitv.varo.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

public class VARO_PlayerDeathEvent implements Listener {

	public static Plugin plugin;

	@SuppressWarnings("static-access")
	public VARO_PlayerDeathEvent(Plugin plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {

		String killer = (String) event.getEntity().getKiller().getName();
		Player player = (Player) event.getEntity().getPlayer();
		player.kickPlayer("Du bist gestorben und get�tet durch " + killer);
		player.setBanned(true);

		String msg = "" + player.getDisplayName() + "wurde von " + killer + " get�tet";

		for (Player p : Bukkit.getOnlinePlayers()) {

			p.sendMessage("" + msg);

		}

	}

}