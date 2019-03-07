package lesson4.opg3_playingcards;

import java.util.Random;


/**
 * VOP eksamen F2014
 * Kodeskelet til opgave 3c og 3d
 *
 * @author erso
 */
public class DeckOfCards implements CardInterface {

    private Card[] deck;

    public DeckOfCards() {
        // Opg 3c. Initialiser deck, dan de 52 lovlige kort og saet dem i deck-arrayet
        
        //in the event that we weren´t forced to use the constants then (deck.length/4) can be replaced by 13
        deck = new Card[NUMBER_OF_CARDS];
        for (int face = 1; face < 5; face++) {
            for (int i = (deck.length/4)*(face-1); i < (deck.length / 4)*face; i++) {
                deck[i] = new Card(i%(deck.length / 4)+1, face);
            }
        }
    }

    // Faerdiskrevet metode til "paen" udskrift af kortbunken
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < deck.length; i++) {
            if (i != 0 && i % 4 == 0) {
                sb.append("\n");
            }
            sb.append(deck[i]);
            if (i != deck.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public void shuffle(int swaps) {
        // Opgave 3d) Bland kortene
        for(int i = 0; i < (swaps == 0 ? 1: swaps); i++){
            Random r = new Random();
        
            int[] rand = new int[]{r.nextInt(deck.length), r.nextInt(deck.length)};
            Card temp = deck[rand[0]];
            deck[rand[0]] = deck[rand[1]];
            deck[rand[1]] = temp;
        }
    }
}
