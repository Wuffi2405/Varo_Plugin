package de.wuffitv.varo;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatMessage {
	
	public static final String PREFIX = ChatColor.DARK_GREEN+"["+ChatColor.GOLD+"VARO"+ChatColor.DARK_GREEN+"] "+ChatColor.WHITE;
	
	public static String VARO_PlayerDeathEvent_DieByNatur(Player player, String defaultMessage){
		return ChatColor.RED + "" + player.getDisplayName() + ChatColor.WHITE + (defaultMessage.replace(player.getDisplayName(), ""));
	}
	
	public static String VARO_PlayerDeathEvent_DieByPlayer(Player player, String killer){
		return ChatColor.RED + player.getDisplayName() + ChatColor.WHITE + " wurde von " + ChatColor.GREEN + killer + ChatColor.WHITE + " getötet";
	}
	
	public static String VARO_Player_allBereit(){
		return PREFIX + ChatColor.GOLD + "Alle Spieler sind bereit!";
	}
	
	public static String VARO_Player_allBereitAndStarting(){
		return PREFIX + ChatColor.GOLD + "Alle sind bereit und das Spiel wird gestartet!";
	}
	
	public static String VARO_Player_google(){
		return ChatColor.BLUE+"G"+ChatColor.RED+"o"+ChatColor.YELLOW+"o"+ChatColor.BLUE+"g"+ChatColor.GREEN+"l"+ChatColor.RED+"e"+ChatColor.WHITE;
	}
	
}