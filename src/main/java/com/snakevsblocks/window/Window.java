package com.snakevsblocks.window;

import javafx.event.Event;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.TextAlignment;

import java.io.Serializable;

abstract public class Window implements Serializable {

    protected transient Canvas canvas;
    protected transient WindowController windowController;
    protected transient GraphicsContext gc;

    protected double mouseX;
    protected double mouseY;

    public Window(WindowController windowController, Canvas canvas) {
        init(windowController, canvas);
    }

    public void init(WindowController windowController, Canvas canvas) {
        this.windowController = windowController;
        this.canvas = canvas;

        gc = canvas.getGraphicsContext2D();

        loadDefaults();
        addEventHandlers();
    }

    private void loadDefaults() {

        // Enable KeyEvent detection
        canvas.setFocusTraversable(true);

        // Set Text Align and Baseline to CENTER
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
    }

    public void setMouse(double mouseX, double mouseY) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
    }

    public void toFront() {
        canvas.toFront();
    }

    public void fireEvent(Event event) {
        canvas.fireEvent(event.copyFor(canvas, canvas));
    }

    abstract protected void addEventHandlers();

    abstract public void show();
}
