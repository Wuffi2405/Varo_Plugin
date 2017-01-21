package de.wuffitv.varo.event;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

public class VARO_PlayerDeathEvent implements Listener {
	
	public static Plugin plugin;
	
	@SuppressWarnings("static-access")
	public VARO_PlayerDeathEvent(Plugin plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event){
		//ggg
		String killer = (String)event.getEntity().getKiller().getName();
		Player player = (Player)event.getEntity().getPlayer();
//		player.kickPlayer("Du bist gestorben und getötet durch " + killer);
		String msg = "Du wurdest von "+killer+"getötet. \n Du bist somit aus dem Projekt ausgeschlossen.";
		Bukkit.getBanList(Type.IP).addBan(player.getUniqueId().toString(), ""+msg, null, player.getUniqueId().toString());

	}
	
}
