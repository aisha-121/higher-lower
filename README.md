# Higher/Lower Card Game

Welcome to the **Higher/Lower** card game! This is a simple guessing game where you try to guess if the next card will be higher or lower than the current card. The game continues until you guess incorrectly or run out of cards.

## How to Play

1. **Game Setup:**
   - The game uses a deck of playing cards. Each card has a suit (Hearts, Diamonds, Clubs, Spades) and a rank (Ace, 2, 3, ..., King).
   - You can choose to include Joker cards in the game, which can add an extra element of surprise! Jokers will immediately end the game when drawn.

2. **The Rules:**
   - The game starts by displaying a card. You need to guess whether the next card will be **higher** or **lower** in rank than the current card.
   - If you guess correctly, you earn 1 point, and the game continues with the new card.
   - If you guess incorrectly, the game ends, and your score is displayed.
   - If a Joker card is drawn, the game also ends immediately, and your score is shown.

3. **Jokers:**
   - Jokers act as game-enders. If a Joker is drawn, the game stops right there, and your final score is displayed.
   - After a Joker, any guess is considered correct, and you can continue playing, but once the Joker is drawn, the game ends immediately.

4. **Game End:**
   - The game ends when you guess wrong or when all cards have been drawn.
   - Your final score is displayed at the end of the game.

## Features

- **Deck Setup:** The game includes the option to play with or without Jokers.
- **Score Tracking:** Your score increases for every correct guess and is displayed at the end.
- **Card Game Logic:** The game compares cards based on their rank (Ace is the lowest, and King is the highest).
- **Game Continuation:** The game continues until you make an incorrect guess or all cards have been used.

## How to Run

### Prerequisites

- Java 8 or higher is required to run the game.

### Steps to Run the Game

1. Clone the repository:
   `git clone https://github.com/aisha-121/higher-lower.git`

2. Navigate to the project directory:
   `cd higher-lower`

3. Compile the Java files:
   `javac *.java`

4. Run the `Main` class to start the game:
   `java Main`

5. Follow the on-screen prompts to play the game.

### Game Flow:

- When prompted, enter "Y" or "N" to choose if you'd like to include Jokers in the game.
- The game will explain the rules, and then ask if you're ready to start. Type "Y" to begin.
- Guess whether the next card will be higher or lower.
- If you guess wrong, the game will end, and your final score will be displayed.
- If you draw a Joker, the game ends immediately, and your score is displayed.
