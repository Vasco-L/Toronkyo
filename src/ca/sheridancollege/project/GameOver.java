/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author limav
 */

public class GameOver {
    public void endGame(GoFishGame game) {
        System.out.println("Game Over!");
        game.declareWinner();
    }
}