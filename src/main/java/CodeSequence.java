import java.util.List;

public class CodeSequence {
    private final List<Marbles> marbles;

    public CodeSequence(List<Marbles> marbles) {
        if (marbles.size() != 4) {
            throw new IllegalStateException("Size should be 4 and it is " + marbles.size());
        }
        this.marbles = marbles;
    }

    public List<Marbles> getMarbles() {
        return marbles;
    }
}
