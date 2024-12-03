/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Vasco Lima Oct 8, 2024
 */

public class GoFishGame extends Game {

    GroupOfCards deck;
    private ArrayList<GoFishPlayer> players;
    private boolean gameOver;

    public GoFishGame(String name) {
        super(name);
        deck = new GroupOfCards(52); // Standard deck size
        players = new ArrayList<>();
        initializeDeck();
        gameOver = false;
    }

    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        ArrayList<Card> cards = new ArrayList<>();
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new GoFishCard(suit, rank));
            }
        }
        deck.setCards(cards);
        deck.shuffle();
    }
    
    public boolean isGameOver() {
        return gameOver; // Return the current state of gameOver
    }
    
    @Override
    public ArrayList<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void addPlayer(GoFishPlayer player) {
        players.add(player);
    }

    @Override
    public void play() {
        
        System.out.println("Game started. Players will take turns asking for cards.");

        // Deal 7 cards to each player
        for (GoFishPlayer player : players) {
            for (int i = 0; i < 7; i++) {
                Card card = deck.getCards().remove(0);
                player.getHand().getCards().add(card);
            }
        }

        int currentPlayerIndex = 0; // Start with the first player
        while (players.size() > 1) { // Continue until there's only one player left
            GoFishPlayer player = players.get(currentPlayerIndex);
                System.out.println("\nScores:");
                for (GoFishPlayer p : players) {
                System.out.println(p.getName() + ": " + p.getScore());
                }
                System.out.println("\n" + player.getName() + "'s turn:");
                System.out.println("Hand: " + player.getHand().getCards());

                // Ask the player for a card rank
                System.out.print("Enter a card rank (Case Sensitive) (2-10, Jack, Queen, King, Ace): ");
                Scanner scanner = new Scanner(System.in);
                String rank = scanner.nextLine();

                // Ask the player to choose another player to ask
                System.out.print("Enter the name of the player to ask: ");
                String playerName = scanner.nextLine();
                GoFishPlayer askedPlayer = null;
                for (GoFishPlayer p : players) {
                    if (p.getName().equals(playerName)) {
                        askedPlayer = p;
                        break;
                    }
                }
                // Ask if the player wants to drop out
                PlayerDropOut dropOutHandler = new PlayerDropOut();
                dropOutHandler.handleDropOut(player, players);
                if (players.size() <= 1) {
                    return; // End the game if only one player remains
                }

                if (askedPlayer == null) {
                    System.out.println("Invalid player name.");
                    continue;
                }

                // Check if the asked player has the card
                ArrayList<Card> cardsToGive = new ArrayList<>();
                for (Card card : askedPlayer.getHand().getCards()) {
                    GoFishCard goFishCard = (GoFishCard) card;
                    if (goFishCard.getRank().equals(rank)) {
                        cardsToGive.add(card);
                    }
                }

                if (cardsToGive.isEmpty()) {
                    System.out.println("Go fish!");
                    // Give the player a card from the deck
                    if (!deck.getCards().isEmpty()) {
                        Card card = deck.getCards().remove(0);
                        player.getHand().getCards().add(card);
                        System.out.println("You got a new card: " + card);
                    } else {
                        System.out.println("No more cards in the deck.");
                    }
                } else {
                    System.out.println("Player has the card!");
                    for (Card card : cardsToGive) {
                        askedPlayer.getHand().getCards().remove(card);
                        player.getHand().getCards().add(card);
                    }
                }

                // Check if the player has a set of four cards
                String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        
                for (String currentRank : ranks) {
                    int count = 0;
                    for (Card card : player.getHand().getCards()) {
                        GoFishCard goFishCard = (GoFishCard) card;
                        if (goFishCard.getRank().equals(currentRank)) {
                            count++;
                           }
                    }
                    if (count == 4) {
                        // Update the score for the player
                       player.addScore(1); // Add 1 point for each set of four cards
                       System.out.println(player.getName() + " has collected a set of four " + currentRank + " cards and earned 1 point!");
                
                        // Remove those cards from the player's hand
                        player.getHand().getCards().removeIf(card -> ((GoFishCard) card).getRank().equals(currentRank));
                    }
                }
                currentPlayerIndex++;
            if (currentPlayerIndex >= players.size()) {
                currentPlayerIndex = 0; // Reset to the first player if we reach the end of the list
                }
            }
        declareWinner();
        }
        @Override
        public void declareWinner() {
        GoFishPlayer winner = null;
        int highestScore = -1;
        for (GoFishPlayer player : players) {
            if (player.getScore() > highestScore) {
                highestScore = player.getScore();
                winner = player;
            }
        }
                if (winner != null) {
            System.out.println("The winner is " + winner.getName() + " with a score of " + highestScore);
        }
    }
   }

