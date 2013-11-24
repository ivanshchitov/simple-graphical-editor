package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.BorderLayout;

/**
 * Class for display main window application.
 * User: Ivan Shchitov. <polotenchik1992@gmail.com>
 * Date: 24.11.13
 * Time: 18:58
 */
public class MainWindow extends JFrame {

    /**
     * Default constructor.
     */
    public MainWindow() {
        super("Simple Graphical Editor");
        setSize(500, 500);
        initMenus();
        initShapeToolBar();
        initColorToolBar();
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Initializes menu bar of application.
     */
    private void initMenus() {
        JMenu fileMenu = new JMenu("File");
        JMenuItem clearMenuItem = new JMenuItem("Clear");
        fileMenu.add(clearMenuItem);
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
        JMenu aboutMenu = new JMenu("Help");
        JMenuItem helpMenuItem = new JMenuItem("About");
        aboutMenu.add(helpMenuItem);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(aboutMenu);
        setJMenuBar(menuBar);
    }

    /**
     * Initializes toolbar for choose shape.
     */
    private void initShapeToolBar() {
        JToolBar toolBar = new JToolBar("Toolbar", JToolBar.VERTICAL);
        toolBar.add(new JButton(new ImageIcon("res/rect.png")));
        toolBar.add(new JButton(new ImageIcon("res/circle.png")));
        toolBar.add(new JButton(new ImageIcon("res/line.png")));
        toolBar.setBounds(0, 0, 40, this.getHeight());
        add(toolBar);
    }

    /**
     * Initializes toolbar fo choose color.
     */
    private void initColorToolBar() {
        JToolBar jtoolBar = new JToolBar("Colorbar", JToolBar.HORIZONTAL);
        jtoolBar.add(createButton(Color.red, 15, 5, 20, 20));
        jtoolBar.add(createButton(Color.blue, 45, 5, 20, 20));
        jtoolBar.add(createButton(Color.yellow, 75, 5, 20, 20));
        jtoolBar.add(createButton(Color.green, 105, 5, 20, 20));
        jtoolBar.add(createButton(Color.black, 135, 5, 20, 20));
        jtoolBar.add(createButton(Color.white, 165, 5, 20, 20));
        jtoolBar.setLayout(null);
        jtoolBar.setBounds(40, 0, this.getWidth(), 30);
        add(jtoolBar);
    }

    /**
     * Creates button with different color, placement and sizes.
     * @param color the background color
     * @param x  the new x-coordinate of this component
     * @param y   the new y-coordinate of this component
     * @param width  the new width of this component
     * @param height  the new height of this component
     * @return new button
     */
    private JButton createButton(Color color, int x, int y, int width, int height) {
        JButton button = new JButton();
        button.setBackground(color);
        button.setBounds(x, y, width, height);
        return button;
    }
}
