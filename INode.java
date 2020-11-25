package com.company;

public class INode {
    private INode next;

    private String fileName;

    private Cluster[] clusters;
    private int head = 0;

    public INode(String fileName) {
        this.fileName = fileName;
        next = null;
    }

    public void addClusters(Cluster[] newClusters) {
        INode current = this;
        while (current.next != null) {
            current = current.next;
        }
        for (int i = 0; i < newClusters.length; i++) {
            current.clusters[current.head] = newClusters[i];
            current.head++;
            //если i-узел достиг макс. размера, но остались незаписанные кластеры
            if (current.head == clusters.length) {
                current.next = new INode(fileName);
                current = current.next;
            }
        }
    }



}
