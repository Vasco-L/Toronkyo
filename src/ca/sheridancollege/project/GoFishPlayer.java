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

    public GoFishPlayer(String name) {
        super(name);
        hand = new GroupOfCards(0); // Hand size starts at 0
    }

    public GroupOfCards getHand() {
        return hand;
    }

    @Override
    public void play() {
        // Logic for a player's turn in Go Fish
    }
}
