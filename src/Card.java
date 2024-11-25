public class Card {
    
    // store the suit of the card (e.g., Hearts, Diamonds, etc.)
    private final String cardSuit;
    
    // store the rank of the card (e.g., Ace, Two, King, etc.)
    private final String cardRank;

    // define constants for the four suits
    public static final String HEARTS = "Hearts";
    public static final String DIAMONDS = "Diamonds";
    public static final String CLUBS = "Clubs";
    public static final String SPADES = "Spades";

    // define constants for the 13 ranks in a standard deck
    public static final String ACE = "Ace";
    public static final String TWO = "Two";
    public static final String THREE = "Three";
    public static final String FOUR = "Four";
    public static final String FIVE = "Five";
    public static final String SIX = "Six";
    public static final String SEVEN = "Seven";
    public static final String EIGHT = "Eight";
    public static final String NINE = "Nine";
    public static final String TEN = "Ten";
    public static final String JACK = "Jack";
    public static final String QUEEN = "Queen";
    public static final String KING = "King";

    // constructor to create a card with a specific suit and rank
    public Card(String cardSuit, String cardRank) {
        this.cardSuit = cardSuit; // set the suit of the card
        this.cardRank = cardRank; // set the rank of the card
    }

    // method to get the suit of the card
    public String getCardSuit() {
        return cardSuit; // return the card's suit
    }

    // method to get the rank of the card
    public String getCardRank() {
        return cardRank; // return the card's rank
    }

    // override the toString method to provide a string representation of the card
    @Override
    public String toString() {
        return cardRank + " of " + cardSuit; // return a string like "Ace of Hearts"
    }
}

