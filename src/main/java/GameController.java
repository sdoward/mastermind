import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameController {

    private final Scanner scanner = new Scanner(System.in);


    public void controlGame(){
        displayIntro();
        GameEngine gameEngine = new GameEngine();

        Result result;
        do {
            System.out.println("Make a guess");
            CodeSequence guess = getGuess();
            result = gameEngine.checkGuess(guess);
            System.out.println("Result " + result);
        } while (!result.isWon() && !result.isLost());


        if(result.isWon()){
            System.out.println("CONGRATS!!! YOU HAVE WON!");
        } else if (result.isLost()) {
            System.out.println("YOU SUCK!");
        }

    }


    private void displayIntro() {
        System.out.println("Welcome to mastermind game!");
        Marbles[] marbles = Marbles.values();
        for (int i = 0; i < marbles.length; i++) {
            System.out.println(i + " = " + marbles[i]);
        }
    }

    private CodeSequence getGuess(){
        List<Marbles> guess = new ArrayList<>();
        System.out.println("Select four marbles");
        Marbles[] allMarbles = Marbles.values();
        while (guess.size() != 4) {
            int guessedInteger = scanner.nextInt();
            if (guessedInteger >= 0 && guessedInteger < allMarbles.length) {
                Marbles guessedMarble = allMarbles[guessedInteger];
                guess.add(guessedMarble);
            } else {
                System.out.println("Invalid guess. Please try again.");
            }
        }
        return new CodeSequence(guess);
    }



}
