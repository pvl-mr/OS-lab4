package com.company;

public class Cluster {

    private int numInDiskPartition = -1;
    private boolean isUsed;
    public String data;
    public Cluster next;

    public Cluster() {
        next = null;
        isUsed = false;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }


}
