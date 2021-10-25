import java.util.*;

public class GameEngine {

    private int maxAmountGuesses;
    private final CodeSequence solutionSequence;
    private int amountOfGuesses = 0;

    public GameEngine(CodeSequence codeSequence, int maxAmountGuesses) {
        this.solutionSequence = codeSequence;
        this.maxAmountGuesses = maxAmountGuesses;
    }

    public static GameEngine createGame(int maxGuesses) {
        Random random = new Random();
        List<Marbles> allMarbles = new ArrayList<>(Arrays.asList(Marbles.values()));
        List<Marbles> generatedMarbles = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int randomInt = random.nextInt(allMarbles.size());
            generatedMarbles.add(allMarbles.get(randomInt));
            allMarbles.remove(randomInt);
        }
        CodeSequence solutionSequence = new CodeSequence(generatedMarbles);
        return new GameEngine(solutionSequence,maxGuesses);

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
        return new Result(resultPins, maxAmountGuesses - amountOfGuesses);
    }


}
