package com.github.ivanshchitov.simplegraphicaleditor;

import java.util.ArrayList;

/**
 * Controller class to communicate View and Model.
 * User: Ivan Shchitov. <polotenchik1992@gmail.com>
 * Date: 25.11.13
 * Time: 20:30
 */
public class Controller {
    /**
     * List of shapes.
     */
    private ArrayList<Shape> shapeList;

    /**
     * Default constructor.
     */
    public Controller() {
        shapeList = new ArrayList<Shape>();
    }
}
