package de.wuffitv.varo;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatMessage {
	
	public static String VARO_PlayerDeathEvent_DieByNatur(Player player, String defaultMessage){
		return ChatColor.RED + " " + player.getDisplayName() + ChatColor.WHITE + (defaultMessage.replace(player.getDisplayName(), ""));
	}
	
	public static String VARO_PlayerDeathEvent_DieByPlayer(Player player, String killer){
		return ChatColor.RED + player.getDisplayName() + ChatColor.WHITE + " wurde von " + ChatColor.GREEN + killer + ChatColor.WHITE + " getötet";
	}
}
