package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Class handler for mouse events.
 * User: Ivan Shchitov. <polotenchik1992@gmail.com>
 * Date: 27.11.13
 * Time: 20:47
 */
public class MouseHandler extends MouseAdapter implements MouseMotionListener {
    /**
     * X-coordinate to painting shape.
     */
    private int x;
    /**
     * Y-coordinate to painting shape.
     */
    private int y;
    /**
     * Panel for painting.
     */
    private JPanel paintPanel;
    /**
     * Drawing mode fo shape.
     */
    private int drawingMode;
    /**
     * Color of shape.
     */
    private Color mainColor;
    /**
     * Repository of shape.
     */
    private ShapesRepository repository = new ShapesRepository();
    /**
     * Frame of main window.
     */
    private JFrame frame;

    private JPanel movingElement;

    private int indexOfMovingElement;

    /**
     * Constructor.
     *
     * @param paintPanel panel for painting shapes
     */
    public MouseHandler(JFrame frame, JPanel paintPanel) {
        this.paintPanel = paintPanel;
        this.frame = frame;
    }

    /**
     * Sets drawing mode for shape.
     *
     * @param drawingMode new drawing mode
     */
    public void setDrawingMode(int drawingMode) {
        this.drawingMode = drawingMode;
    }

    /**
     * Sets color shape.
     *
     * @param color new color
     */
    public void setMainColor(Color color) {
        this.mainColor = color;
    }

    /**
     * Returns shapes repository.
     *
     * @return repository
     */
    public ShapesRepository getRepository() {
        return repository;
    }

    /**
     * Changes the color of a shape by clicking the mouse.
     *
     * @param event click-event of mouse
     */
    @Override
    public void mouseClicked(MouseEvent event) {
        if (isWrongDrawingMode()) {
            JOptionPane.showMessageDialog(paintPanel, "Change pointer mode.");
            return;
        }
        for (RectanglePanel rectangle : repository.getRectanglesList()) {
            if (rectangle.isContains(event.getPoint())) {
                rectangle.setColor(mainColor);
            }
        }
        for (CirclePanel circle : repository.getCirclesList()) {
            if (circle.isContains(event.getPoint())) {
                circle.setColor(mainColor);
            }
        }
        for (LinePanel line : repository.getLinesList()) {
            if (line.isContains(event.getPoint())) {
                line.setColor(mainColor);
            }
        }
    }

    /**
     * Memorizes the coordinates where the mouse button was pressed.
     *
     * @param event press-event of mouse
     */
    @Override
    public void mousePressed(MouseEvent event) {
        x = event.getX();
        y = event.getY();
        indexOfMovingElement = 0;
        movingElement = null;
        chooseMovingElement(event.getPoint());
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        if (drawingMode == 4) {
            Component comp = (Component) event.getSource();
            if (movingElement instanceof RectanglePanel) {
                repository.getRectangle(indexOfMovingElement).setCoordinates(
                        comp.getX() + event.getX(), comp.getY() + event.getY());
            }
            if (movingElement instanceof CirclePanel) {
                repository.getCircle(indexOfMovingElement).setCoordinates(
                        comp.getX() + event.getX(), comp.getY() + event.getY());
            }
            if (movingElement instanceof LinePanel) {
                repository.getLine(indexOfMovingElement).setCoordinates(
                        comp.getX() + event.getX(),
                        comp.getY() + event.getY(),
                        comp.getX() + event.getX() + repository.getLine(indexOfMovingElement).getDistanceBetweenPointsX(),
                        comp.getY() + event.getY() + repository.getLine(indexOfMovingElement).getDistanceBetweenPointsY());
            }
        }
    }

    /**
     * Draws a shape when the mouse button was released.
     *
     * @param event release-event of mouse
     */
    @Override
    public void mouseReleased(MouseEvent event) {
        int x1 = x, y1 = y, x2 = event.getX(), y2 = event.getY();
        if (x1 > event.getX()) {
            x2 = x1;
            x1 = event.getX();
        }
        if (y1 > event.getY()) {
            y2 = y1;
            y1 = event.getY();
        }
        if (drawingMode == 3) {
            paintShape(x, y, event.getX(), event.getY());
        } else if (drawingMode == 1 || drawingMode == 2) {
            paintShape(x1, y1, x2, y2);
        }
        x = 0; y = 0;
    }

