package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Class - circle object.
 * User: Ivan Shchitov. <polotenchik1992@gmail.com>
 * Date: 26.11.13
 * Time: 19:58
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
     * Constructor, which initializes all fields of class.
     * @param x x-coordinate
     * @param y y-coordinate
     * @param radius radius of circle
     * @param color color of circle
     */
    public Circle(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.drawOval(this.x, this.y, this.radius, this.radius);
    }

    /**
     * Sets color of circle.
     * @param color color of circle
     */
    public void setColor(Color color) {
        this.color = color;
        this.repaint();
    }
}
