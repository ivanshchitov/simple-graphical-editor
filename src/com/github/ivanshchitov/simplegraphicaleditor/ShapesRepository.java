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
    private ArrayList<RectanglePanel> rectangles;
    /**
     * List of circles.
     */
    private ArrayList<CirclePanel> circles;
    /**
     * List of lines.
     */
    private ArrayList<LinePanel> lines;

    /**
     * Default constructor.
     */
    public ShapesRepository() {
        rectangles = new ArrayList<RectanglePanel>(0);
        circles = new ArrayList<CirclePanel>(0);
        lines = new ArrayList<LinePanel>(0);
    }

    /**
     * Adds rectangle in list.
     *
     * @param rectangle new rectangle
     */
    public void addRectangle(RectanglePanel rectangle) {
        rectangles.add(rectangle);
    }

    /**
     * Adds circle in list.
     *
     * @param circle new circle
     */
    public void addCircle(CirclePanel circle) {
        circles.add(circle);
    }

    /**
     * Adds line in list.
     *
     * @param line new line
     */
    public void addLine(LinePanel line) {
        lines.add(line);
    }

    /**
     * Returns rectangle by index.
     *
     * @param index index of rectangle
     * @return rectangle
     */
    public RectanglePanel getRectangle(int index) {
        return rectangles.get(index);
    }

    /**
     * Returns circle by index.
     *
     * @param index index of circle
     * @return circle
     */
    public CirclePanel getCircle(int index) {
        return circles.get(index);
    }

    /**
     * Returns line by index.
     *
     * @param index index of line
     * @return line
     */
    public LinePanel getLine(int index) {
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
     * Returns list of rectangles.
     * @return list of rectangles
     */
    public ArrayList<RectanglePanel> getRectanglesList() {
        return rectangles;
    }

    /**
     * Returns list of circles.
     * @return list of circles
     */
    public ArrayList<CirclePanel> getCirclesList() {
        return circles;
    }

    /**
     * Returns list of lines.
     * @return list of lines
     */
    public ArrayList<LinePanel> getLinesList() {
        return lines;
    }
}
