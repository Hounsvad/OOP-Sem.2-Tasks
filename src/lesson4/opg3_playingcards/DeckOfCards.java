package lesson4.opg3_playingcards;

/**
 * VOP eksamen F2014
 * Kodeskelet til opgave 3c og 3d
 * @author erso
 */
public class DeckOfCards implements CardInterface {

    private Card[] deck;

    public DeckOfCards(){
        // Opg 3c. Initialiser deck, dan de 52 lovlige kort og saet dem i deck-arrayet
        
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
            if (i != deck.length-1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public void shuffle(int swaps) {
        // Opgave 3d) Bland kortene
    }

   
    public static void main(String[] args) {
        
            // Til test af opg 3 c
            DeckOfCards deckOfCards = new DeckOfCards();
            System.out.println("Opg 3c:\n" + deckOfCards);
            
            // Til test af opg 3 d
            deckOfCards.shuffle(100);
            System.out.println("Opg 3d:\n" + deckOfCards);
        

    }

}
