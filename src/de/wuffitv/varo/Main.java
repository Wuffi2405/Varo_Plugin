package de.wuffitv.varo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import de.wuffitv.varo.event.VARO_BlockBreakEvent;
import de.wuffitv.varo.event.VARO_BlockPlaceEvent;
import de.wuffitv.varo.event.VARO_PlayerDeathEvent;
import de.wuffitv.varo.event.VARO_PlayerJoinEvent;
import de.wuffitv.varo.event.VARO_PlayerLeaveEvent;
import de.wuffitv.varo.util.ChatMessage;
import de.wuffitv.varo.util.Config;
import de.wuffitv.varo.util.Engine;
import de.wuffitv.varo.util.MetaData;

public class Main extends JavaPlugin implements Listener {

	Engine engine;

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
		Bukkit.getConsoleSender().sendMessage(ChatMessage.PREFIX + " DebuggingModus:" + MetaData.DEBUG);
		/**
		 * Load Engines
		 */
		new Config();
		engine = new Engine(this);

		/**
		 * register Events
		 */

		this.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(new VARO_PlayerDeathEvent(this), this);
		Bukkit.getPluginManager().registerEvents(new VARO_PlayerJoinEvent(), this);
		Bukkit.getPluginManager().registerEvents(new VARO_BlockBreakEvent(), this);
		Bukkit.getPluginManager().registerEvents(new VARO_BlockPlaceEvent(), this);
		Bukkit.getPluginManager().registerEvents(new VARO_PlayerLeaveEvent(), this);

		saveDefaultConfig();

	}

	@Override
	public void onDisable() {
		super.onDisable();
		Bukkit.getConsoleSender().sendMessage("[VARO] was disabled");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender.isOp()) {

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
			
			if (label.equalsIgnoreCase("varo")) {
				if (sender instanceof ConsoleCommandSender) {
					if(args.length == 1){
						
						Player target = Bukkit.getPlayer(args[0]);
						MetaData.players_ingame.add(target);
						MetaData.players.remove(target);
						Bukkit.getConsoleSender().sendMessage(target.getCustomName() + " ist nun ingame!");
						
						if(args[0] == "all"){
							for(Player p : Bukkit.getServer().getOnlinePlayers()){
								MetaData.players_ingame.add(p);
								MetaData.players.remove(p);

							}
						}
						
					}else{
						Bukkit.getConsoleSender().sendMessage("/varo player");
					}
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
				if (sender instanceof Player) {
					sender.sendMessage(ChatColor.AQUA + "get online players" + MetaData.players_ingame);
					sender.sendMessage(ChatColor.AQUA + "get ingame players: " + MetaData.players_ingame.size());
					// Teams.getWinnerOfTheMatch();
					return true;
				} else {
					Bukkit.getServer().getConsoleSender()
							.sendMessage(ChatColor.AQUA + "" + Bukkit.getServer().getOnlinePlayers());
					Bukkit.getServer().getConsoleSender()
							.sendMessage(ChatColor.AQUA + "get ingame players: " + MetaData.players_ingame.size());
				
					return true;
				}
			}

			/**
			 * Die bereit-Funktion Der Countdown geht erst los, wenn alle
			 * Spieler bereit sind
			 */
			if (label.equalsIgnoreCase("bereit")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;

					if (Engine.countdownrunning == false && !MetaData.players_ingame.contains(player)) {

						/**
						 * geht alle Spieler ab, die online sind
						 */

						if (!MetaData.players_bereit.contains(player)) {

							MetaData.players_bereit.add(player);

							int bereit = MetaData.players_bereit.size();
							int online = Bukkit.getServer().getOnlinePlayers().size();

							Bukkit.broadcastMessage(player.getDisplayName() + " ist bereit!                      "
									+ bereit + "/" + online);

							if ((bereit == online)) {

								Bukkit.broadcastMessage(ChatMessage.VARO_Player_allBereit());
								engine.startCountdown(player);

							}

						}

						else

						if (MetaData.players_bereit.contains(player) && MetaData.players.contains(player)) {
							MetaData.players_bereit.remove(player);

							int bereit = MetaData.players_bereit.size();
							int online = Bukkit.getServer().getOnlinePlayers().size();

							Bukkit.broadcastMessage(player.getDisplayName() + " ist nicht bereit!               "
									+ bereit + "/" + online);
						} else

						if (!MetaData.players.contains(player)) {

							player.sendMessage("[---DEBUG-?---]Du bist leider nicht startfähig /refresh");

						}

					} else if (Engine.countdownrunning == true) {

						player.sendMessage("Der countdown läuft bereits");

					} else if (MetaData.players_ingame.contains(player)) {
						player.sendMessage("Du bist schon im Spiel!");
					}

					return true;
				}
			}
		}

		return super.onCommand(sender, command, label, args);

	}

}