/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Main.java
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author limav
 */
public class Main {
    public static void main(String [] args) {
        // Create a new Go Fish game
        GoFishGame game = new GoFishGame("Go Fish");

        // Create players
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter player " + (i + 1) + "'s name: ");
            String playerName = scanner.nextLine();
            GoFishPlayer player = new GoFishPlayer(playerName);
            game.addPlayer(player);
        }

        // Play the game
        game.play();

        // Declare the winner
        game.declareWinner();
    }
}