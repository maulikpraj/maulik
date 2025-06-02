package ice_1;

import java.util.Random;

/**
 * This class performs a card trick by generating a magic hand of 7 cards,
 * then checks whether a hardcoded "lucky card" is in the hand.
 * Modifier: Mauli Prajapati
 * Student Number: 991788918
 * Date Modified: 2025-06-02
 */
public class CardTrick {

    public static void main(String[] args) {

        Random rand = new Random();
        Card[] magicHand = new Card[7];

        // Generate 7 random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1); // Values 1-13
            c.setSuit(Card.SUITS[rand.nextInt(4)]); // Random suit
            magicHand[i] = c;
        }

        // Create a hardcoded lucky card
        Card luckyCard = new Card();
        luckyCard.setValue(7); // Any value from 1-13
        luckyCard.setSuit("Hearts"); // Any valid suit

        // Search for lucky card in the magic hand
        boolean found = false;
        for (Card c : magicHand) {
            if (c.getValue() == luckyCard.getValue() &&
                c.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                found = true;
                break;
            }
        }

        // Print result
        if (found) {
            System.out.println("Congratulations! The lucky card was found in the magic hand!");
        } else {
            System.out.println("Sorry! The lucky card was not found.");
        }

        // Print all cards in magic hand
        System.out.println("\nMagic Hand Cards:");
        for (Card c : magicHand) {
            System.out.println(c.getValue() + " of " + c.getSuit());
        }

        // Also show what the lucky card was
        System.out.println("\nLucky Card: " + luckyCard.getValue() + " of " + luckyCard.getSuit());
    }
}
