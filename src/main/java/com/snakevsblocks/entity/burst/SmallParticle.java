package com.snakevsblocks.entity.burst;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SmallParticle extends Particle {

    public SmallParticle(double x, double y) {
        super(x, y);
        radius = 6;
    }

    @Override
    public void show(GraphicsContext gc) {
        gc.setFill(Color.rgb(color[0], color[1], color[2], alpha));
        gc.fillOval(pos.x - radius, pos.y - radius, radius * 2, radius * 2);
    }
}
