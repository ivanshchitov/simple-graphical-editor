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
    private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
    /**
     * List of circles.
     */
    private ArrayList<Circle> circles = new ArrayList<Circle>();
    /**
     * List of lines.
     */
    private ArrayList<Line> lines = new ArrayList<Line>();

    /**
     * Default constructor.
     */
    public ShapesRepository() {
        rectangles = null;
        circles = null;
        lines = null;
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
}
