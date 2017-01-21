package de.wuffitv.varo.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;

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
		player.setHealth(10);
		player.kickPlayer("Du bist gestorben und getötet durch " + killer);
		player.setBanned(true);

		String msg = ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " wurde von " + ChatColor.YELLOW + killer + ChatColor.WHITE + " getötet";
		
//		event.getDeathMessage();
		event.setDeathMessage(msg);
		
//		for (Player p : Bukkit.getOnlinePlayers()) {
//
//			p.sendMessage("" + msg);
//
//		}

	}

}
