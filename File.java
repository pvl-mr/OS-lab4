package com.company;

import java.util.ArrayList;

public class File {

    private Cluster firstCluster;

    private String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Cluster> getClusters() {
        ArrayList<Cluster> clusters = new ArrayList<Cluster>();
        Cluster current = firstCluster;
        while (current != null) {
            clusters.add(current);
            current = current.next;
        }
       return clusters;
    }

    public void setFirstCluster(Cluster firstCluster) {
        this.firstCluster = firstCluster;
    }

    public Cluster getFirstCluster() {
        return firstCluster;
    }


}
