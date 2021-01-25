package com.dungeongame.mechanics;

import java.util.HashMap;
import java.util.Iterator;

import com.dungeongame.player.Player;

public class Scoring {
	
	static HashMap<String, Integer> scores = new HashMap<String, Integer>();
	
	public static void record(Player player, int killCount) {
		
		scores.put(player.getName(), killCount);
		
		scoreTableDisplay();
		
	}
	
	public static void scoreTableDisplay() {
		
		System.out.println("\nPlayer  |  Kills");
		System.out.println("----------------");
		
		for (HashMap.Entry<String, Integer> entry: scores.entrySet()) {
			
			System.out.println(entry.getKey() + "  |  " + entry.getValue());
			
		}

	}
}
