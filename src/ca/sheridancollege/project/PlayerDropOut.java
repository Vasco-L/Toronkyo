/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author limav
 */
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerDropOut {
    public boolean askToDropOut(GoFishPlayer player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(player.getName() + ", do you want to drop out? (yes/no): ");
        String response = scanner.nextLine();

        return response.equalsIgnoreCase("yes"); // Return true if the player wants to drop out
    }
     public void handleDropOut(GoFishPlayer player, ArrayList<GoFishPlayer> players) {
        if (askToDropOut(player)) {
            System.out.println(player.getName() + " has dropped out of the game.");
            players.remove(player);
            if (players.size() == 1) {
                System.out.println(players.get(0).getName() + " is the last player remaining and wins the game!");
            } else {
                System.out.println("Continuing the game with " + players.size() + " players.");
            }
        }
    }
}