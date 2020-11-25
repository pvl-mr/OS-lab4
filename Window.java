package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Window {

    public JFrame frame;
    private DiskPartition disk;

    public Window() {

        initialize();
    }

    public void initialize() {
        frame = new JFrame();
        frame.setBounds(50, 50, 1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        disk = new DiskPartition(256, 4);
        disk.setBorder(new LineBorder(new Color(0, 0, 0)));
        disk.setBounds(5, 10, 1000, 400);
        disk.setBackground(Color.WHITE);
        disk.setPreferredSize(new Dimension(800, 500));
        frame.getContentPane().add(disk);
        disk.repaint();
    }


}
