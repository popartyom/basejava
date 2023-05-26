package com.urise.webapp;

import java.io.*;

/**
 * @author Artyom Popov
 */
public class MainFile {
    public static void main(String[] args) {
        String filePath = ".\\.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("./src/com/urise/webapp");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name: list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)){
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        printDirectoryDeeply(dir, 0);
    }

    public static void printDirectoryDeeply(File dir, int tabCounter) {
        File[] files = dir.listFiles();

        String tabStr = "";
        for (int i = 0; i < tabCounter; i++) {
            tabStr+= "\t";
        }
        if (files != null) {
            tabCounter++;
            tabStr+= "\t";
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(tabStr + "File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(tabStr + "Directory: " + file.getName());
                    printDirectoryDeeply(file, tabCounter);
                }
            }
        }
    }
}
