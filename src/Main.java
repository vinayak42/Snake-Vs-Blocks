import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;
    private static Scene scene;
    private static Group root;

    @Override
    public void start(Stage primaryStage) {

        Main.primaryStage = primaryStage;

        // Disable resizing
        primaryStage.setResizable(false);

        // Avoid the unnecessary padding on right and bottom
        primaryStage.sizeToScene();

        // Initialize the root Node
        Main.root = new Group();

        // Initialize the Scene
        Main.scene = new Scene(root, Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT);

        // Set Scene and show Stage
        primaryStage.setScene(scene);
        primaryStage.show();

        // Start the animation loop
        animationLoop();
    }

    private void animationLoop() {

        // Initialize a Game object
        Game game = new Game(Main.root);

        // Initialize animationTimer
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                switch (Game.window) {
                    case Menu: {
                        primaryStage.setTitle("Snake Vs Blocks - Menu");
                        game.showMenu();
                    } break;
                    case Gameplay: {
                        primaryStage.setTitle("Snake Vs Blocks");
                        game.showGameplay();
                    } break;
                    case Leaderboard: {
                        primaryStage.setTitle("Snake Vs Blocks - Leaderboard");
                        game.showLeaderboard();
                    } break;
                }
            }
        };

        // Start the animationTimer
        animationTimer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
