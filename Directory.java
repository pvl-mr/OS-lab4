package com.company;

import java.util.ArrayList;

public class Directory{

    private String directoryName;
    private ArrayList<Object> files;
    private Cluster cluster;
    private int size = 0;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        files = new ArrayList<Object>();
    }

    public ArrayList<Object> getFiles() {
        return files;
    }

    public void add(File file) {
        files.add(file);
        size++;
    }

    public void add(Directory directory) {
        files.add(directory);
        size++;
    }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    public Cluster getCluster() {
        return cluster;
    }

}
