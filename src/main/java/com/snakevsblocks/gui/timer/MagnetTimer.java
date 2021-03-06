package com.snakevsblocks.gui.timer;

import com.snakevsblocks.App;
import com.snakevsblocks.entity.token.Token;
import com.snakevsblocks.util.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Timer for magnet.
 */
public class MagnetTimer extends Timer {

    /**
     * Creates a new magnet timer.
     */
    public MagnetTimer() {
        super(App.SCREEN_WIDTH / 2 - App.TILE_SIZE / 2, App.TILE_SIZE / 2);
    }

    @Override
    public void run(GraphicsContext gc) {
        gc.drawImage(Image.getMAGNET(), pos.x - Token.RADIUS, pos.y - Token.RADIUS, 2 * Token.RADIUS, 2 * Token.RADIUS);

        gc.setFill(Color.WHITE);
        gc.fillRect(pos.x + Token.RADIUS + App.TILE_SIZE / 6, pos.y - Timer.BAR_HEIGHT / 2, Timer.BAR_WIDTH * (val / Timer.MAX_VAL), Timer.BAR_HEIGHT);
    }
}
