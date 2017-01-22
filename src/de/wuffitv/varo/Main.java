package de.wuffitv.varo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import de.wuffitv.varo.event.VARO_BlockBreakEvent;
import de.wuffitv.varo.event.VARO_BlockPlaceEvent;
import de.wuffitv.varo.event.VARO_PlayerDeathEvent;
import de.wuffitv.varo.event.VARO_PlayerJoinEvent;

public class Main extends JavaPlugin implements Listener {

	Engine engine;
	public static int bereit;
	public static int nichtbereit;

	@Override
	public void onEnable() {
		super.onEnable();

		new Config();

		Bukkit.getConsoleSender().sendMessage("[VARO] was enabled");
		/**
		 * Load Engines
		 */
		engine = new Engine(this);

		/**
		 * register Events
		 */

		this.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(new VARO_PlayerDeathEvent(this), this);
		Bukkit.getPluginManager().registerEvents(new VARO_PlayerJoinEvent(), this);
		Bukkit.getPluginManager().registerEvents(new VARO_BlockBreakEvent(), this);
		Bukkit.getPluginManager().registerEvents(new VARO_BlockPlaceEvent(), this);

		saveDefaultConfig();

	}

	@Override
	public void onDisable() {
		super.onDisable();
		Bukkit.getConsoleSender().sendMessage("[VARO] was disabled");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		/**
		 * google Befehl
		 */
		if (label.equalsIgnoreCase("google")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				player.sendMessage(ChatColor.BLUE + "G" + ChatColor.RED + "o" + ChatColor.YELLOW + "o" + ChatColor.BLUE
						+ "g" + ChatColor.GREEN + "l" + ChatColor.RED + "e" + ChatColor.WHITE);
				return true;
			}
		}

		/**
		 * start Event
		 */
		if (label.equalsIgnoreCase("start")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;

				if ((MetaData.players_dummy_online_start.size() == 0)) {

					engine.startCountdown(player);

				}
				return true;
			}
		}

		/**
		 * sich selbst aus der Liste entfernen
		 */
		if (label.equalsIgnoreCase("remove")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (player.isOp()) {
					MetaData.players.remove(player);
					player.sendMessage("Entfernt");
				}
				return true;
			}
		}

		/**
		 * BITTE VERVOLLSTÄNDIGEN
		 */
		if (label.equalsIgnoreCase("refresh")) {
			if (sender instanceof Player) {

				for (Player p : Bukkit.getOnlinePlayers()) {

					if (!MetaData.players_bereit.contains(p)) {

						MetaData.players_dummy_online_start.add(p);
						p.sendMessage("Du wurdest zu nicht bereit hinzugefügt!");

					} else {
						p.sendMessage("keine Änderungen wurden vorgenommen!");
					}

					if (!MetaData.players_online.contains(p)) {

						MetaData.players_online.add(p);
						p.sendMessage("Du wurdest zu Online hinzugefügt!");

					} else {
						p.sendMessage("keine Änderungen wurden vorgenommen!");
					}

					if (!MetaData.players.contains(p)) {

						MetaData.players.add(p);
						p.sendMessage("Du wurdest zu startfähig hinzugefügt!");

					} else {
						p.sendMessage("keine Änderungen wurden vorgenommen!");
					}

				}

				return true;
			}
		}

		/**
		 * Die bereit-Funktion Der Countdown geht erst los, wenn alle Spieler
		 * bereit sind
		 */
		if (label.equalsIgnoreCase("bereit")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;

				if (Engine.countdownrunning == 0) {

					if (!MetaData.players_bereit.contains(player) && MetaData.players.contains(player)) {
						MetaData.players_bereit.add(player);

						for (Player p : Bukkit.getOnlinePlayers()) {

							if (MetaData.players_bereit.contains(p)) {

								MetaData.players_dummy_online_start.remove(p);

								bereit = MetaData.players_bereit.size();
								nichtbereit = MetaData.players_online.size();

							}

						}

						Bukkit.broadcastMessage(player.getDisplayName() + " ist bereit!                      " + bereit
								+ "/" + nichtbereit);

						if ((MetaData.players_online.size() == (MetaData.players_bereit.size()))) {

							Bukkit.broadcastMessage(
									ChatColor.DARK_PURPLE + "Alle sind bereit und das Spiel wird gestartet!");
							engine.startCountdown(player);

						}

					} else

					if (MetaData.players_bereit.contains(player) && MetaData.players.contains(player)) {
						MetaData.players_bereit.remove(player);

						int bereit = MetaData.players_bereit.size();
						int nichtbereit = MetaData.players_online.size();

						Bukkit.broadcastMessage(player.getDisplayName() + " ist nicht bereit!               " + bereit
								+ "/" + nichtbereit);
					} else

					if (!MetaData.players.contains(player)) {

						player.sendMessage("Du bist leider nicht startfähig /refresh");

					}

				} else if (Engine.countdownrunning == 1) {

					player.sendMessage("Der countdown läuft bereits");

				}

				return true;
			}
		}

		return super.onCommand(sender, command, label, args);
	}

}