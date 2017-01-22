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
