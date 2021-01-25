package com.dungeongame.mechanics;

import java.util.Random;

import com.dungeongame.enemies.Assassin;
import com.dungeongame.enemies.Enemy;
import com.dungeongame.enemies.Skeleton;
import com.dungeongame.enemies.Warrior;
import com.dungeongame.enemies.Zombi;
import com.dungeongame.player.Player;

public class Game {
	
	//Game Variables
	static Random rand = new Random();

	static int enemyAttackDamage = 50;
	static int attackDamage = 50;
	static int healthPotionHealAmount = 100;
	static int healthPotionDropChance = 50; //Percentage
	
	//Scoring
	public static int killCount;
	
	public static Player initiatePlayer() {
		killCount = 0;
		return new Player();
	}
	
	public static Enemy initiateEnemy() {
		Enemy enemy = enemySelector(rand.nextInt(4));
		System.out.println("\t# " + enemy.getKind() + " appeared! #\n");
		return enemy;
	}
	
	public static void play(Player player, Enemy enemy) {
		System.out.println("\tYour HP: " + player.getHealth());
		System.out.println("\t"+ enemy.getKind() + "'s HP: " + enemy.getHealth());
		System.out.println("\n\tWhat would you like to do?");
		System.out.println("\t1. Attack");
		System.out.println("\t2. Drink Health Potion");
		System.out.println("\t3. Run!");
	}
	
	public static void attack(Player player, Enemy enemy) {
		
		int damageDealth = rand.nextInt(attackDamage);
		int damageTaken = rand.nextInt(enemyAttackDamage);
		
		enemy.setHealth(enemy.getHealth() - damageDealth);
		player.setHealth(player.getHealth() - damageTaken);
		
		System.out.println("\t> You strike the " + enemy.getKind() + " for " + damageDealth + " damage.");
		System.out.println("\t> You received " + damageTaken + " in retaliation.");
	}
	
	public static void heal(Player player) {
				
		if (player.getNumHealthPots() > 0) {
			int toHeal = rand.nextInt(healthPotionHealAmount);
			player.setHealth(player.getHealth() + toHeal);
			player.setNumHealthPots(player.getNumHealthPots() - 1);
			
			System.out.println("\t> You drink a health potion, healing yourself for " + toHeal + "."
					+"\n\t> You now have " + player.getHealth() + " HP."
					+"\n\t> You have " + player.getNumHealthPots() + " health potions left.");
			
		}else {
			System.out.println("\t> You have no health potions left. Defeat enemies to get one!");
		}
		
	}
	
	public static void enemyDefeated(Player player, Enemy enemy) {
		System.out.println("---------------------------------------------------------------");
		System.out.println(" # " + enemy.getKind()
				+ " was defeated! # ");
		System.out.println(" # you have " + player.getHealth() + " HP left. #");
		
		if (rand.nextInt(100) < healthPotionDropChance) {
			player.setNumHealthPots(player.getNumHealthPots() + 1);
			
			System.out.println(" # The enemy dropped a health potion. #");
			System.out.println(" # You now have " + player.getNumHealthPots() + " health potion.");
		}
		killCount++;
		System.out.println("---------------------------------------------------------------");
		System.out.println("What would you like to do?");
		System.out.println("1. Continue fighting");
		System.out.println("2. Exit the Dungeon!");
	}
	
	 static Enemy enemySelector(int enemyIndex) {
		switch (enemyIndex) {
		case 0:
			return new Skeleton();
		case 1:
			return new Zombi();
		case 2:
			return new Assassin();
		case 3:
			return new Warrior();
		default:
			return new Skeleton();
			
		}
		
	}
	
}
