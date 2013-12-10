package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 * Class - line object.
 * User: Ivan Shchitov. <polotenchik1992@gmail.com>
 * Date: 26.11.13
 * Time: 20:16
 */
public class LinePanel extends JPanel {
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
     * Container of listener.
     */
    private transient ArrayList changeListenerList;

    /**
     * Constructor, which initializes all fields of class.
     *
     * @param x1    the first point's x coordinate.
     * @param y1    the first point's y coordinate.
     * @param x2    the second point's x coordinate.
     * @param y2    the second point's y coordinate.
     * @param color color of line
     */
    public LinePanel(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.drawLine(this.x1, this.y1, this.x2, this.y2);
    }

    /**
     * Sets color of rectangle.
     *
     * @param color color of line
    */
    public void setColor(Color color) {
        this.color = color;
        fireStateChanged(new ChangeEvent(this));
    }

    /**
     * Returns true if Line contains the point.
     * Validates that the point on the segment using the equation:
     * (x - x1)/(x2 - x1) == (y - y1)/(y2 - y1).
     *
     * @param point two-dimensional point
     * @return      contains or not
     */
    public boolean isContains(Point point) {
        double right = roundNumber((point.getX() - x1) / (x2 - x1), 2);
        double left = roundNumber((point.getY() - y1) / (y2 - y1), 2);
        return right == left & right >= 0 & left >= 0 & right <= 1 & left <= 1;
    }

    /**
     * Rounds a number.
     *
     * @param number  our number
     * @param precise number of decimal places
     * @return        new number
     */
    public double roundNumber(double number, int precise) {
        precise = 10^precise;
        number = number*precise;
        int i = (int) Math.round(number);
        return (double) i/precise;
    }

    /**
     * Adds listeners for this model.
     *
     * @param listener listener for this model.
     */
    @SuppressWarnings("unchecked")
    public synchronized void addChangeListener(ChangeListener listener) {
        if (changeListenerList == null) {
            changeListenerList = new ArrayList();
        }
        changeListenerList.add(listener);
    }

    /**
     * Notice the listeners about the event.
     *
     * @param event enter event
     */
    private void fireStateChanged(ChangeEvent event) {
        ArrayList list;
        synchronized (this) {
            if (changeListenerList == null)
                return;
            list = (ArrayList)changeListenerList.clone();
        }
        for (int i = 0; i < list.size(); i++) {
            ((ChangeListener)list.get(i)).stateChanged(event);
        }
    }
}
