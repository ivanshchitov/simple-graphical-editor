package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 * Class - rectangle object.
 * User: Ivan Shchitov. <polotenchik1992@gmail.com>
 * Date: 26.11.13
 * Time: 20:02
 */
public class RectanglePanel extends JPanel {
    /**
     * Axis X offset.
     */
    private int x;
    /**
     * Axis Y offset.
     */
    private int y;
    /**
     * Weight of rectangle.
     */
    private int width;
    /**
     * Height of rectangle.
     */
    private int height;
    /**
     * Color of rectangle.
     */
    private Color color;
    /**
     * Container of listener.
     */
    private transient ArrayList changeListenerList;

    /**
     * Constructor, which initializes all fields of class.
     *
     * @param x      x-coordinate
     * @param y      y-coordinate
     * @param width  width of rectangle
     * @param height height of rectangle
     * @param color  color of rectangle
     */
    public RectanglePanel(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        setLayout(null);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.drawRect(this.x, this.y, this.width, this.height);
    }

    /**
     * Sets color of rectangle.
     *
     * @param color color of rectangle
     */
    public void setColor(Color color) {
        this.color = color;
        fireStateChanged(new ChangeEvent(this));
    }

    /**
     * Returns true if Rectangle contains the point.
     *
     * @param point two-dimensional point
     * @return      contains or not
     */
    public boolean isContains(Point point) {
        return point.getX() >= this.x
               & point.getX() <= this.x + this.width
               & point.getY() >= this.y
               & point.getY() <= this.y + this.height;
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
