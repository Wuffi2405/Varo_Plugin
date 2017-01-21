package de.wuffitv.varo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import de.wuffitv.varo.event.VARO_PlayerDeathEvent;

public class Main extends JavaPlugin implements Listener{

	private int countdown;
	private int i = 11;

	@Override
	public void onEnable() {
		super.onEnable();
		Bukkit.getConsoleSender().sendMessage("[VARO] was enabled");
		/**
		 * register Events
		 */
		
		this.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(new VARO_PlayerDeathEvent(this), this);
	
	
		saveDefaultConfig();
	
	}

	@Override
	public void onDisable() {
		super.onDisable();
		Bukkit.getConsoleSender().sendMessage("[VARO] was disabled");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (label.equalsIgnoreCase("google")) {
				player.sendMessage(ChatColor.BLUE + "G" + ChatColor.RED + "o" + ChatColor.YELLOW + "o" + ChatColor.BLUE
						+ "g" + ChatColor.GREEN + "l" + ChatColor.RED + "e" + ChatColor.WHITE);
				return true;
			}

			if (label.equalsIgnoreCase("start")) {

				player.sendMessage("You have started the game!");
				player.sendMessage("");

				countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

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

				return true;

			}

		}
		return super.onCommand(sender, command, label, args);
	}

	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		e.setJoinMessage(p + " has joined the game");
	}
	
	
	
	
	
}
