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
import de.wuffitv.varo.team.Teams;
import de.wuffitv.varo.util.ChatMessage;
import de.wuffitv.varo.util.Config;
import de.wuffitv.varo.util.Engine;
import de.wuffitv.varo.util.MetaData;

public class Main extends JavaPlugin implements Listener {

	Engine engine;
	Teams team;
	public static int bereit;
	public static int nichtbereit;

	@Override
	public void onEnable() {
		super.onEnable();

		/**
		 * pre-load
		 */
		MetaData.PLUGIN_VERSION = Bukkit.getServer().getPluginManager().getPlugin("Varo_Plugin").getDescription()
				.getVersion();
		Bukkit.getConsoleSender().sendMessage(ChatMessage.PREFIX + " was enabled");
		Bukkit.getConsoleSender().sendMessage(ChatMessage.PREFIX + " version: " + MetaData.PLUGIN_VERSION);
		/**
		 * Load Engines
		 */
		new Config();
		engine = new Engine(this);
		team = new Teams();

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
				player.sendMessage(ChatMessage.VARO_Player_google());
				return true;
			}
		}

		/**
		 * start Event
		 */
		if (label.equalsIgnoreCase("start")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;

				engine.startCountdown(player);

				return true;
			}
		}

		/**
		 * DEBUG sich selbst aus der Liste entfernen
		 */
		if (label.equalsIgnoreCase("remove")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (player.isOp()) {
					MetaData.players.remove(player);
					player.sendMessage("[DEBUG] Entfernt");
				}
				return true;
			}
		}

		/**
		 * DEBUG startbereit machen
		 */
		if (label.equalsIgnoreCase("refresh")) {
			if (sender instanceof Player) {

				for (Player p : Bukkit.getOnlinePlayers()) {

					if (!MetaData.players_bereit.contains(p)) {

						MetaData.players_dummy_online_start.add(p);
						p.sendMessage("[DEBUG] Du wurdest zu nicht bereit hinzugefügt!");

					} else {
						p.sendMessage("[DEBUG] keine Änderungen wurden vorgenommen!");
					}

					if (!MetaData.players_online.contains(p)) {

						MetaData.players_online.add(p);
						p.sendMessage("[DEBUG] Du wurdest zu Online hinzugefügt!");

					} else {
						p.sendMessage("[DEBUG] keine Änderungen wurden vorgenommen!");
					}

					if (!MetaData.players.contains(p)) {

						MetaData.players.add(p);
						p.sendMessage("[DEBUG] Du wurdest zu startfähig hinzugefügt!");

					} else {
						p.sendMessage("[DEBUG] keine Änderungen wurden vorgenommen!");
					}

				}

				return true;
			}
		}

		if (label.equalsIgnoreCase("online")) {
			if(sender instanceof Player){
				sender.sendMessage(ChatColor.AQUA+"get online players" + Bukkit.getServer().getOnlinePlayers());
				sender.sendMessage(ChatColor.AQUA+"get ingame players: " + MetaData.players_ingame.size());
				Teams.getWinnerOfTheMatch();
				return true;
			}else{
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA+"" + Bukkit.getServer().getOnlinePlayers());
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA+"get ingame players: " + MetaData.players_ingame.size());
				Teams.getWinnerOfTheMatch();
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

				if (Engine.countdownrunning == false) {

					/**
					 * Spieler wird in beide Listen hinzugefügt
					 */
					if (!MetaData.players_bereit.contains(player) && MetaData.players.contains(player)) {
						MetaData.players_bereit.add(player);

						/**
						 * geht alle Spieler ab, die online sind
						 */
						for (Player p : Bukkit.getOnlinePlayers()) {

							if (MetaData.players_bereit.contains(p)) {

								MetaData.players_dummy_online_start.remove(p);

								int bereit = MetaData.players_bereit.size();
								int nichtbereit = MetaData.players_online.size();

								Bukkit.broadcastMessage(player.getDisplayName() + " ist bereit!                      "
										+ bereit + "/" + nichtbereit);

								if ((MetaData.players_online.size() == (MetaData.players_bereit.size()))) {

									Bukkit.broadcastMessage(ChatMessage.VARO_Player_allBereit());
									engine.startCountdown(player);

								}

								bereit = MetaData.players_bereit.size();
								nichtbereit = MetaData.players_online.size();

							}

						}

						Bukkit.broadcastMessage(player.getDisplayName() + " ist bereit!                      "
								+ (bereit + 1) + "/" + (nichtbereit + 1));

						if ((MetaData.players_online.size() == (MetaData.players_bereit.size()))) {

							Bukkit.broadcastMessage(ChatMessage.VARO_Player_allBereitAndStarting());
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

						player.sendMessage("[---DEBUG-?---]Du bist leider nicht startfähig /refresh");

					}

				} else if (Engine.countdownrunning == true) {

					player.sendMessage("Der countdown läuft bereits");

				}

				return true;
			}
		}

		return super.onCommand(sender, command, label, args);
	}

}