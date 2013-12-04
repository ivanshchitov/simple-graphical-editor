package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Class - circle object.
 * User: Ivan Shchitov. <polotenchik1992@gmail.com>
 * Date: 26.11.13
 * Time: 19:58
 */
public class CirclePanel extends JPanel {
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
     *
     * @param x      x-coordinate
     * @param y      y-coordinate
     * @param radius radius of circle
     * @param color  color of circle
     */
    public CirclePanel(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        setBounds(this.x, this.y, this.radius, this.radius);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.drawOval(this.x, this.y, this.radius, this.radius);
    }

    /**
     * Returns a rectangle that is have inscribed circle.
     * Need to check whether misses click mouse in our circle or not.
     * Since the whole panel with a circle stretched to the entire window.
     *
     * @return new rectangle that have inscribed circle
     */
    public java.awt.Rectangle getCircle() {
        return new java.awt.Rectangle(this.x, this.y, this.radius, this.radius);
    }

    /**
     * Sets color of circle.
     *
     * @param color color of circle
     */
    public void setColor(Color color) {
        this.color = color;
        repaint();
    }
}
