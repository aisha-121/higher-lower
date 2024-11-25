import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    // list to hold all the cards in the deck
    private final List<Card> cardList;
    
    // boolean to track if jokers are included in the deck
    private final boolean includeJokers;

    // define the available suits and ranks as arrays
    private static final String[] SUITS = {Card.HEARTS, Card.DIAMONDS, Card.CLUBS, Card.SPADES};
    private static final String[] RANKS = {Card.ACE, Card.TWO, Card.THREE, Card.FOUR, Card.FIVE, Card.SIX, 
                                           Card.SEVEN, Card.EIGHT, Card.NINE, Card.TEN, Card.JACK, 
                                           Card.QUEEN, Card.KING};

    // constructor to initialise the deck and set whether to include jokers
    public Deck(boolean includeJokers) {
        this.includeJokers = includeJokers; // set if jokers are included or not
        cardList = new ArrayList<>(); // initialise the list of cards
        setUpDeck(); // set up the deck with the appropriate cards
    }

    // method to set up the deck with cards
    private void setUpDeck() {
        // add regular cards to the deck
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                cardList.add(new Card(suit, rank)); // add each suit and rank combination to the deck
            }
        }

        // add jokers to the deck if specified
        if (includeJokers) {
            cardList.add(new Joker("Red")); // add a red joker
            cardList.add(new Joker("Black")); // add a black joker
        }
    }

    // method to shuffle the deck using Collections.shuffle
    public void shuffleDeck() {
        Collections.shuffle(cardList); // shuffle the list of cards to randomise their order
    }

    // method to deal the top card from the deck
    public Card dealCard() {
        if (cardList.isEmpty()) { 
            return null; // return null if the deck is empty
        }
        return cardList.remove(0); // remove and return the first card in the deck
    }

    // method to count how many cards are left in the deck
    public int countRemainingCards() {
        return cardList.size(); // return the size of the card list (number of remaining cards)
    }

    // method to reset the deck (clear the deck and set it up again)
    public void resetDeck() {
        cardList.clear(); // clear the current deck
        setUpDeck(); // set up the deck with the appropriate cards again
    }
}

