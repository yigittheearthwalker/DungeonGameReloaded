package com.dungeongame.enemies;

import java.util.Random;

public class Warrior extends Enemy{

	Random rand = new Random();
	private String kind = "Warrior";
	private int maxHealth = 150;
	private int health;

	public Warrior() {
		this.health = rand.nextInt(maxHealth - 100) + 100;
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
