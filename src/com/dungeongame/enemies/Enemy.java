package com.dungeongame.enemies;

public abstract class Enemy {
	public static int maxHealth;
	private int health;
	
	private String kind;
		
	public Enemy() {
		//
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
