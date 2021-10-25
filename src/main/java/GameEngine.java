import java.util.*;

public class GameEngine {

    private final static int MAX_AMOUNT_GUESSES = 10;
    private final CodeSequence solutionSequence;
    private int amountOfGuesses = 0;

    public GameEngine(CodeSequence codeSequence) {
        this.solutionSequence = codeSequence;
    }

    public static GameEngine createGame() {
        Random random = new Random();
        List<Marbles> allMarbles = new ArrayList<>(Arrays.asList(Marbles.values()));
        List<Marbles> generatedMarbles = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int randomInt = random.nextInt(allMarbles.size());
            generatedMarbles.add(allMarbles.get(randomInt));
            allMarbles.remove(randomInt);
        }
        CodeSequence solutionSequence = new CodeSequence(generatedMarbles);
        return new GameEngine(solutionSequence);
    }

    public Result checkGuess(CodeSequence guess) {
        List<ResultPin> resultPins = new ArrayList<>();
        List<Marbles> guessedMarbles = guess.getMarbles();

        List<Marbles> solutionMarbles = solutionSequence.getMarbles();
        for (int i = 0; i < guessedMarbles.size(); i++) {
            Marbles guessedMarble = guessedMarbles.get(i);
            if (guessedMarble.equals(solutionMarbles.get(i))) {
                resultPins.add(ResultPin.CORRECT);
            } else if (solutionMarbles.contains(guessedMarble)) {
                resultPins.add(ResultPin.CORRECT_COLOUR);
            } else {
                resultPins.add(ResultPin.INCORRECT);
            }
        }
        Collections.sort(resultPins);
        amountOfGuesses++;
        return new Result(resultPins, MAX_AMOUNT_GUESSES - amountOfGuesses);
    }


}
