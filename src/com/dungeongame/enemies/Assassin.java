package com.dungeongame.enemies;

import java.util.Random;

public class Assassin extends Enemy{

	Random rand = new Random();
	private String kind = "Assasin";
	private int maxHealth = 90;
	private int health;
	
	public Assassin() {
		// TODO Auto-generated constructor stub
		this.health = rand.nextInt(maxHealth - 60) + 60;
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
