package com.github.ivanshchitov.simplegraphicaleditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class - dialog about application.
 * User: Ivan Shchitov. <polotenchik1992@gmail.com>
 * Date: 29.11.13
 * Time: 15:29
 */
public class AboutDialog extends JDialog implements ActionListener {

    /**
     * Constructor.
     *
     * @param owner frame - owner
     * @param modal modal or not modal dialog
     * @throws IOException if file with text about application not found
     */
    public AboutDialog(JFrame owner, boolean modal) throws IOException {
        super(owner, modal);
        setBounds(owner.getX() + 200, owner.getY() + 200, 400, 230);
        JPanel panel = (JPanel) getContentPane();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        panel.add(createHeader());
        panel.add(createTextArea());
        panel.add(cancelButton);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Creates text area with text about application.
     *
     * @return new text area
     * @throws IOException if file with text about application not found
     */
    private JTextArea createTextArea() throws IOException {
        String text = new String();
        Scanner in = new Scanner(new File("res/abouttext.txt"));
        while (in.hasNext())
            text += in.nextLine() + "\r\n";
        in.close();
        JTextArea textArea = new JTextArea(text);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setFont(new Font("Verdana", Font.BOLD, 12));
        return textArea;
    }

    /**
     * Creates header of text about application.
     *
     * @return new text area
     */
    private JTextArea createHeader() {
        String header = "Simple Graphical Editor";
        JTextArea textArea = new JTextArea(header.toUpperCase());
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setFont(new Font("Verdana", Font.CENTER_BASELINE, 16));
        return textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }
}
