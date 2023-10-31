import java.util.ArrayList;
import java.util.Collections;

public class PokerTester {
    public static void main(String[] args) {
        HandEvaluator dealer = new HandEvaluator();

        // deckBuilder() test
        dealer.deckBuilder();
        System.out.println("Deck size after building: " + dealer.deck.size()); // Expected: 52

        // shuffle() test
        dealer.shuffle();
        System.out.println("First card after shuffle: " + dealer.draw().toString());

        // Resetting the deck for further tests
        dealer.deck.clear();
        dealer.deckBuilder();
        dealer.shuffle();

        // Testing dealHand() and dealHand(int amount)
        ArrayList<Card> hand5 = dealer.dealHand();
        System.out.println("\n5-card hand:");
        for (Card card : hand5) {
            System.out.println(card.toString());
        }

        ArrayList<Card> hand7 = dealer.dealHand(7);
        System.out.println("\n7-card hand:");
        for (Card card : hand7) {
            System.out.println(card.toString());
        }

        // Testing poker hands
        ArrayList<Card> sample = new ArrayList<>();
        sample.add(new Card(1, "heart"));
        sample.add(new Card(10, "heart"));
        sample.add(new Card(13, "heart"));
        sample.add(new Card(12, "heart"));
        sample.add(new Card(11, "heart"));

        System.out.println("\nSample hand (A Royal Flush):");
        for (Card card : sample) {
            System.out.println(card.toString());
        }
        System.out.println();
        System.out.println("Is it a Royal Flush? " + dealer.isRoyal(sample));
        System.out.println("Is it a Straight Flush? " + dealer.isStraightFlush(sample));
        System.out.println("Is it a Straight? " + dealer.isStraight(sample));
        System.out.println("Is it a Flush? " + dealer.isFlush(sample));
        System.out.println("Is it a Full House? " + dealer.isFullHouse(sample));
        System.out.println("Does it have Four of a Kind? " + dealer.isQuad(sample));
        System.out.println("Does it have Three of a Kind? " + dealer.isTrip(sample));
        System.out.println("Does it have a Pair? " + dealer.isPair(sample));
        System.out.println("Is it a High Card hand? " + dealer.isHigh(sample));
        System.out.println("Highest card in hand: " + dealer.highCard(sample).toString());

        // Finding probabilities of a 5 card hand.
        dealer.exportResultsToCSV(dealer.handProbabilities(dealer.multipleHands(1000000)),"5_card_probabilities.csv");
        // Finding probabilities of a 7 hand card.
        dealer.exportResultsToCSV(dealer.handProbabilities(dealer.multipleHands(1000000, 7)),"7_card_probabilities.csv");
    }
}