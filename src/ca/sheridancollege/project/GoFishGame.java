/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class GoFishGame extends Game {

    GroupOfCards deck;
    private ArrayList<GoFishPlayer> players;

    public GoFishGame(String name) {
        super(name);
        deck = new GroupOfCards(52); // Standard deck size
        players = new ArrayList<>();
        initializeDeck();
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

        while (true) {
            for (GoFishPlayer player : players) {
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
                int count = 0;
                String currentRank = null;
                for (Card card : player.getHand().getCards()) {
                    GoFishCard goFishCard = (GoFishCard) card;
                    if (currentRank == null) {
                        currentRank = goFishCard.getRank();
                        count = 1;
                    } else if (goFishCard.getRank().equals(currentRank)) {
                        count++;
                    } else {
                        currentRank = goFishCard.getRank();
                        count = 1;
                    }
                    if (count == 4) {
                        System.out.println("You have a set of four " + currentRank + "s! You win!");
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void declareWinner() {
        // Logic to determine and declare the winner
        // For example, the player with the most sets of four cards wins
        // This method is not needed in this simple implementation
    }
}