package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Class - line object.
 * User: Ivan Shchitov. <polotenchik1992@gmail.com>
 * Date: 26.11.13
 * Time: 20:16
 */
public class Line extends JPanel {
    /**
     * The first point's x coordinate.
     */
    private final int x1;
    /**
     * The first point's y coordinate.
     */
    private final int y1;
    /**
     * The second point's x coordinate.
     */
    private final int x2;
    /**
     * The second point's y coordinate.
     */
    private final int y2;
    /**
     * Color of line.
     */
    private Color color;

    /**
     * Constructor, which initializes all fields of class.
     * @param x1 the first point's x coordinate.
     * @param y1 the first point's y coordinate.
     * @param x2 the second point's x coordinate.
     * @param y2 the second point's y coordinate.
     * @param color color of line
     */
    public Line(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.drawLine(this.x1, this.y1, this.x2, this.y2);
    }

    /**
     * Sets color of line.
     * @param color color of line
     */
    public void setColor(Color color) {
        this.color = color;
        this.repaint();
    }
}
