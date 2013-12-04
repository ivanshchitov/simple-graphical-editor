package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class handler for mouse events.
 * User: Ivan Shchitov. <polotenchik1992@gmail.com>
 * Date: 27.11.13
 * Time: 20:47
 */
public class MouseHandler extends MouseAdapter {
    /**
     * X-coordinate to painting shape.
     */
    private int x;
    /**
     * Y-coordinate to painting shape.
     */
    private int y;
    /**
     * Panel for painting.
     */
    private JPanel paintPanel;
    /**
     * Drawing mode fo shape.
     */
    private int drawingMode;
    /**
     * Color of shape.
     */
    private Color mainColor;
    /**
     * Repository of shape.
     */
    private ShapesRepository repository = new ShapesRepository();

    /**
     * Constructor.
     *
     * @param paintPanel panel for painting shapes
     */
    public MouseHandler(JPanel paintPanel) {
        this.paintPanel = paintPanel;
    }

    /**
     * Sets drawing mode for shape.
     *
     * @param drawingMode new drawing mode
     */
    public void setDrawingMode(int drawingMode) {
        this.drawingMode = drawingMode;
    }

    /**
     * Sets color shape.
     *
     * @param color new color
     */
    public void setMainColor(Color color) {
        this.mainColor = color;
    }

    /**
     * Returns shapes repository.
     *
     * @return repository
     */
    public ShapesRepository getRepository() {
        return repository;
    }

    /**
     * Changes the color of a shape by clicking the mouse.
     *
     * @param event click-event of mouse
     */
    @Override
    public void mouseClicked(MouseEvent event) {
        if (drawingMode != 4) {
            JOptionPane.showMessageDialog(paintPanel, "Change pointer mode.");
        }
        // Цвет меняется не только в области круга,
        // но и в области прямоугольника, в который он вписан.
        // ЭТО ПРОБЛЕМКА. :(
        for (CirclePanel circle : repository.getCirclesList()) {
            if (circle.getCircle().contains(event.getPoint())) {
                circle.setColor(mainColor);
            }
        }
        for (RectanglePanel rectangle : repository.getRectanglesList()) {
            if (rectangle.getRectangle().contains(event.getPoint())) {
                rectangle.setColor(mainColor);
            }
        }
    }

    /**
     * Memorizes the coordinates where the mouse button was pressed.
     *
     * @param event press-event of mouse
     */
    @Override
    public void mousePressed(MouseEvent event) {
        x = event.getX();
        y = event.getY();
    }

    /**
     * Draws a shape when the mouse button was released.
     *
     * @param event release-event of mouse
     */
    @Override
    public void mouseReleased(MouseEvent event) {
        int x1 = x, y1 = y, x2 = event.getX(), y2 = event.getY();
        if (x1 > event.getX()) {
            x2 = x1;
            x1 = event.getX();
        }
        if (y1 > event.getY()) {
            y2 = y1;
            y1 = event.getY();
        }
        if (drawingMode == 3) {
            paintShape(x, y, event.getX(), event.getY());
        } else {
            paintShape(x1, y1, x2, y2);
        }
    }

    /**
     * Paints shape by drawing mode.
     *
     * @param x1 start x-coordinate
     * @param y1 start y-coordinate
     * @param x2 finish x-coordinate
     * @param y2 finish y-coordinate
     */
    private void paintShape(int x1, int y1, int x2, int y2) {
        switch (drawingMode) {
            case 1:
                paintRectangle(x1, y1, x2, y2, mainColor);
                break;
            case 2:
                paintCircle(x1, y1, x2, y2, mainColor);
                break;
            case 3:
                paintLine(x1, y1, x2, y2, mainColor);
                break;
            default:
                break;
        }
        paintPanel.revalidate();
    }

    /**
     * Adds rectangle in paint panel.
     *
     * @param x1    start x-coordinate
     * @param y1    start y-coordinate
     * @param x2    finish x-coordinate
     * @param y2    finish y-coordinate
     * @param color color of rectangle
     */
    private void paintRectangle(int x1, int y1, int x2, int y2, Color color) {
        repository.addRectangle(new RectanglePanel(x1, y1, x2 - x1, y2 - y1, color));
        paintPanel.add(repository.getRectangle(repository.getCountRectangles() - 1));
    }

    /**
     * Adds circle in paint panel.
     *
     * @param x1    start x-coordinate
     * @param y1    start y-coordinate
     * @param x2    finish x-coordinate
     * @param y2    finish y-coordinate
     * @param color color of circle
     */
    private void paintCircle(int x1, int y1, int x2, int y2, Color color) {
        repository.addCircle(new CirclePanel(x1, y1,
                (int) Math.sqrt(Math.pow(Math.abs(x2 - x1), 2)
                + Math.pow(Math.abs(y2 - y1), 2)), color));
        paintPanel.add(repository.getCircle(repository.getCountCircles() - 1));
    }

    /**
     * Adds line in paint panel.
     *
     * @param x1    start x-coordinate
     * @param y1    start y-coordinate
     * @param x2    finish x-coordinate
     * @param y2    finish y-coordinate
     * @param color color of line
     */
    private void paintLine(int x1, int y1, int x2, int y2, Color color) {
        repository.addLine(new LinePanel(x1, y1, x2, y2, color));
        paintPanel.add(repository.getLine(repository.getCountLines() - 1));
    }
}
