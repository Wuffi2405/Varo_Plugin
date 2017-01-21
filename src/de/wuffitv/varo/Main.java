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

	@Override
	public void onEnable() {
		super.onEnable();
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
		 * 
		 */
		if (label.equalsIgnoreCase("start")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				
				if((MetaData.players_dummy_online_start.size() == 0)){
					
					engine.startCountdown(player);
					
				}
				return true;
			}
		}

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

		if (label.equalsIgnoreCase("bereit")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;

				if (!MetaData.players_bereit.contains(player)) {
					MetaData.players_bereit.add(player);
					player.sendMessage("Du bist bereit!");
					
					
					for(Player p: Bukkit.getOnlinePlayers()){
						
						if(MetaData.players_bereit.contains(p)){
							
							MetaData.players_dummy_online_start.remove(p);
							
							if((MetaData.players_dummy_online_start.size() == 0)){
								
								engine.startCountdown(player);
								
							}
							
						}
						
					}
					

				}

				if (MetaData.players_bereit.contains(player)) {
					MetaData.players_bereit.remove(player);
					player.sendMessage("Du bist nicht mehr bereit!");
				}

				return true;
			}
		}

		return super.onCommand(sender, command, label, args);
	}

}