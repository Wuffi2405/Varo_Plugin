package de.wuffitv.varo;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	
	public static File configFile = new File("plugins/varo", "config.yml");
	public static FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(configFile);
	
	public static void setSpawn(){
		fileConfiguration.set(".spawn_x", 0);
		fileConfiguration.set(".spawn_z", 0);
		fileConfiguration.set(".spawn_y", 0);
		
		try {
			fileConfiguration.save(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
