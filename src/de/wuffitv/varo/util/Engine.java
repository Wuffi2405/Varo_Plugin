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
	int smallborder;
	int smallbordertime = MetaData.border_size_lower_time;

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

		final Player a = sender;
		
		i = 21;
		countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

			@Override
			public void run() {

				if (i != 0) {

					if (i - 1 != 0 && i >= 0) {
						if (i <= 0) {
							// Bukkit.getConsoleSender().sendMessage(ChatColor.RED
							// + "i <= 0");
						}
						countdownrunning = true;

						if (i - 1 == 10 || i - 1 == 20 || i - 1 == 15 || i - 1 <= 5) {
							Bukkit.broadcastMessage(ChatColor.GOLD + "" + (i - 1) + "");

							if (i - 1 <= 5) {
								for (Player p : Bukkit.getServer().getOnlinePlayers()) {
									p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 100, 100);
								}
							}

						}
					}
					i--;
				}

				if ((i == 0)) {

					countdownrunning = false;
					Bukkit.broadcastMessage(ChatMessage.PREFIX + "GO!");
					Bukkit.broadcastMessage(ChatMessage.PREFIX + "Das Spiel hat begonnen");
					float starttime = MetaData.border_size_lower_time / 60;
					Bukkit.broadcastMessage("Die Border verkleinert sich in  " + starttime + " Minuten!");

					MetaData.players.clear();

					/**
					 * was mit dem Spieler passiert, wenn es losgeht
					 */
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {

						/* Inventar säubern? */
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 100, 100);
						p.setHealth(20);
						p.setSaturation(20);
						p.setExp(0.0F);
						p.getInventory().clear();
						p.setGameMode(GameMode.SURVIVAL);
						p.getWorld().setDifficulty(Difficulty.HARD);
						p.getWorld().getWorldBorder().setCenter(
								new Location(a.getWorld(), MetaData.spawn_x, MetaData.spawn_y, MetaData.spawn_z));
						MetaData.players_ingame.add(p);
						p.getWorld().getWorldBorder().setSize(MetaData.border_size);
						MetaData.relogable.add(p);

					}

					smallbordertime--;
					smallborder = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

						@Override
						public void run() {

							float norm = smallbordertime / 300;
							float f = smallbordertime / norm;

							if (f == 300) {
								Bukkit.broadcastMessage(
										"Borderverkleinerung in " + smallbordertime / 60 + " Minuten!   ");
							}

							if (smallbordertime <= 4 || smallbordertime == 30 || smallbordertime == 10) {
								Bukkit.broadcastMessage("Borderverkleinerung in " + smallbordertime + " Sekunden!   ");
							}

							smallbordertime--;

							if (smallbordertime == -1) {
								Bukkit.broadcastMessage(ChatMessage.PREFIX + "Border wird verkleinert");
								Bukkit.getScheduler().cancelTask(smallborder);
								a.getWorld().getWorldBorder().setSize(MetaData.border_size_min,
										MetaData.border_size_lower_timeSize);
							}

						}
					}, 20, 20);

					i--;
				}

				if (i == -1) {

					Bukkit.getServer().getScheduler().cancelTask(countdown);

				}

			}
		}, 20L, 20L);
	}

}
