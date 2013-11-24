package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.*;

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
        initMenus();
        setBounds(0, 0, 500, 500);
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
}
