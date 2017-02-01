package de.wuffitv.varo.util;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class MetaData {
	
	/**
	 * Spieler die startfähig sind
	 */
	public static ArrayList<Player> players = new ArrayList<>();

	/**
	 * alles für den Start
	 */
	/**
	 * Spieler die bereits auf bereit geschalten haben
	 */
	public static ArrayList<Player> players_bereit = new ArrayList<>();
	/**
	 * @Fabius  Bitte Beschreibung hinzufügen !!!!!!!!!
	 */
	public static ArrayList<Player> players_dummy_online_start = new ArrayList<>();
	/**
	 * Spieler die online sind
	 */
	public static ArrayList<Player> players_online = new ArrayList<>();
	
	/**
	 * Spieler für die das Spiel bereits begonnen hat
	 */
	public static ArrayList<Player> players_ingame = new ArrayList<>();

	/**
	 * Spieler die bereits ausgeschieden sind
	 */
	public static ArrayList<Player> players_outgame = new ArrayList<>();
	
	public static int spawn_x;
	public static int spawn_z;
	public static int spawn_y;
	
	public static int border_size;
	public static int border_size_min;
	public static int border_size_lower_time;

	public static final boolean DEBUG = true;
	
	/**
	 * MetaDaten vom Plugin
	 */
	public static String PLUGIN_VERSION;
	
	/**
	 * Teams
	 */
	public static int teams_value = 0;
	
	public static ArrayList<String> teams_names_long = new ArrayList<>();
	public static ArrayList<String> teams_names_short = new ArrayList<>();
	public static ArrayList<String> teams_names_member1 = new ArrayList<>();
	public static ArrayList<String> teams_names_member2 = new ArrayList<>();
	
}
