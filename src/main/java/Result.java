import java.util.List;

public class Result {

    private final int remainingGuesses;
    private final List<ResultPin> resultPins;

    public Result(List<ResultPin> resultPins, int remainingGuesses) {
        if (resultPins.size() != 4) {
            throw new IllegalStateException("Size should be 4 and it is " + resultPins.size());
        }
        this.resultPins = resultPins;
        this.remainingGuesses = remainingGuesses;
    }

    public boolean isWon() {
        for (ResultPin resultPin : resultPins) {
            if (!resultPin.equals(ResultPin.CORRECT)) {
                return false;
            }
        }
        return true;
    }

    public boolean isLost() {
        return !isWon() && remainingGuesses == 0;
    }

    @Override
    public String toString() {
        return resultPins.toString() + ", remaining guesses: " + remainingGuesses;
    }

    public List<ResultPin> getResultPins() {
        return resultPins;
    }

    public int getRemainingGeusses() {
        return remainingGuesses;
    }
}
