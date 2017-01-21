package de.wuffitv.varo.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
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
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerDeath(PlayerDeathEvent event) {
		
		if(event.getEntity().getKiller() instanceof Player){
			String killer = (String) event.getEntity().getKiller().getName();
			Player player = (Player) event.getEntity().getPlayer();
			
			String msg = ChatColor.RED + player.getDisplayName() + ChatColor.WHITE + " wurde von " + ChatColor.GREEN + killer + ChatColor.WHITE + " getötet";
			event.setDeathMessage(msg);
			
			if(event.getDeathMessage().contains("fell from a high place") || event.getDeathMessage().contains("hit the ground to")){
				event.setDeathMessage(ChatColor.DARK_GRAY + "" + event.getEntity() + ChatColor.GRAY + " fell a very long distance");
			}
			
			
			player.setHealth(20);
			player.kickPlayer("Du bist gestorben und getötet durch " + killer);
			player.setBanned(true);
		}else {
			Player player = (Player) event.getEntity().getPlayer();
			
			event.setDeathMessage(ChatColor.RED + " " + player + ChatColor.WHITE + event.getDeathMessage());
			
			player.setHealth(20);
			player.kickPlayer("Du bist gestorben und getötet durch ");
		}
		

	}

}
