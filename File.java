package com.company;

public class File {

    private Cluster firstCluster;

    private String fileName;
    private INode indexNode;

    public File(String fileName) {
        indexNode = new INode(fileName);
        this.fileName = fileName;
    }

    public INode getINode() {
        return indexNode;
    }

    public void removeINode() {
        indexNode = null;
    }

    public void setFirstCluster(Cluster firstCluster) {
        this.firstCluster = firstCluster;
    }

    public Cluster getFirstCluster() {
        return firstCluster;
    }


}
