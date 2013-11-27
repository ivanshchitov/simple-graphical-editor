package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class for display main window application.
 * User: Ivan Shchitov. <polotenchik1992@gmail.com>
 * Date: 24.11.13
 * Time: 18:58
 */
public class MainWindowFrame extends JFrame {
    /**
     * Panel for painting.
     */
    final private JPanel paintPanel = new JPanel();
    /**
     * Toolbar for choose shape.
     */
    final private JToolBar toolBar = new JToolBar("Toolbar", JToolBar.VERTICAL);
    /**
     * Toolbar for choose colo.
     */
    final private JToolBar colorBar = new JToolBar("Colorbar", JToolBar.HORIZONTAL);

    /**
     * Default constructor.
     */
    public MainWindowFrame() {
        super("Simple Graphical Editor");
        setSize(500, 500);
        initMenus();
        initShapeToolBar();
        initColorToolBar();
        initPanel();
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addComponentListener(createComponentAdapter());
        setVisible(true);
    }

    /**
     * Initializes menu bar of application.
     */
    private void initMenus() {
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new JMenuItem("Clear"));
        fileMenu.add(new JMenuItem("Exit"));
        JMenu aboutMenu = new JMenu("Help");
        aboutMenu.add(new JMenuItem("About"));
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(aboutMenu);
        setJMenuBar(menuBar);
    }

    /**
     * Initializes toolbar for choose shape.
     */
    private void initShapeToolBar() {
        toolBar.add(new JButton(new ImageIcon("res/rect.png")));
        toolBar.add(new JButton(new ImageIcon("res/circle.png")));
        toolBar.add(new JButton(new ImageIcon("res/line.png")));
        toolBar.setSize(40, this.getHeight());
        toolBar.setFloatable(false);
        add(toolBar, BorderLayout.EAST);
    }

    /**
     * Initializes toolbar fo choose color.
     */
    private void initColorToolBar() {
        colorBar.add(createButton(Color.red, 50, 5, 20, 20));
        colorBar.add(createButton(Color.blue, 80, 5, 20, 20));
        colorBar.add(createButton(Color.yellow, 110, 5, 20, 20));
        colorBar.add(createButton(Color.green, 140, 5, 20, 20));
        colorBar.add(createButton(Color.black, 170, 5, 20, 20));
        colorBar.add(createButton(Color.white, 200, 5, 20, 20));
        colorBar.setLayout(null);
        colorBar.setFloatable(false);
        colorBar.setSize(this.getWidth(), 30);
        add(colorBar, BorderLayout.NORTH);
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

    /**
     * Initializes panel for painting.
     */
    private void initPanel() {
        paintPanel.setBackground(Color.white);
        paintPanel.setSize(this.getWidth(), this.getHeight());
        add(paintPanel, BorderLayout.CENTER);
    }

    /**
     * Creates component listener, where override componentResized method.
     * @return new component adapter
     */
    private ComponentAdapter createComponentAdapter() {
        return new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                paintPanel.setSize(e.getComponent().getWidth(), e.getComponent().getHeight());
                toolBar.setSize(40, e.getComponent().getHeight());
                colorBar.setSize(e.getComponent().getWidth(), 30);
            }
        };
    }

    private MouseAdapter createMouseAdapter() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }
        };
    }
}
