package com.snakevsblocks.gui;

import com.snakevsblocks.App;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BackButton extends Button {

    private Image image;
    private double size;

    public BackButton(double x, double y) {
        super(x, y);
        image = new Image("images/back.png");
        size = App.TILE_SIZE / 2;
    }

    @Override
    public void show(GraphicsContext gc) {
        gc.drawImage(image, pos.x - size / 2, pos.y - size / 2, size, size);
    }

    @Override
    public boolean isHovered(double mouseX, double mouseY) {
        return Math.abs(mouseX - pos.x) <= size / 2 && Math.abs(mouseY - pos.y) <= size / 2;
    }
}
