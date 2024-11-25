public class Joker extends Card {
    // variable to store the colour of the joker card
    private final String jokerColor;

    // constructor to initialise the joker card with its colour
    public Joker(String jokerColor) {
        // for the joker, we use placeholder values for suit and rank
        super("Joker", "Joker");  // using "Joker" as both the suit and rank for joker cards
        this.jokerColor = jokerColor; // set the joker colour
    }

    // override toString method to return a string representation of the joker card
    @Override
    public String toString() {
        // return a description of the joker card with its colour
        return "A " + jokerColor + " Joker card!";
    }
}
