package de.wuffitv.varo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		super.onEnable();
		Bukkit.getConsoleSender().sendMessage("[VARO] was enabled");
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		Bukkit.getConsoleSender().sendMessage("[VARO] was disabled");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player)sender;
			if(label.equalsIgnoreCase("google")){
				player.sendMessage(ChatColor.BLUE + "G" + ChatColor.RED + "o" + ChatColor.YELLOW + "o" + ChatColor.BLUE + "g" + ChatColor.GREEN + "l" + ChatColor.RED + "e" + ChatColor.WHITE);
				return true;
			}
			
			
			
		}
		return super.onCommand(sender, command, label, args);
	}
	
	
}
