import java.util.Comparator;

/**
 * Represents a playing card with a value and a suit.
 */
public class Card {
    private int value;
    private String suit;

    /**
     * Creates a new card with the specified value and suit.
     *
     * @param value the value of the card (1-13, with 1 being A, 11 as J, 12, as Q, and 13 as K).
     * @param suit the suit of the card (club, diamond, heart, or spade).
     */
    public Card (int value, String suit){
        this.value = value;
        this.suit = suit;
    }

    /**
     * @return the card's value.
     */
    public int getValue(){
        return value;
    }

    /**
     * @return the card's suit.
     */
    public String getSuit(){
        return suit;
    }

    /**
     * @return a string representation of the card's value and suit.
     */
    @Override
    public String toString() {
        return value + " of " + suit + 's';
    }
}

/**
 * Comparator class used to sort a Card objects by their value.
 * For collections' sort method.
 */
class SortValue implements Comparator<Card> {
    // https://stackoverflow.com/questions/1206073/sorting-a-collection-of-objects

    /**
     * Compares two Card objects based on their values.
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative, zero, or a positive integer if the first if card's value is
     *         less than, equal to, or greater than the second's respectively.
     */
    @Override
    public int compare(Card o1, Card o2) {
        return o1.getValue() - o2.getValue();
    }
}