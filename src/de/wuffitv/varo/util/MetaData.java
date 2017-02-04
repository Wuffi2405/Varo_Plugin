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

		public static ArrayList<Player> relogable = new ArrayList<>();
		

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
	public static int border_size_lower_timeSize;

	public static final boolean DEBUG = false;

	/**
	 * MetaDaten vom Plugin
	 */
	public static String PLUGIN_VERSION;



}
