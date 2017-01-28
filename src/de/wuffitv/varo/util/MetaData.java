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
	public static String team1_long = null;
	public static String team1_short = null;
	public static String team1_member1 = null;
	public static String team1_member2 = null;
	
	public static String team2_long = null;
	public static String team2_short = null;
	public static String team2_member1 = null;
	public static String team2_member2 = null;
	
	public static String team3_long = null;
	public static String team3_short = null;
	public static String team3_member1 = null;
	public static String team3_member2 = null;
	
	public static String team4_long = null;
	public static String team4_short = null;
	public static String team4_member1 = null;
	public static String team4_member2 = null;
	
	public static String team5_long = null;
	public static String team5_short = null;
	public static String team5_member1 = null;
	public static String team5_member2 = null;
	
	public static String team6_long = null;
	public static String team6_short = null;
	public static String team6_member1 = null;
	public static String team6_member2 = null;
	
	public static String team7_long = null;
	public static String team7_short = null;
	public static String team7_member1 = null;
	public static String team7_member2 = null;
	
	public static String team8_long = null;
	public static String team8_short = null;
	public static String team8_member1 = null;
	public static String team8_member2 = null;
	
	public static String team9_long = null;
	public static String team9_short = null;
	public static String team9_member1 = null;
	public static String team9_member2 = null;
	
	public static String team10_long = null;
	public static String team10_short = null;
	public static String team10_member1 = null;
	public static String team10_member2 = null;
	
}
