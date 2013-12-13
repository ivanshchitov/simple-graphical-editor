package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

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
    private int x;
    /**
     * Axis Y offset.
     */
    private int y;
    /**
     * Radius of circle.
     */
    private final int radius;
    /**
     * Color of circle.
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
     * @param radius radius of circle
     * @param color  color of circle
     */
    public CirclePanel(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.drawOval(this.x, this.y, this.radius, this.radius);
    }

    /**
     * Returns true if Circle contains the point.
     *
     * @param point two-dimensional point
     * @return contains or not
     */
    public boolean isContains(Point point) {
        return Math.pow((point.getX() - (this.x + this.radius / 2)), 2)
                + Math.pow((point.getY() - (this.y + this.radius / 2)), 2)
                <= Math.pow(this.radius / 2, 2);
    }

    /**
     * Sets color of circle.
     *
     * @param color color of circle
     */
    public void setColor(Color color) {
        this.color = color;
        setOpaque(false);
        fireStateChanged(new ChangeEvent(this));
    }

    /**
     * Sets a new coordinates.
     *
     * @param x new x-coordinate
     * @param y new-y coordinate
     */
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
        setOpaque(false);
        fireStateChanged(new ChangeEvent(this));
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
            list = (ArrayList) changeListenerList.clone();
        }
        for (int i = 0; i < list.size(); i++) {
            ((ChangeListener) list.get(i)).stateChanged(event);
        }
    }
}
