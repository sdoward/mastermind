import javax.swing.*;
import java.awt.*;

public class FancyRenderer extends JFrame implements Renderer {
    Result result = null;

    public FancyRenderer() throws HeadlessException {
        setSize(600, 600);
        setVisible(true);
    }

    @Override
    public void render(Result result) {
        this.result = result;
        super.repaint();
    }

    @Override
    public void displayIntro() {
        // todo
    }


    @Override
    public void paint(Graphics g) {
        if (result != null) {
            super.paint(g);

            for (int i = 0; i < result.getResultPins().size(); i++) {
                g.setColor(result.getResultPins().get(i).color);
                g.fillOval(100 * (i + 1), 100, 20, 50);
            }

        }
    }
}
