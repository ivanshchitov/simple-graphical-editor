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
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
     * Toolbar for choose color.
     */
    private final JToolBar colorBar = new JToolBar("Colorbar", JToolBar.HORIZONTAL);
    /**
     * Layered pane to accommodate the panel of painting.
     */
    private JLayeredPane layeredPane = new JLayeredPane();
    /**
     * Color button, where displayed current color.
     */
    private JButton mainColorButton = new JButton();
    /**
     * Mouse handler.
     */
    private MouseHandler mouseHandler;

    /**
     * Default constructor.
     */
    public MainWindowFrame() {
        super("Simple Graphical Editor");
        setSize(500, 500);
        initShapeToolBar();
        initColorToolBar();
        initLayeredPane();
        mouseHandler = new MouseHandler(paintPanel, layeredPane);
        initMenus();
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseListener(mouseHandler);
        addComponentListener(createComponentAdapter());
        setVisible(true);
    }

    /**
     * Initializes menu bar of application.
     */
    private void initMenus() {
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(createClearMenuItem());
        fileMenu.add(createExitMenuItem());
        JMenu editMenu = new JMenu("Edit");
        editMenu.add(createDeleteLastRectangleMenuItem());
        editMenu.add(createDeleteLastCircleMenuItem());
        editMenu.add(createDeleteLastLineMenuItem());
        JMenu aboutMenu = new JMenu("Help");
        aboutMenu.add(new JMenuItem("About"));
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);
        setJMenuBar(menuBar);
    }

    /**
     * Creates menu item for exit from application.
     * @return new menu item
     */
    private JMenuItem createExitMenuItem() {
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return exitMenuItem;
    }

    /**
     * Creates menu item for clear paint panel.
     * @return new menu item
     */
    private JMenuItem createClearMenuItem() {
        JMenuItem clearMenuItem = new JMenuItem("Clear");
        clearMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.removeAll();
                paintPanel.repaint();
            }
        });
        return clearMenuItem;
    }

    /**
     * Creates menu item for delete last rectangle.
     * @return new menu item
     */
    private JMenuItem createDeleteLastRectangleMenuItem() {
        JMenuItem deleteLastRectangle = new JMenuItem("Delete last rectangle");
        deleteLastRectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.remove(mouseHandler.getRepository().getRectangle(
                        mouseHandler.getRepository().getCountRectangles() - 1));
                mouseHandler.getRepository().removeLastRectangle();
                System.out.println("Rects-: " + mouseHandler.getRepository().getCountRectangles());
                paintPanel.repaint();
            }
        });
        return deleteLastRectangle;
    }

    /**
     * Creates menu item for delete last circle.
     * @return new menu item
     */
    private JMenuItem createDeleteLastCircleMenuItem() {
        JMenuItem deleteLastCircle = new JMenuItem("Delete last circle");
        deleteLastCircle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.remove(mouseHandler.getRepository().getCircle(
                        mouseHandler.getRepository().getCountCircles() - 1));
                mouseHandler.getRepository().removeLastCircle();
                System.out.println("Circles-: " + mouseHandler.getRepository().getCountCircles());
                paintPanel.repaint();
            }
        });
        return deleteLastCircle;
    }

    /**
     * Creates menu item for delete last line.
     * @return new menu item
     */
    private JMenuItem createDeleteLastLineMenuItem() {
        JMenuItem deleteLastLine = new JMenuItem("Delete last line");
        deleteLastLine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.remove(mouseHandler.getRepository().getLine(
                        mouseHandler.getRepository().getCountLines() - 1));
                mouseHandler.getRepository().removeLastLine();
                System.out.println("Lines-: " + mouseHandler.getRepository().getCountLines());
                paintPanel.repaint();
            }
        });
        return  deleteLastLine;
    }

    /**
     * Initializes toolbar for choose shape.
     */
    private void initShapeToolBar() {
        toolBar.add(createShapeButton("res/rect.png", 1));
        toolBar.add(createShapeButton("res/circle.png", 2));
        toolBar.add(createShapeButton("res/line.png", 3));
        toolBar.setSize(40, this.getHeight());
        toolBar.setFloatable(false);
        add(toolBar, BorderLayout.EAST);
    }

    /**
     * Creates shape button.
     * @param iconPath path to icon button
     * @param shapeMode drawing mode shape
     * @return new shape button
     */
    private JButton createShapeButton(String iconPath, final int shapeMode) {
        JButton button = new JButton(new ImageIcon(iconPath));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mouseHandler.setDrawingMode(shapeMode);
            }
        });
        return button;
    }

    /**
     * Initializes toolbar fo choose color.
     */
    private void initColorToolBar() {
        mainColorButton.setBackground(Color.black);
        mainColorButton.setBounds(50, 4, 21, 21);
        colorBar.add(mainColorButton);
        colorBar.add(createColorButton(Color.red, 80, 5, 18, 18));
        colorBar.add(createColorButton(Color.blue, 110, 5, 18, 18));
        colorBar.add(createColorButton(Color.yellow, 140, 5, 18, 18));
        colorBar.add(createColorButton(Color.green, 170, 5, 18, 18));
        colorBar.add(createColorButton(Color.black, 200, 5, 18, 18));
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
    private JButton createColorButton(final Color color, int x, int y, int width, int height) {
        JButton button = new JButton();
        button.setBackground(color);
        button.setBounds(x, y, width, height);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainColorButton.setBackground(color);
                mouseHandler.setMainColor(color);
            }
        });
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
}
