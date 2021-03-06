package com.snakevsblocks.gui.button;

import com.snakevsblocks.App;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This class is used to create the Resume Button.
 */
public class ResumeButton extends Button {

    /**
     * Size of the button.
     */
    private double size;

    /**
     * Creates a new Resume Button.
     *
     * @param x x coordinate.
     * @param y y coordinate.
     */
    public ResumeButton(double x, double y) {
        super(x, y);
        size = App.TILE_SIZE * 0.75;
    }

    @Override
    public void show(GraphicsContext gc) {

        gc.setFill(Color.WHITE);

        double[] xPoints = {pos.x - size, pos.x - size, pos.x + size};
        double[] yPoints = {pos.y - size, pos.y + size, pos.y};

        gc.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public boolean isHovered(double mouseX, double mouseY) {
        return (mouseY >= pos.y - (size - (mouseX - pos.x)) / 2) &&
                (mouseY <= pos.y + (size - (mouseX - pos.x)) / 2) &&
                (mouseX >= pos.x - size);
    }
}