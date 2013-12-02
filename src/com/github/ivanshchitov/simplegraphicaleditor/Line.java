package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
     *
     * @param x1    the first point's x coordinate.
     * @param y1    the first point's y coordinate.
     * @param x2    the second point's x coordinate.
     * @param y2    the second point's y coordinate.
     * @param color color of line
     */
    public Line(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        setBounds(this.x1, this.y1, Math.abs(this.x2 - this.x1), Math.abs(this.y2 - this.y1));
        setBackground(Color.blue);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setColor(this.color);
        g2.drawLine(this.x1, this.y1, this.x2, this.y2);
    }
}
