package de.wuffitv.varo;

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
			
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "" + MetaData.spawn_x);
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "" + MetaData.spawn_z);
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "" + MetaData.spawn_y);

		} else if (!configFile.exists()) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "FILE NOT EXISTS");
			fileConfiguration.set(".spawn_x", 0);
			fileConfiguration.set(".spawn_z", 80);
			fileConfiguration.set(".spawn_y", 0);

			fileConfiguration.set(".border_size", 500);
			fileConfiguration.set(".border_size_min", 100);
			fileConfiguration.set(".border_size_lower_time", 20);
			
			fileConfiguration.set(".team1-long", null);
			fileConfiguration.set(".team1-short", null);
			fileConfiguration.set(".team1-member1", null);
			fileConfiguration.set(".team1-mebmer2", null);
			
			fileConfiguration.set(".team2-long", null);
			fileConfiguration.set(".team2-short", null);
			fileConfiguration.set(".team2-member1", null);
			fileConfiguration.set(".team2-mebmer2", null);
			
			fileConfiguration.set(".team3-long", null);
			fileConfiguration.set(".team3-short", null);
			fileConfiguration.set(".team3-member1", null);
			fileConfiguration.set(".team3-mebmer2", null);
			
			fileConfiguration.set(".team4-long", null);
			fileConfiguration.set(".team4-short", null);
			fileConfiguration.set(".team4-member1", null);
			fileConfiguration.set(".team4-mebmer2", null);
			
			fileConfiguration.set(".team5-long", null);
			fileConfiguration.set(".team5-short", null);
			fileConfiguration.set(".team5-member1", null);
			fileConfiguration.set(".team5-mebmer2", null);
			
			fileConfiguration.set(".team6-long", null);
			fileConfiguration.set(".team6-short", null);
			fileConfiguration.set(".team6-member1", null);
			fileConfiguration.set(".team6-mebmer2", null);
			
			fileConfiguration.set(".team7-long", null);
			fileConfiguration.set(".team7-short", null);
			fileConfiguration.set(".team7-member1", null);
			fileConfiguration.set(".team7-mebmer2", null);
			
			fileConfiguration.set(".team8-long", null);
			fileConfiguration.set(".team8-short", null);
			fileConfiguration.set(".team8-member1", null);
			fileConfiguration.set(".team8-mebmer2", null);
			
			fileConfiguration.set(".team9-long", null);
			fileConfiguration.set(".team9-short", null);
			fileConfiguration.set(".team9-member1", null);
			fileConfiguration.set(".team9-mebmer2", null);
			
			fileConfiguration.set(".team10-long", null);
			fileConfiguration.set(".team10-short", null);
			fileConfiguration.set(".team10-member1", null);
			fileConfiguration.set(".team10-mebmer2", null);
			
			try {
				fileConfiguration.save(configFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("[Varo] [Config] [Config] Error with configFile");
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR");
		}
	}

}
