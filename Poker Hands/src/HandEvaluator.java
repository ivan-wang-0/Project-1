import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

/**
 * Represents a hand evaluator for a game of poker.
 *
 * @author Ivan Wang
 */
public class HandEvaluator {

    ArrayList<Card> deck = new ArrayList<>();

    /**
     * Builds a deck of cards with all 52 cards.
     */
    public void deckBuilder(){

        int suitCount = 4;
        int valueCount = 13;

        for (int s = 1; s <= suitCount; s++){
            for (int v = 1; v <= valueCount; v++){
                switch (s) {
                    case 1 -> deck.add(new Card(v, "club"));
                    case 2 -> deck.add(new Card(v, "diamond"));
                    case 3 -> deck.add(new Card(v, "heart"));
                    case 4 -> deck.add(new Card(v, "spade"));
                }
            }
        }
    }

    /**
     * Draws the top card from the deck.
     * @return the card that was drawn from the top.
     */
    public Card draw(){
        return (deck.remove(0));
    }

    /**
     * Shuffles the deck.
     */
    public void shuffle(){
        Collections.shuffle(deck);
    }

    /**
     * Deals a standard 5 card poker hand.
     *
     * @return a hand of 5 cards.
     */
    public ArrayList<Card> dealHand(){
        ArrayList<Card> hand = new ArrayList<>();
        for(int i=0; i<5; i++){
            hand.add(draw());
        }
        return hand;
    }

    /**
     * Deals a poker hand with a custom amount of cards.
     *
     * @param amount the number of cards to deal.
     * @return a hand the size of the given amount of cards.
     */
    public ArrayList<Card> dealHand(int amount){
        ArrayList<Card> hand = new ArrayList<>();
        for(int i=0; i<amount; i++){
            hand.add(draw());
        }
        return hand;
    }

    /**
     * Deals a specified number of hands.
     *
     * @param numberOfHands the number of hands to deal.
     * @return an ArrayList containing all the hands.
     */
    public ArrayList<ArrayList<Card>> multipleHands(int numberOfHands, int handSize){
        ArrayList<ArrayList<Card>> hands = new ArrayList<>();
        for (int i = 0; i < numberOfHands; i++){
            deck.clear();
            deckBuilder();
            shuffle();
            hands.add(dealHand(handSize));
        }
        return hands;
    }

    public ArrayList<ArrayList<Card>> multipleHands(int numberOfHands){
        ArrayList<ArrayList<Card>> hands = new ArrayList<>();
        for (int i = 0; i < numberOfHands; i++){
            deck.clear();
            deckBuilder();
            shuffle();
            hands.add(dealHand());
        }
        return hands;
    }

    /**
     * Prints out a hand.
     *
     * @param hand the hand to print.
     */
    public void printHand(ArrayList<Card> hand) {
        for(Card card: hand) {
            System.out.println(card.toString());
        }
    }

    /**
     * Calculates the probabilities of each hand.
     *
     * @param hands the ArrayList of hands to check.
     * @return an array of probabilities for each hand type.
     */
    public double[] handProbabilities(ArrayList<ArrayList<Card>> hands) {
        int[] counts = new int[9]; // Indices represent different hands

        for(ArrayList<Card> hand: hands) {
            if(isRoyal(hand)) counts[8]++;
            else if(isStraightFlush(hand)) counts[7]++;
            else if(isQuad(hand)) counts[6]++;
            else if(isFullHouse(hand)) counts[5]++;
            else if(isFlush(hand)) counts[4]++;
            else if(isStraight(hand)) counts[3]++;
            else if(isTrip(hand)) counts[2]++;
            else if(isPair(hand)) counts[1]++;
            else if(isHigh(hand)) counts[0]++;
        }

        double[] probabilities = new double[9];
        for(int i=0; i < counts.length; i++) {
            probabilities[i] = (double) counts[i] / hands.size();
        }

        return probabilities;
    }

    /**
     * Exports the results (probabilities of each hand type) to a CSV file.
     *
     * @param probabilities the array of probabilities for each hand type.
     */
    public void exportResultsToCSV(double[] probabilities, String filename) {
        String[] handNames = {
                "High Card",
                "Pair",
                "Three of a Kind",
                "Straight",
                "Flush",
                "Full House",
                "Four of a Kind",
                "Straight Flush",
                "Royal Flush"
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Write the headers
            writer.write("Hand Type,Probability\n");

            // Write each hand's probability
            for(int i=0; i < handNames.length; i++) {
                writer.write(handNames[i] + "," + String.format("%.6f", probabilities[i]) + "\n");
            }
        } catch(IOException e) {
            System.out.println("An error occurred while writing to the CSV file");
            e.printStackTrace();
        }
    }

