package de.wuffitv.varo.team;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import de.wuffitv.varo.util.ChatMessage;
import de.wuffitv.varo.util.MetaData;

public class Teams {

	public Teams() {

	}

	public static void getWinnerOfTheMatch() {
		if (MetaData.players_ingame.size() > 0) {
			/**
			 * Es sind Spieler online
			 */
			int allPlayers = MetaData.players_ingame.size();
			if (allPlayers == 1) {
				String winner = MetaData.players_ingame.get(0).toString();
				Bukkit.getConsoleSender().sendMessage(ChatMessage.PREFIX + ChatColor.AQUA + "Gewonnen hat: " + winner);
			}
		} else {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatMessage.PREFIX + ChatColor.RED + "[Teams] [getWinnerOfTheMatch] no players are marked as ingame");
		}
	}

}
