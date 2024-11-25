import java.util.Scanner;

public class Game {
    // deck of cards for the game
    private final Deck cardDeck;
    // player's score initialised to 0
    private int playerScore;
    // scanner for user input
    private final Scanner inputScanner;
    // current displayed card in the game
    private Card displayedCard;

    // constructor to initialise the game with the option to include jokers
    public Game(boolean includeJokers) {
        cardDeck = new Deck(includeJokers); // initialise deck with jokers option
        playerScore = 0; // initialise score to 0
        inputScanner = new Scanner(System.in); // create a scanner for user input
    }

    public void play() {
        // game introduction and instructions
        System.out.println();
        System.out.println("Hey there, welcome to Higher/Lower !!");
        System.out.println("Let's have some fun! The aim of the game is to guess if the next card will be higher or lower.");
        System.out.println("You'll earn 1 point for every correct guess !!");
        System.out.println("The game ends when you guess wrong, or when all the cards are gone.");
        System.out.println("Let's see how long you can keep the streak going ! 💖\n");

        // explaining what a joker card does in the game
        System.out.println("Important: If you draw a Joker card, the game ends immediately.");
        System.out.println("If the current card is a Joker, any guess you make will be correct, and the game will continue with the next card.");
        System.out.println("There are two types of Jokers in this game: Red and Black Jokers, but they both have the same effect. Good luck!\n");
        
        // prompt user if they are ready to play with error handling for input
        String readinessResponse = "";
        while (true) {
            // ask the user if they are ready to play
            System.out.print("Are you ready to play the Higher/Lower game? (Y/N): ");
            readinessResponse = inputScanner.nextLine().toLowerCase(); // convert input to lower case

            // check if the response is valid
            if (readinessResponse.equals("y") || readinessResponse.equals("n")) {
                break; // exit loop if valid input
            } else {
                // prompt for valid input if the response is not 'y' or 'n'
                System.out.println("Oops! Please enter 'Y' for yes or 'N' for no.");
                System.out.println();
            }
        }

        // if the user answers 'y', start the game, otherwise exit
        if (readinessResponse.equals("y")) {
            System.out.println("Awesome! Let's begin the game.");
        } else {
            System.out.println("Oh no... Maybe next time then... Goodbye!");
            return; // exit if the user is not ready
        }

        // start the game logic
        cardDeck.shuffleDeck(); // shuffle the deck of cards
        displayedCard = cardDeck.dealCard(); // deal the first card to be displayed
	
	     // main game loop
	        while (true) {
	            System.out.println("\nCurrent card: " + displayedCard); // show the current card
	            System.out.println("Your score: " + playerScore); // display current score
	            System.out.println("Cards left to draw: " + cardDeck.countRemainingCards()); // show how many cards are left
	            System.out.print("Will the next card be (H)igher or (L)ower? "); // prompt for user guess
	
	            String userGuess = inputScanner.nextLine().toUpperCase(); // get user input and convert to upper case
	            if (!"H".equals(userGuess) && !"L".equals(userGuess)) {
	                System.out.println("Please type 'H' or 'L' only."); // prompt for valid input if it's not H or L
	                continue;
	            }
	
	            // deal the next card
	            Card upcomingCard = cardDeck.dealCard();
	            if (upcomingCard == null) {
	                System.out.println("\nGame Over! No more cards left.");
	                break; // exit if no more cards are available
	            }
	
	            // show the next card
	            System.out.println("Next card: " + upcomingCard);
	
	            // check if the next card is a joker
	            if (upcomingCard instanceof Joker) {
	                System.out.println("Oh no! A Joker card has been drawn! Sorry, but this means Game Over! ");
	                System.out.println("Unlucky... Play again soon!!");
	                break; // exit the game if a Joker is drawn
	            }
	
	            // check if the user's guess was correct
	            if (isCorrectGuess(userGuess, displayedCard, upcomingCard)) {
	                System.out.println("You're right! Keep going!");
	                playerScore++; // increase score for a correct guess
	                displayedCard = upcomingCard; // set the new card as the displayed card
	            } else {
	                // wrong guess, end the game
	                System.out.println("Oops! Wrong guess. Game Over!");
	                System.out.println("Play again soon!!");
	                break; // exit the game on wrong guess
	            }
	        }
	
	        // display final score after the game ends
	        System.out.println("\nFinal score: " + playerScore);

    }

    // method to check if the user's guess is correct
    private boolean isCorrectGuess(String guess, Card current, Card next) {
        // jokers always end the game, so return false if next card is a joker
        if (next instanceof Joker) {
            return false;
        }
        // after a joker, any guess is considered correct
        if (current instanceof Joker) {
            return true;
        }

        // get the numerical values of the current and next card
        int currentValue = getCardValue(current.getCardRank());
        int nextValue = getCardValue(next.getCardRank());

        // check if the user's guess matches the card comparison
        if (guess.equals("H")) {
            return nextValue > currentValue; // if the guess is "higher", the next card should have a higher value
        } else {
            return nextValue < currentValue; // if the guess is "lower", the next card should have a lower value
        }
    }

    // helper method to convert card rank to numerical value
    private int getCardValue(String cardRank) {
        // map string rank values to their corresponding numerical values
        switch (cardRank) {
            case Card.ACE: return 1;
            case Card.TWO: return 2;
            case Card.THREE: return 3;
            case Card.FOUR: return 4;
            case Card.FIVE: return 5;
            case Card.SIX: return 6;
            case Card.SEVEN: return 7;
            case Card.EIGHT: return 8;
            case Card.NINE: return 9;
            case Card.TEN: return 10;
            case Card.JACK: return 11;
            case Card.QUEEN: return 12;
            case Card.KING: return 13;
            default: return 0; // error case (should not happen in valid input)
        }
    }
}

