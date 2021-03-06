package com.snakevsblocks.gui.button;

import com.snakevsblocks.App;
import com.snakevsblocks.util.Font;
import com.snakevsblocks.window.Menu;
import javafx.scene.canvas.GraphicsContext;

/**
 * This class is used to create the Store Button used in Menu.
 */
public class StoreButton extends Button {

    /**
     * Radius of the button.
     */
    private double radius;

    private boolean hovered;

    /**
     * Creates a new Store Button.
     *
     * @param x x coordinate.
     * @param y y coordinate.
     */
    public StoreButton(double x, double y) {
        super(x, y);
        radius = App.TILE_SIZE / 6;
    }

    @Override
    public void show(GraphicsContext gc) {

        // Draw circle
        gc.setLineWidth(2.0);
        gc.setStroke(Menu.FG_COLOR);
        gc.strokeOval(pos.x - radius, pos.y - radius, radius * 2, radius * 2);
        if (hovered) {
            gc.setFill(Menu.FG_COLOR);
            gc.fillOval(pos.x - radius, pos.y - radius, radius * 2, radius * 2);
        }

        // Show button text
        if (hovered) {
            gc.setFill(Menu.BG_COLOR);
        } else {
            gc.setFill(Menu.FG_COLOR);
        }
        gc.setFont(Font.CONSOLAS_SMALL);
        gc.fillText("$", pos.x, pos.y + 1);
    }

    @Override
    public boolean isHovered(double mouseX, double mouseY) {
        return hovered = Math.abs(mouseX - pos.x) <= radius && Math.abs(mouseY - pos.y) <= radius;
    }
}
