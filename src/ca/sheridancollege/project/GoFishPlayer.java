/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Vasco Lima Oct 8, 2024
 */

public class GoFishPlayer extends Player {

    private GroupOfCards hand;
    private int score;

    public GoFishPlayer(String name) {
        super(name);
        hand = new GroupOfCards(0);// Hand size starts at 0
        score = 0;
    }

    public GroupOfCards getHand() {
        return hand;
    }
    
    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        score += points; // Method to add points to score
    }

    @Override
    public void play() {
       
    }
}
