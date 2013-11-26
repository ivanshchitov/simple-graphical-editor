package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Yellow circle object.
 * @author Ivan Shchitov
 */
public class Circle extends JPanel {
    /**
     * Axis X offset.
     */
    private final int x;
    /**
     * Axis Y offset.
     */
    private final int y;
    /**
     * Radius of circle.
     */
    private final int radius;

    /**
     * Color of circle.
     */
    private Color color;

    /**
     * Constructor.
     * @param x axis X offset
     * @param y axis Y offset
     * @param radius radius of circle
     * @param color color of circle
     */
    Circle(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    /**
     * Paints a circle.
     * @param graphics the Graphics context in which to paint
     */
    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(color);
        graphics.drawOval(x, y, radius, radius);
    }

    /**
     * Sets color of circle.
     * @param color color of circle
     */
    public void setColor(Color color) {
        this.color = color;
        repaint();
    }
}
