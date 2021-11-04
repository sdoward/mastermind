public class Main {

    public static void main(String[] args) {
        Renderer renderer = new FancyRenderer();
        GameController gameController = new GameController(renderer);
        gameController.controlGame();
    }

}
