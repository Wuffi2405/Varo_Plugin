package de.wuffitv.varo.util;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {

	public static File configFile = new File("plugins/Varo_Plugin", "config.yml");
	public static FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(configFile);

	public Config() {
		if (configFile.exists()) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "FILE EXISTS");
			
			loadData();

		} else if (!configFile.exists()) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "FILE NOT EXISTS");
			fileConfiguration.set(".spawn_x", 0);
			fileConfiguration.set(".spawn_z", 0);
			fileConfiguration.set(".spawn_y", 80);

			fileConfiguration.set(".border_size", 500);
			fileConfiguration.set(".border_size_min", 100);
			fileConfiguration.set(".border_size_lower_time", 20);
		
			fileConfiguration.set(".team1-long", 0);
			fileConfiguration.set(".team1-short", 0);
			fileConfiguration.set(".team1-member1", 0);
			fileConfiguration.set(".team1-mebmer2", 0);
			
			fileConfiguration.set(".team2-long", 0);
			fileConfiguration.set(".team2-short", 0);
			fileConfiguration.set(".team2-member1", 0);
			fileConfiguration.set(".team2-mebmer2", 0);
			
			fileConfiguration.set(".team3-long", 0);
			fileConfiguration.set(".team3-short", 0);
			fileConfiguration.set(".team3-member1", 0);
			fileConfiguration.set(".team3-mebmer2", 0);
			
			fileConfiguration.set(".team4-long", 0);
			fileConfiguration.set(".team4-short", 0);
			fileConfiguration.set(".team4-member1", 0);
			fileConfiguration.set(".team4-mebmer2", 0);
			
			fileConfiguration.set(".team5-long", 0);
			fileConfiguration.set(".team5-short", 0);
			fileConfiguration.set(".team5-member1", 0);
			fileConfiguration.set(".team5-mebmer2", 0);
			
			fileConfiguration.set(".team6-long", 0);
			fileConfiguration.set(".team6-short", 0);
			fileConfiguration.set(".team6-member1", 0);
			fileConfiguration.set(".team6-mebmer2", 0);
			
			fileConfiguration.set(".team7-long", 0);
			fileConfiguration.set(".team7-short", 0);
			fileConfiguration.set(".team7-member1", 0);
			fileConfiguration.set(".team7-mebmer2", 0);
			
			fileConfiguration.set(".team8-long", 0);
			fileConfiguration.set(".team8-short", 0);
			fileConfiguration.set(".team8-member1", 0);
			fileConfiguration.set(".team8-mebmer2", 0);
			
			fileConfiguration.set(".team9-long", 0);
			fileConfiguration.set(".team9-short", 0);
			fileConfiguration.set(".team9-member1", 0);
			fileConfiguration.set(".team9-mebmer2", 0);
			
			fileConfiguration.set(".team10-long", 0);
			fileConfiguration.set(".team10-short", 0);
			fileConfiguration.set(".team10-member1", 0);
			fileConfiguration.set(".team10-mebmer2", 0);
			
			try {
				fileConfiguration.save(configFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("[Varo] [Config] [Config] Error with configFile");
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR");
		}
		
		/**
		 * Hier die Klasse nochmal aufrufen, weil sonst die Spawn Koords nicht funktionieren.
		 * Gilt nur für erst rl
		 */
		loadData();
	}
	
	void loadData(){
		/**
		 * laden
		 */
		MetaData.spawn_x = fileConfiguration.getInt(".spawn_x");
		MetaData.spawn_z = fileConfiguration.getInt(".spawn_z");
		MetaData.spawn_y = fileConfiguration.getInt(".spawn_y");
		
		MetaData.border_size = fileConfiguration.getInt(".border_size");
		MetaData.border_size_min = fileConfiguration.getInt(".border_size_min");
		MetaData.border_size_lower_time = fileConfiguration.getInt(".border_size_lower_time");
		//---
		MetaData.team1_long = fileConfiguration.getString(".team1-long");
		
		
		/**
		 * Debugging Ausgabe
		 */
		if(MetaData.DEBUG){
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "X:" + MetaData.spawn_x);
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Z:" + MetaData.spawn_z);
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Y:" + MetaData.spawn_y);
		}
		
	}
	
}
