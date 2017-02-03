package de.wuffitv.varo.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import de.wuffitv.varo.Main;

public class Engine {

	public static Main plugin;
	
	/**
	 * ob der countdown läuft
	 */
	
	public static boolean countdownrunning = false;
	
	
	@SuppressWarnings("static-access")
	public Engine(Main plugin) {
		this.plugin = plugin;
	}

	private int countdown;
	@SuppressWarnings("unused")
	private int border;
	private int i = 11;

	public void startCountdown(Player sender) {

		i = 11;
		countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

			@Override
			public void run() {
				
				if (i != 0) {

					if (i - 1 != 0 && i >= 0) {
						if(i <= 0){
//							Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "i <= 0");
						}
						countdownrunning = true;
						Bukkit.broadcastMessage(ChatColor.GOLD + "" + (i - 1) + "");
						
					}
					i--;
				}

				if ((i == 0)) {

					countdownrunning = false;
					Bukkit.broadcastMessage(ChatMessage.PREFIX + "GO!");
					Bukkit.broadcastMessage(ChatMessage.PREFIX + "Das Spiel hat begonnen");
					Bukkit.broadcastMessage("Die Border verkleinert sich in  " + MetaData.border_size_lower_time + " Sekunden!");
					
					
					
					
					
					
					MetaData.players.clear();
					
					/**
					 * was mit dem Spieler passiert, wenn es losgeht
					 */
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						
						/* Inventar säubern? */
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 100, 100);
						p.setHealth(20);
						p.setSaturation(20);
						p.getInventory().clear();
						p.setGameMode(GameMode.SURVIVAL);
						p.getWorld().setDifficulty(Difficulty.HARD);
						p.getWorld().getWorldBorder().setCenter(new Location(sender.getWorld(), MetaData.spawn_x, MetaData.spawn_y, MetaData.spawn_z));
						MetaData.players_ingame.add(p);
						
						
						
					}
					i--;
				}

				if (i == -1) {

					Bukkit.getServer().getScheduler().cancelTask(countdown);
					
				}

			
			
			}
		}, 20L, 20L);
	} 
	
}
