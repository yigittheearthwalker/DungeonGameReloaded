package com.dungeongame.player;

public class Player {
	private String name;
	private int health;
	private int attackDamage;
	private int numHealthPots;
	
	public Player() {
		setHealth(100);
		setAttackDamage(50);
		setNumHealthPots(3);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getNumHealthPots() {
		return numHealthPots;
	}

	public void setNumHealthPots(int numHealthPots) {
		this.numHealthPots = numHealthPots;
	}
}
