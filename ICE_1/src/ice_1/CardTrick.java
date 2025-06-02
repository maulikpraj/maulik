/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ice_1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mauli
 */
public class CardTrick {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        // TODO code application logic here
         Scanner input = new Scanner(System.in);
        Random rand = new Random();

        Card[] magicHand = new Card[7];

        // Generate 7 random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1); // 1-13
            c.setSuit(Card.SUITS[rand.nextInt(4)]); // Random suit
            magicHand[i] = c;
        }

        // Ask user to pick a card
        System.out.print("Enter card value (1 to 13): ");
        int userValue = input.nextInt();
        input.nextLine(); // consume newline
        System.out.print("Enter card suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = input.nextLine();

        // Search for user card in magic hand
        boolean found = false;
        for (Card c : magicHand) {
            if (c.getValue() == userValue && c.getSuit().equalsIgnoreCase(userSuit)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card was not found.");
        }

        // Optional: Print all cards for verification
        System.out.println("\nMagic Hand:");
        for (Card c : magicHand) {
            System.out.println(c.getValue() + " of " + c.getSuit());
        }
    }
    
    
}
