import java.util.List;

public class BasicRenderer implements Renderer {

    @Override
    public void render(Result result){

        List<ResultPin> resultPins = result.getResultPins();
        int remainingGuesses = result.getRemainingGeusses();
        System.out.println(result.toString() + ", remaining guesses: " + remainingGuesses);
    }

    @Override
    public void displayIntro() {
        System.out.println("Welcome to mastermind game!");
        Marbles[] marbles = Marbles.values();
        for (int i = 0; i < marbles.length; i++) {
            System.out.println(i + " = " + marbles[i]);
        }
    }
}
