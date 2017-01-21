package de.wuffitv.varo;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class MetaData {
	
	public static ArrayList<Player> players = new ArrayList<>();
	public static ArrayList<Player> players_bereit = new ArrayList<>();
	public static ArrayList<Player> players_dummy_online_start = new ArrayList<>();
	public static ArrayList<Player> players_online = new ArrayList<>();
	
	public static int spawn_x;
	public static int spawn_z;
	public static int spawn_y;
	
	public static final boolean DEBUG = true;
}