    /**
     * Checks if a hand contains a straight.
     *
     * @param hand the hand to check.
     * @return true if the hand is a straight, false otherwise.
     */
    public boolean isStraight(ArrayList<Card> hand){
        Collections.sort(hand, new SortValue());

        int startValue = hand.get(0).getValue();

        if (startValue == 1 &&
            hand.get(1).getValue() == 10 &&
            hand.get(2).getValue() == 11 &&
            hand.get(3).getValue() == 12 &&
            hand.get(4).getValue() == 13) {
            // This is a special case for the 10-J-Q-K-A straight.
            return true;
        }
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).getValue() != startValue + i) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a hand is a flush.
     *
     * @param hand the hand to check.
     * @return true if the hand is a flush, false otherwise.
     */
    public boolean isFlush(ArrayList<Card> hand){
        String suit = hand.get(0).getSuit();
        for (Card card : hand) {
            if (!card.getSuit().equals(suit)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a hand is a straight flush.
     *
     * @param hand the hand to check.
     * @return true if the hand is a straight flush, false otherwise.
     */
    public boolean isStraightFlush(ArrayList<Card> hand){
        return isStraight(hand) && isFlush(hand);
    }

    /**
     * Checks if a hand is a royal flush.
     *
     * @param hand the hand to check.
     * @return true if the hand is a royal flush, false otherwise.
     */
    public boolean isRoyal(ArrayList<Card> hand){
        Collections.sort(hand, new SortValue());
        return hand.get(0).getValue() == 1 && isStraightFlush(hand) && hand.get(4).getValue() == 13;
    }

    /**
     * Helper method for isPair, isTrip, isQuad, and isFullHouse.
     * Groups the cards in the hand by their value.
     *
     * @param hand the hand to group.
     * @return an ArrayList containing the counts of each value in hand.
     */
    public ArrayList<Integer> groupByValue(ArrayList<Card> hand){
        Collections.sort(hand, new SortValue());

        int count = 1;
        int previousValue = hand.get(0).getValue();
        ArrayList<Integer> counts = new ArrayList<>();

        for(int i = 1; i < hand.size(); i++){
            Card current = hand.get(i);
            if (current.getValue() == previousValue){
                count++;
            } else {
                counts.add(count); // adds the count of that specific value to counts.
                count = 1; // resets count value.
                previousValue = current.getValue(); // prepares loop to check for the new value.
            }
        }

        counts.add(count); // adds last series of cards to counts.
        return counts;
    }

    /**
     * Checks if a hand is a full house.
     *
     * @param hand the hand to check.
     * @return true if the hand is a full house, false otherwise.
     */
    public boolean isFullHouse(ArrayList<Card> hand){
        List<Integer> counts = groupByValue(hand);
        return counts.contains(3) && counts.contains(2);
    }

    /**
     * Checks if a hand has four of a kind.
     *
     * @param hand the hand to check.
     * @return true if the hand has four of a kind, false otherwise.
     */
    public boolean isQuad(ArrayList<Card> hand){
        ArrayList<Integer> counts = groupByValue(hand);
        return counts.contains(4);
    }

    /**
     * Checks if a hand has three of a kind.
     *
     * @param hand the hand to check.
     * @return true if the hand has three of a kind, false otherwise.
     */
    public boolean isTrip(ArrayList<Card> hand){
        ArrayList<Integer> counts = groupByValue(hand);
        return counts.contains(3);
    }

    /**
     * Checks if a hand has a pair.
     *
     * @param hand the hand to check.
     * @return true if the hand has a pair, false otherwise.
     */
    public boolean isPair(ArrayList<Card> hand){
        ArrayList<Integer> counts = groupByValue(hand);
        return counts.contains(2);
    }

    /**
     * Checks if a hand is a high card hand.
     *
     * @param hand the hand to check.
     * @return true if the hand is a high card hand, false otherwise.
     */
    public boolean isHigh(ArrayList<Card> hand){
        // If the hand fits any of these categories, return false. Checks for more common hands first.
        if (isPair(hand))
            return false;
        if (isTrip(hand))
            return false;
        if (isQuad(hand))
            return false;
        if (isStraight(hand))
            return false;
        if (isFlush(hand))
            return false;
        if (isFullHouse(hand))
            return false;
        if (isStraightFlush(hand))
            return false;
        if (isRoyal(hand))
            return false;
        // If none of the above, it's a high card hand

        return true;
    }

    /**
     * Determines the highest card in a hand.
     *
     * @param hand the hand to check.
     * @return the highest card in the hand.
     */
    public Card highCard(ArrayList<Card> hand){
        Collections.sort(hand, new SortValue());
        return hand.get(hand.size() - 1);
    }

}


