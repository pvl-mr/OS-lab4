package com.company;

import java.util.ArrayList;

public class FileManager {

   private DiskPartition diskPartition;
   private Directory dir;

   public FileManager(DiskPartition diskPartition) {
       this.diskPartition = diskPartition;
   }

    public void allocateClustersForFile(File file, int numOfClusters) {

        if (diskPartition.getFreeClusters().size() < numOfClusters) {
            System.out.println("Недостаточно места для размещения файла на дисковом разделе");
            return;
        }
        ArrayList<Cluster> clusters = diskPartition.getFreeClusters();
        Cluster head = clusters.get(0);
        file.setFirstCluster(clusters.get(0));
        head.setIsUsed(true);

        head.next = null;
        Cluster last = head;
        for (int i = 1; i < numOfClusters-1; i++) {
            while (last.next != null) {
                last = last.next;
            }
            last.next = clusters.get(i);
            clusters.get(i).setIsUsed(true);
        }

    }

    public void allocateClustersForDirectory(Directory directory) {
        int numOfClusters = 1;
        if (diskPartition.getFreeClusters().size() < numOfClusters) {
            System.out.println("Недостаточно места для размещения файла на дисковом разделе");
            return;
        }
        directory.setCluster(diskPartition.getFreeClusters().get(0));
        diskPartition.getFreeClusters().get(0).setIsUsed(true);
    }

    public File createFile(String fileName, Directory directory) {
        File newFile = new File(fileName);
        directory.add(newFile);
        dir.add(newFile);
        int numOfClusters = (int)(Math.random()*5)+1;
        allocateClustersForFile(newFile, numOfClusters);
        return newFile;
    }

    public Directory createDirectory(String directoryName, Directory directory) {
        Directory newDirectory = new Directory(directoryName);
        allocateClustersForDirectory(newDirectory);
        dir.add(newDirectory);
        return newDirectory;
    }

    public void deleteFile(File file) {
        for (int i = 0; i < file.getClusters().size(); i++) {
            file.getClusters().get(i).setIsUsed(false);
        }
    }

    public void deleteDirectory(Directory directory) {
        directory.getCluster().setIsUsed(false);
    }

    public Directory getFullDirectory() {
       return dir;
    }




}
