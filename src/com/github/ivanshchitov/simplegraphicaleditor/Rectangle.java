package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Class - rectangle object.
 * User: Ivan Shchitov. <polotenchik1992@gmail.com>
 * Date: 26.11.13
 * Time: 20:02
 */
public class Rectangle extends JPanel {
    /**
     * Axis X offset.
     */
    private final int x;
    /**
     * Axis Y offset.
     */
    private final int y;
    /**
     * Weight of rectangle.
     */
    private final int weight;
    /**
     * Height of rectangle.
     */
    private final int height;
    /**
     * Color of rectangle.
     */
    private Color color;

    /**
     * Constructor, which initializes all fields of class.
     * @param x x-coordinate
     * @param y y-coordinate
     * @param weight weight of rectangle
     * @param height height of rectangle
     * @param color color of rectangle
     */
    public Rectangle(int x, int y, int weight, int height, Color color) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.height = height;
        this.color = color;
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.drawRect(this.x, this.y, this.weight, this.height);
    }

    /**
     * Sets color of rectangle.
     * @param color color of rectangle
     */
    public void setColor(Color color) {
        this.color = color;
        this.repaint();
    }
}