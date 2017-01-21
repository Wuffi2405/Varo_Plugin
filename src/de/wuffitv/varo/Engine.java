package de.wuffitv.varo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Engine {

	
	public static Main plugin;
	
	public Engine(Main plugin){
		this.plugin = plugin;
	}
	
	private int countdown;
	private int i = 11;

	public void startCountdown(Player player) {
		player.sendMessage("You have started the game!");
		player.sendMessage("");

		

		i = 11;
		countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

			@Override
			public void run() {

				
				if (i != 0) {

					if (i - 1 != 0) {
						Bukkit.broadcastMessage(ChatColor.GOLD + "" + (i - 1) + "");
					}

					i--;

				}

				if ((i == 0)) {

					Bukkit.broadcastMessage("GO!");

					for (Player p : Bukkit.getServer().getOnlinePlayers()) {

						p.playSound(p.getLocation(), Sound.LEVEL_UP, 100, 100);
						p.setHealth(20);
						p.setSaturation(20);

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