    /**
     * Paints shape by drawing mode.
     *
     * @param x1 start x-coordinate
     * @param y1 start y-coordinate
     * @param x2 finish x-coordinate
     * @param y2 finish y-coordinate
     */
    private void paintShape(int x1, int y1, int x2, int y2) {
        switch (drawingMode) {
            case 1:
                paintRectangle(x1, y1, x2, y2, mainColor);
                break;
            case 2:
                paintCircle(x1, y1, x2, y2, mainColor);
                break;
            case 3:
                paintLine(x1, y1, x2, y2, mainColor);
                break;
            default:
                break;
        }
        frame.revalidate();
    }

    /**
     * Adds rectangle in paint panel.
     *
     * @param x1    start x-coordinate
     * @param y1    start y-coordinate
     * @param x2    finish x-coordinate
     * @param y2    finish y-coordinate
     * @param color color of rectangle
     */
    private void paintRectangle(int x1, int y1, int x2, int y2, Color color) {
        RectanglePanel rectanglePanel = new RectanglePanel(x1, y1, x2 - x1, y2 - y1, color);
        rectanglePanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                frame.repaint();
            }
        });
        repository.addRectangle(rectanglePanel);
        paintPanel.add(repository.getRectangle(repository.getCountRectangles() - 1));
    }

    /**
     * Adds circle in paint panel.
     *
     * @param x1    start x-coordinate
     * @param y1    start y-coordinate
     * @param x2    finish x-coordinate
     * @param y2    finish y-coordinate
     * @param color color of circle
     */
    private void paintCircle(int x1, int y1, int x2, int y2, Color color) {
        CirclePanel circlePanel = new CirclePanel(x1, y1,
                (int) Math.sqrt(Math.pow(Math.abs(x2 - x1), 2)
                        + Math.pow(Math.abs(y2 - y1), 2)), color);
        circlePanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                frame.repaint();
            }
        });
        repository.addCircle(circlePanel);
        paintPanel.add(repository.getCircle(repository.getCountCircles() - 1));
    }

    /**
     * Adds line in paint panel.
     *
     * @param x1    start x-coordinate
     * @param y1    start y-coordinate
     * @param x2    finish x-coordinate
     * @param y2    finish y-coordinate
     * @param color color of line
     */
    private void paintLine(int x1, int y1, int x2, int y2, Color color) {
        LinePanel linePanel = new LinePanel(x1, y1, x2, y2, color);
        linePanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                frame.repaint();
            }
        });
        repository.addLine(linePanel);
        paintPanel.add(repository.getLine(repository.getCountLines() - 1));
    }

    /**
     * Returns true when choose one of the drawing modes,
     * and returns false when choose pointer mode.
     *
     * @return is drawing mode or pointer mode
     */
    private boolean isWrongDrawingMode() {
        switch (drawingMode) {
            case 1:
                paintPanel.remove(repository.getRectangle(repository.getCountRectangles() - 1));
                repository.removeLastRectangle();
                return true;
            case 2:
                paintPanel.remove(repository.getCircle(repository.getCountCircles() - 1));
                repository.removeLastCircle();
                return true;
            case 3:
                paintPanel.remove(repository.getLine(repository.getCountLines() - 1));
                repository.removeLastLine();
                return true;
            default:
                return false;
        }
    }

    /**
     * Selects the element that contains the point which was pressed.
     *
     * @param point point which was pressed
     */
    private void chooseMovingElement(Point point) {
        for (RectanglePanel rectangle : repository.getRectanglesList()) {
            if (rectangle.isContains(point)) {
                movingElement = rectangle;
                indexOfMovingElement = repository.getRectanglesList().indexOf(rectangle);
            }
        }
        for (CirclePanel circle : repository.getCirclesList()) {
            if (circle.isContains(point)) {
                movingElement = circle;
                indexOfMovingElement = repository.getCirclesList().indexOf(circle);
            }
        }
        for (LinePanel line : repository.getLinesList()) {
            if (line.isContains(point)) {
                movingElement = line;
                indexOfMovingElement = repository.getLinesList().indexOf(line);
            }
        }
    }
}
