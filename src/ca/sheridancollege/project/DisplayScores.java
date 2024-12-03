/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author limav
 */
public class DisplayScores {
    public void showScores(GoFishGame game) {
        System.out.println("Scores:");
        for (Player player : game.getPlayers()) { 
            GoFishPlayer goFishPlayer = (GoFishPlayer) player; 
            System.out.println(goFishPlayer.getName() + ": " + goFishPlayer.getScore());
        }
    }
}