package com.dungeongame.enemies;

import java.util.Random;

public class Skeleton extends Enemy{

	Random rand = new Random();
	private String kind = "Skeleton";
	private int maxHealth = 30;
	private int health;

	public Skeleton(){
		this.health = rand.nextInt(maxHealth - 10) + 10;
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
