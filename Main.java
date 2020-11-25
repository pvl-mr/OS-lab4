package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Window window = new Window();
        window.frame.setVisible(true);

        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();


        FileManager manager = new FileManager(new DiskPartition(64, 8));

        if (input.equals("createFile")) {
            String fileName = scanner.next();
            File file = manager.createFile(fileName, new Directory("someDirectory"));
            window.frame.repaint();
        }
        if (input.equals("createDirectory")) {
            String directoryName = scanner.next();
            Directory directory = manager.createDirectory(directoryName, new Directory("someDirectory"));
            window.frame.repaint();
        }
        if (input.equals("deleteDirectory")) {
            String directoryName = scanner.next();
            manager.deleteDirectory(directoryName);
            window.frame.repaint();
        }
        if (input.equals("deleteFile")) {
            String fileName = scanner.next();
            manager.deleteFile(fileName);
            window.frame.repaint();
        }



    }
}
