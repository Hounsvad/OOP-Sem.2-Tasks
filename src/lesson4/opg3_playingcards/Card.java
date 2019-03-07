package lesson4.opg3_playingcards;

/**
 * VOP eksamen F2014
 * Tom klasse til opgave 3
 *
 * @author erso
 */
public class Card implements CardInterface {

    int face;
    int suit;

    public Card(int face, int suit) {
        if (face < ACE || face > KING || suit < CLUBS || suit > SPADES) {
            System.out.println("Input is incorrect");
            System.exit(-1);
        }
        this.face = face;
        this.suit = suit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        switch (suit) {
            case CLUBS:
                sb.append(String.format("%-8s",CLUBS_NAME));
                break;
            case DIAMONDS:
                sb.append(String.format("%-8s",DIAMONDS_NAME));
                break;
            case HEARTS:
                sb.append(String.format("%-8s",HEARTS_NAME));
                break;
            case SPADES:
                sb.append(String.format("%-8s",SPADES_NAME));
                break;
            default:
                System.out.println("How the hell did you manage to get an invalid suit");
        }
        if (face > 1 && face < 11) {
            sb.append(String.format("%-2d", face));
        } else {
            switch (face) {
                case ACE:
                    sb.append(String.format("%-2s",ACE_NAME));
                    break;
                case JACK:
                    sb.append(String.format("%-2s",JACK_NAME));
                    break;
                case QUEEN:
                    sb.append(String.format("%-2s",QUEEN_NAME));
                    break;
                case KING:
                    sb.append(String.format("%-2s",KING_NAME));
                    break;
                default:
                    System.out.println("How the hell did you manage to get an invalid face");
            }
        }
        return sb.toString();
    }

}
