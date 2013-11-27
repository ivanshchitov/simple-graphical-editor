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
    private final JPanel paintPanel;
    /**
     * Layered pane to accommodate the panel of painting.
     */
    private final JLayeredPane layeredPane;

    /**
     * Constructor.
     * @param paintPanel panel for painting shapes
     * @param layeredPane layered pane to accommodate the panel of painting
     */
    public MouseHandler(JPanel paintPanel, JLayeredPane layeredPane) {
        this.paintPanel = paintPanel;
        this.layeredPane = layeredPane;
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
        paintLine(x, y, e.getX(), e.getY(), Color.black);
        paintCircle(x1, y1, x2, y2, Color.black);
        paintRectangle(x1, y1, x2, y2, Color.black);
        layeredPane.revalidate();
    };

    /**
     * Adds line in paint panel.
     * @param x1 start x-coordinate
     * @param y1 start y-coordinate
     * @param x2 finish x-coordinate
     * @param y2 finish y-coordinate
     * @param color color of line
     */
    private void paintLine(int x1, int y1, int x2, int y2, Color color) {
        paintPanel.add(new Line(x1, y1, x2, y2, color));
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
        paintPanel.add(new Circle(x1, y1, (int) Math.sqrt(Math.pow(Math.abs(x2 - x1), 2)
                        + Math.pow(Math.abs(y2 - y1), 2)), color));
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
        paintPanel.add(new Rectangle(x1, y1, x2 - x1, y2 - y1, color));
    }
}
