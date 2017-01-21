package de.wuffitv.varo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Engine {

	private int countdown;
	private int i = 11;

	public void startCountdown(Player player) {
		player.sendMessage("You have started the game!");
		player.sendMessage("");

		countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) this, new Runnable() {

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
