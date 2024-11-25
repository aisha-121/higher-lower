import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // loop to ensure valid input (only y or n)
        String userResponse = "";
        while (true) {
            // prompt the user for input on whether to include jokers
            System.out.print("Would you like to include Jokers? (Y/N): ");
            // read the input and convert it to upper case to handle both cases
            userResponse = scanner.nextLine().toUpperCase();

            // check if the input is either 'Y' or 'N'
            if (userResponse.equals("Y") || userResponse.equals("N")) {
                break; // exit the loop if the input is valid
            } else {
                // print an error message if the input is not valid
                System.out.println("Invalid input! Please enter 'Y' for Yes or 'N' for No.");
            }
        }

        // determine if jokers should be included based on the user's response
        boolean JokersIn = userResponse.equals("Y");

        // create a new game object with the chosen option for jokers
        Game game = new Game(JokersIn);
        // start the game
        game.play();
    }
}
