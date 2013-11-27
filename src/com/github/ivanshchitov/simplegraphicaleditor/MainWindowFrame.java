package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
    private final JPanel paintPanel = new JPanel();
    /**
     * Toolbar for choose shape.
     */
    private final JToolBar toolBar = new JToolBar("Toolbar", JToolBar.VERTICAL);
    /**
     * Toolbar for choose colo.
     */
    private final JToolBar colorBar = new JToolBar("Colorbar", JToolBar.HORIZONTAL);

    /**
     * Layered pane to accommodate the panel of painting.
     */
    private JLayeredPane layeredPane = new JLayeredPane();

    /**
     * Default constructor.
     */
    public MainWindowFrame() {
        super("Simple Graphical Editor");
        setSize(500, 500);
        initMenus();
        initShapeToolBar();
        initColorToolBar();
        initLayeredPane();
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addComponentListener(createComponentAdapter());
        addMouseListener(createMouseAdapter());
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
     * Initializes layered pane.
     */
    private void initLayeredPane() {
        add(layeredPane, BorderLayout.CENTER);
        layeredPane.setBounds(0, 0, this.getWidth(), this.getHeight());
        paintPanel.setLayout(new BorderLayout());
        paintPanel.setBounds(0, -40, this.getWidth(), this.getHeight());
        paintPanel.setBackground(Color.white);
        layeredPane.add(paintPanel, new Integer(0), 0);
    }
    /**
     * Creates component listener, where override componentResized method.
     * @return new component adapter
     */
    private ComponentAdapter createComponentAdapter() {
        return new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                toolBar.setSize(40, e.getComponent().getHeight());
                colorBar.setSize(e.getComponent().getWidth(), 30);
                layeredPane.setSize(e.getComponent().getWidth(), e.getComponent().getHeight());
                paintPanel.setSize(e.getComponent().getWidth(), e.getComponent().getHeight());
            }
        };
    }

    private MouseAdapter createMouseAdapter() {
        return new MouseAdapter() {
            int x, y;
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int x1 = x, y1 = y, x2 = e.getX(), y2 = e.getY();
                if (x1 > e.getX()) {
                    x2 = x1; x1 = e.getX();
                }
                if (y1 > e.getY()) {
                    y2 = y1; y1 = e.getY();
                }
                paintPanel.add(new Line(x2, y2, e.getX(), e.getY(), Color.black));
                paintPanel.add(new Circle(x1, y1,
                        (int) Math.sqrt(Math.pow(Math.abs(x2 - x1), 2)
                                        + Math.pow(Math.abs(y2 - y1), 2)),
                        Color.green));
                paintPanel.add(new Rectangle(x1, y1, x2 - x1, y2 - y1, Color.red));
                layeredPane.revalidate();
            }
        };
    }
}
