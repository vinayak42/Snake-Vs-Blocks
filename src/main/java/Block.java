import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Block {

    private int value;

    private Vector pos;

    /**
     * Block constructor
     *
     * @param x Horizontal grid coordinate of the block
     * @param y Vertical grid coordinate of the block
     */
    public Block(int x, int y) {

        // Temporary value
        Random random = new Random();
        value = 1 + random.nextInt(10);

        pos = new Vector((x - 1) * Game.TILE_SIZE + Game.TILE_SIZE / 2, (y - 1) * Game.TILE_SIZE + Game.TILE_SIZE / 2);
    }

    public void show(GraphicsContext gc) {

        double xOffset = 2;
        double yOffset = 2;

        // Display block
        gc.setFill(Color.WHITE);
        gc.fillRoundRect(pos.x - Game.TILE_SIZE / 2 + xOffset, pos.y - Game.TILE_SIZE / 2 + yOffset, Game.TILE_SIZE - 2 * xOffset, Game.TILE_SIZE - 2 * yOffset, 10, 10);

        // Show value
        gc.setFill(Color.BLACK);
        gc.setFont(Fonts.GOTHAM_MEDIUM);
        gc.fillText(Integer.toString(value), pos.x, pos.y);
    }

    public void update(double speed) {
        pos.y += speed;
    }

    public boolean isOver() {
        return pos.y - Game.TILE_SIZE / 2 >= Game.SCREEN_HEIGHT;
    }
}
