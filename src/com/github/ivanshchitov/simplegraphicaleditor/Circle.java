package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;


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
     *
     * @param x      x-coordinate
     * @param y      y-coordinate
     * @param radius radius of circle
     * @param color  color of circle
     */
    public Circle(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        setBounds(this.x, this.y, this.radius, this.radius);
    }

    @Override
    public void paint(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setColor(this.color);
        g2.drawOval(this.x, this.y, this.radius, this.radius);
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

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }
}
