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
     * @param rectangle new rectangle
     */
    public void addRectangle(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    /**
     * Adds circle in list.
     * @param circle new circle
     */
    public void addCircle(Circle circle) {
        circles.add(circle);
    }

    /**
     * Adds line in list.
     * @param line new line
     */
    public void addLine(Line line) {
        lines.add(line);
    }

    public Rectangle getRectangle(int index) {
        return rectangles.get(index);
    }

    public Circle getCircle(int index) {
        return circles.get(index);
    }

    public Line getLine(int index) {
        return lines.get(index);
    }

    public int getCountRectangles() {
        return rectangles.size();
    }

    public int getCountCircles() {
        return circles.size();
    }

    public int getCountLines() {
        return lines.size();
    }

    public void removeLastRectangle() {
        rectangles.remove(rectangles.size() - 1);
    }

    public void removeLastCircle() {
        circles.remove(circles.size() - 1);
    }

    public void removeLastLine() {
        lines.remove(lines.size() - 1);
    }
}
