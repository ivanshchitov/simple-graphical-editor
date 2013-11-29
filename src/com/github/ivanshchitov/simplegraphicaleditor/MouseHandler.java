package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.JPanel;
import javax.swing.JLayeredPane;
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
     * @param paintPanel panel for painting shapes
     */
    public MouseHandler(JPanel paintPanel) {
        this.paintPanel = paintPanel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x1 = x, y1 = y, x2 = e.getX(), y2 = e.getY();
        if (x1 > e.getX()) {
            x2 = x1; x1 = e.getX();
        }
        if (y1 > e.getY()) {
            y2 = y1; y1 = e.getY();
        }
        if (drawingMode == 3) {
            paintShape(x, y, e.getX(), e.getY());
        } else {
            paintShape(x1, y1, x2, y2);
        }
    }

    /**
     * Paints shape by drawing mode.
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
     * Adds line in paint panel.
     * @param x1 start x-coordinate
     * @param y1 start y-coordinate
     * @param x2 finish x-coordinate
     * @param y2 finish y-coordinate
     * @param color color of line
     */
    private void paintLine(int x1, int y1, int x2, int y2, Color color) {
        repository.addLine(new Line(x1, y1, x2, y2, color));
        paintPanel.add(repository.getLine(repository.getCountLines() - 1));
    }

    /**
     * Adds circle in paint panel.
     * @param x1 start x-coordinate
     * @param y1 start y-coordinate
     * @param x2 finish x-coordinate
     * @param y2 finish y-coordinate
     * @param color color of circle
     */
    private void paintCircle(int x1, int y1, int x2, int y2, Color color) {
        repository.addCircle(new Circle(x1, y1, (int) Math.sqrt(Math.pow(Math.abs(x2 - x1), 2)
                + Math.pow(Math.abs(y2 - y1), 2)), color));
        paintPanel.add(repository.getCircle(repository.getCountCircles() - 1));
    }

    /**
     * Adds rectangle in paint panel.
     * @param x1 start x-coordinate
     * @param y1 start y-coordinate
     * @param x2 finish x-coordinate
     * @param y2 finish y-coordinate
     * @param color color of rectangle
     */
    private void paintRectangle(int x1, int y1, int x2, int y2, Color color) {
        repository.addRectangle(new Rectangle(x1, y1, x2 - x1, y2 - y1, color));
        paintPanel.add(repository.getRectangle(repository.getCountRectangles() - 1));
    }

    /**
     * Sets drawing mode for shape.
     * @param drawingMode new drawing mode
     */
    public void setDrawingMode(int drawingMode) {
        this.drawingMode = drawingMode;
    }

    /**
     * Sets color shape.
     * @param color new color
     */
    public void setMainColor(Color color) {
        this.mainColor = color;
    }

    /**
     * Returns shapes repository.
     * @return repository
     */
    public ShapesRepository getRepository() {
        return repository;
    }
}
