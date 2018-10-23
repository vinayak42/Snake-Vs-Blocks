import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GamePlay extends Window {

    // Temporary field for demonstration
    ArrayList<Burst> bursts = new ArrayList<Burst>();

    public GamePlay(WindowController wc, Group root) {
        super(wc, root);
    }

    @Override
    protected void loadDefaults() {
        super.loadDefaults();

        canvas.setCursor(Cursor.NONE);
    }

    @Override
    protected void addEventHandlers() {
        canvas.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                windowController.setWindow(Windows.Menu);
            }
        });

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            double x = event.getX();
            double y = event.getY();

            bursts.add(new Burst(x, y));
        });
    }

    @Override
    public void show() {

        // Set background
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT);

        // Temporary text
        gc.setFill(Color.WHITE);
        gc.fillText("GamePlay", Game.SCREEN_WIDTH / 2, Game.TILE_SIZE);

        // Burst for demonstration
        for (int i = bursts.size() - 1; i >= 0; i--) {
            Burst b = bursts.get(i);

            if (b.isOver()) {
                bursts.remove(i);
            } else {
                b.show(gc);
            }
        }
    }
}