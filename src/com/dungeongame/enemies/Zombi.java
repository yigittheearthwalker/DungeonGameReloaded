package com.dungeongame.enemies;

import java.util.Random;

public class Zombi extends Enemy{
	
	Random rand = new Random();
	private String kind = "Zombi";
	private static int maxHealth = 60;
	private int health;
	
	public Zombi(){
		this.health = rand.nextInt(maxHealth - 30) + 30;
	}


	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}


	public int getHealth() {
		return health;
	}


	public int setHealth(int health) {
		return this.health = health;
	}

}
