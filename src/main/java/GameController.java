import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    private final Scanner scanner = new Scanner(System.in);
    private final static int MAX_GUESSES = 8;
    private final Renderer renderer;

    public GameController(Renderer renderer) {
        this.renderer = renderer;
    }

    public void controlGame() {
       renderer.displayIntro();
        GameEngine gameEngine = GameEngine.createGame(MAX_GUESSES);

        Result result = null;
        do {
            System.out.println("Make a guess");
            try {
                CodeSequence guess = getGuess();
                result = gameEngine.checkGuess(guess);
                renderer.render(result);
            } catch (IllegalStateException e) {
                System.out.println("Whoopsie, something went wrong");
                System.exit(0);
            }

        } while (!result.isWon() && !result.isLost());


        if (result.isWon()) {
            System.out.println("CONGRATS!!! YOU HAVE WON!");
        } else if (result.isLost()) {
            System.out.println("YOU SUCK!");
        }

    }


    private CodeSequence getGuess() {
        List<Marbles> guess = new ArrayList<>();
        System.out.println("Select four marbles");
        Marbles[] allMarbles = Marbles.values();
        while (guess.size() != 4) {

            if (scanner.hasNextInt()) {
                int guessedInteger = scanner.nextInt();
                if (guessedInteger >= 0 && guessedInteger < allMarbles.length) {
                    Marbles guessedMarble = allMarbles[guessedInteger];
                    guess.add(guessedMarble);
                } else {
                    System.out.println("Invalid guess. Please try again.");
                }
            } else {
                System.out.println("Please enter a number between 0 and " + (allMarbles.length - 1));
                scanner.next();
                scanner.close();
            }
        }
        return new CodeSequence(guess);
    }

}
