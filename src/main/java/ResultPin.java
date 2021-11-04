import java.awt.*;

public enum ResultPin {
    CORRECT(Color.GREEN),
    CORRECT_COLOUR(Color.ORANGE),
    INCORRECT(Color.RED);

    Color color;

    ResultPin(Color color) {
        this.color = color;
    }
}
