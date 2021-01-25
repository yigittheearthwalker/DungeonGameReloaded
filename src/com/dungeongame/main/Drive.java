package com.dungeongame.main;

import java.util.Scanner;

import com.dungeongame.enemies.Enemy;
import com.dungeongame.mechanics.Game;
import com.dungeongame.mechanics.Scoring;
import com.dungeongame.player.Player;

public class Drive {
	public static void main(String[] args) {
		
		//System Objects
		Scanner in = new Scanner(System.in);
		
		//Player Variables
		Player player = new Player();
		
		boolean running = true;
		System.out.println("***** Welcome to the Dungeon****** \n-----------------------------------------------------------------\n");
		
		
		do {
			System.out.print("Please enter your name: ");
			player.setName(in.nextLine());	

		} while (player.getName().length() < 3);
		
		GAME:
		while (running) {
			System.out.println("---------------------------------------------------------------");
						
			Enemy enemy = Game.initiateEnemy();
			
			while (enemy.getHealth() > 0) {
				
				Game.play(player, enemy);
				
				String input = in.nextLine();
				
				if (input.equals("1")) {
					
					Game.attack(player, enemy);
					
					if (player.getHealth() < 1) {
						System.out.println("\t> You have taken to much damage, you are too weak to go on.");
						break;	
					}

				}else if (input.equals("2")) {
					
					Game.heal(player);
					
				}else if(input.equals("3")){
					System.out.println("\tYou run away from the " + enemy.getKind() +"!");
					continue GAME;
				}else {
					System.out.println("\tInvalid Command!");
				}
				
			}
		
			if (player.getHealth() < 1) {
				System.out.println("You limp out of the dungeon, weak from the battle!");
				System.out.println("---------------------------------------------------------------");
				Scoring.record(player, Game.killCount);
				System.out.println("\nWhat would you like to do?");
				System.out.println("1. Play Again");
				System.out.println("2. Exit the Game!");

				String input = in.nextLine();
				
				while (!input.equals("1") && !input.equals("2")) {
					System.out.println("Invalid Command!");
					input = in.nextLine();
				}
				
				if (input.equals("1")) {
					System.out.println("You continue on your adventure");
					player = Game.initiatePlayer();
					do {
						System.out.print("Please enter your name: ");
						player.setName(in.nextLine());	

					} while (player.getName().length() < 3);
					
				}else if(input.equals("2")){
					System.out.println("You exit the dungeon.");
					break;
				}
			} else {
				Game.enemyDefeated(player, enemy);
				
				String input = in.nextLine();
				
				while (!input.equals("1") && !input.equals("2")) {
					System.out.println("Invalid Command!");
					input = in.nextLine();
				}
				
				if (input.equals("1")) {
					System.out.println("You continue on your adventure");
					
				}else if(input.equals("2")){
					System.out.println("You exit the dungeon.");
					break;
				}
			}

		}
		Scoring.scoreTableDisplay();
		System.out.println("\n\t########################");
		System.out.println("\t # Thanks for playing # ");
		System.out.println("\t########################");

	}
	

}
