package Lesson5;

import java.io.*;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

public class CopyFilesInOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input directory: ");
        String path = sc.nextLine();

        System.out.println("Input name new file: ");
        String newFile = sc.nextLine();

        File[] fl = new File(path).listFiles();

        try {
            copyFiles(fl, newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFiles(File[] listFiles, String newFile) throws IOException {
        FileInputStream[] fis = new FileInputStream[listFiles.length];
        Vector<FileInputStream> vector = new Vector();

        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
                fis[i] = new FileInputStream(listFiles[i]);
                vector.add(fis[i]);
            }
        }
        Enumeration<FileInputStream> enu = vector.elements();
        SequenceInputStream sis = new SequenceInputStream(enu);
        FileOutputStream fos =new FileOutputStream(newFile);
        int i;
        while ((i = sis.read()) != -1) {
            fos.write(i);
        }
    }
}
