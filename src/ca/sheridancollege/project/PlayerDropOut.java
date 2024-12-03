/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author limav
 */

import java.util.Scanner;

public class PlayerDropOut {
    public boolean askToDropOut(GoFishPlayer player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(player.getName() + ", do you want to drop out? (yes/no): ");
        String response = scanner.nextLine();

        return response.equalsIgnoreCase("yes"); // Return true if the player wants to drop out
    }
}