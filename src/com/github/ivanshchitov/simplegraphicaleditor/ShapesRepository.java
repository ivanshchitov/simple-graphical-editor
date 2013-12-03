package com.github.ivanshchitov.simplegraphicaleditor;

import java.util.ArrayList;

/**
 * Class for storage shapes.
 * User: Ivan Shchitov. <polotenchik1992@gmail.com>
 * Date: 28.11.13
 * Time: 16:20
 */
public class ShapesRepository {
    /**
     * List of rectangles.
     */
    private ArrayList<Rectangle> rectangles;
    /**
     * List of circles.
     */
    private ArrayList<Circle> circles;
    /**
     * List of lines.
     */
    private ArrayList<Line> lines;

    /**
     * Default constructor.
     */
    public ShapesRepository() {
        rectangles = new ArrayList<Rectangle>(0);
        circles = new ArrayList<Circle>(0);
        lines = new ArrayList<Line>(0);
    }

    /**
     * Adds rectangle in list.
     *
     * @param rectangle new rectangle
     */
    public void addRectangle(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    /**
     * Adds circle in list.
     *
     * @param circle new circle
     */
    public void addCircle(Circle circle) {
        circles.add(circle);
    }

    /**
     * Adds line in list.
     *
     * @param line new line
     */
    public void addLine(Line line) {
        lines.add(line);
    }

    /**
     * Returns rectangle by index.
     *
     * @param index index of rectangle
     * @return rectangle
     */
    public Rectangle getRectangle(int index) {
        return rectangles.get(index);
    }

    /**
     * Returns circle by index.
     *
     * @param index index of circle
     * @return circle
     */
    public Circle getCircle(int index) {
        return circles.get(index);
    }

    /**
     * Returns line by index.
     *
     * @param index index of line
     * @return line
     */
    public Line getLine(int index) {
        return lines.get(index);
    }

    /**
     * Returns count of rectangles
     *
     * @return count of rectangles
     */
    public int getCountRectangles() {
        return rectangles.size();
    }

    /**
     * Returns count of circles
     *
     * @return count of circles
     */
    public int getCountCircles() {
        return circles.size();
    }

    /**
     * Returns count of lines
     *
     * @return count of lines
     */
    public int getCountLines() {
        return lines.size();
    }

    /**
     * Removes last rectangle in list.
     */
    public void removeLastRectangle() {
        if (rectangles.size() > 0) {
            rectangles.remove(rectangles.size() - 1);
        } else {
            throw new ArrayIndexOutOfBoundsException("List of rectangles is empty.");
        }
    }

    /**
     * Removes last circle in list.
     */
    public void removeLastCircle() {
        if (circles.size() > 0) {
            circles.remove(circles.size() - 1);
        } else {
            throw new ArrayIndexOutOfBoundsException("List of circles is empty.");
        }
    }

    /**
     * Removes last line in list.
     */
    public void removeLastLine() {
        if (lines.size() > 0) {
            lines.remove(lines.size() - 1);
        } else {
            throw new ArrayIndexOutOfBoundsException("List of lines is empty.");
        }
    }

    /**
     * Removes all rectangles in list.
     */
    public void removeAllRectangles() {
        rectangles.clear();
    }

    /**
     * Removes all circles in list.
     */
    public void removeAllCircles() {
        circles.clear();
    }

    /**
     * Removes all lines in list.
     */
    public void removeAllLines() {
        lines.clear();
    }

    /**
     * Returns list of circles.
     * @return list of circles
     */
    public ArrayList<Circle> getCirclesList() {
        return circles;
    }

    public ArrayList<Rectangle> getRectanglesList() {
        return rectangles;
    }

    public ArrayList<Line> getLinesList() {
        return lines;
    }
}
