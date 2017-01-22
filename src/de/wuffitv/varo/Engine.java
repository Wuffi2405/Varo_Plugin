package de.wuffitv.varo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Engine {

	public static Main plugin;
	
	/**
	 * ob der countdown läuft
	 */
	
	public static int countdownrunning = 0;
	
	
	@SuppressWarnings("static-access")
	public Engine(Main plugin) {
		this.plugin = plugin;
	}

	private int countdown;
	private int i = 11;

	public void startCountdown(Player sender) {

		i = 11;
		countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

			@Override
			public void run() {

				if (i != 0) {

					if (i - 1 != 0) {
						countdownrunning = 1;
						Bukkit.broadcastMessage(ChatColor.GOLD + "" + (i - 1) + "");
					}

					i--;

				}

				if ((i == 0)) {

					countdownrunning = 0;
					Bukkit.broadcastMessage("GO!");
					MetaData.players.clear();

					for (Player p : Bukkit.getServer().getOnlinePlayers()) {

						p.playSound(p.getLocation(), Sound.LEVEL_UP, 100, 100);
						p.setHealth(20);
						p.setSaturation(20);
						p.setGameMode(GameMode.SURVIVAL);
						p.getWorld().setDifficulty(Difficulty.HARD);
						p.teleport(new Location(sender.getWorld(), MetaData.spawn_x, MetaData.spawn_y, MetaData.spawn_z));

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
