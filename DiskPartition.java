package com.company;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DiskPartition extends JPanel {
    private int size;
    private int clusterSize;
    private Cluster[] clusters;
    private int countOfClusters;


    public DiskPartition(int size, int clusterSize) {
        this.size = size;
        this.clusterSize = clusterSize;
        countOfClusters = size/clusterSize;
        clusters = new Cluster[countOfClusters];
        for (int i = 0; i < countOfClusters; i++) {
            clusters[i] = new Cluster();
        }
    }

    public ArrayList<Cluster> getFreeClusters() {
        ArrayList<Cluster> freeClusters = new ArrayList<Cluster>();
        for (int i = 0; i < countOfClusters; i++) {
            if (clusters[i].getIsUsed() == false) {
                freeClusters.add(clusters[i]);
            }
        }
        return freeClusters;
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int x = 10, y = 10;

        for (int i = 0; i < countOfClusters; i++) {
            if (x + 50 >= this.getWidth()) {
                x = 10;
                y += 50;
            }
            if (clusters[i].getIsUsed() == false) {
                g.setColor(Color.GRAY);
            } else if (clusters[i].getIsUsed() == true) {
                g.setColor(Color.GREEN);
            }


            g.fillRect(x, y, 47, 47);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 47, 47);
            x += 50;
        }
    }

}
