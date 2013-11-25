package com.github.ivanshchitov.simplegraphicaleditor;

/**
 * Shape class implements the knowledge of figure showing shape.
 * User: Ivan Shchitov. <polotenchik1992@gmail.com>
 * Date: 25.11.13
 * Time: 19:47
 */
public class Shape {
    /**
     * X-coordinate
     */
    private int x;
    /**
     * Y-coordinate
     */
    private int y;
    /**
     * Width of shape
     */
    private int width;
    /**
     * Height of shape
     */
    private int height;
    /**
     * Type of shape
     */
    private String shapeType;

    /**
     * Default constructor.
     */
    public Shape() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
        this.shapeType = null;
    }

    /**
     * Constructor with parameters.
     * @param x x-coordinate
     * @param y y-coordinate
     * @param width width of shape
     * @param height height of shape
     * @param shapeType type of shape
     */
    public Shape(int x, int y, int width, int height, String shapeType) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shapeType = shapeType;
    }

    /**
     * Returns x-coordinate of shape.
     * @return x-coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Returns y-coordinate of shape.
     * @return y-coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * Returns width of shape.
     * @return width of shape
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Returns height of shape.
     * @return height of shape
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Returns type of shape.
     * @return type of shape
     */
    public String getShapeType() {
        return this.shapeType;
    }

    /**
     * Sets x-coordinate.
     * @param x x-coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets y-coordinate.
     * @param y y-coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Sets width of shape.
     * @param width width of shape
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Sets height of shape.
     * @param height height of shape
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Sets shape of type.
     * @param shapeType shape of type
     */
    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }
}
