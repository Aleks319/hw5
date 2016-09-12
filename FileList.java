package Lesson5;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class FileList {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input directory: ");

        String path = sc.nextLine();

        listFiles(path);


    }

    static void listFiles(String path) throws IOException {
        File list[] = new File(path).listFiles();
        FileOutputStream out = new FileOutputStream(new File(path + "\\" + "FilesInfo.txt"));
    try {
        for (int i = 0; i < list.length; i++) {
            BasicFileAttributes bfa = Files.readAttributes(list[i].toPath(), BasicFileAttributes.class);
            String name = null;
            if (list[i].isFile()) {
                name = "File " + list[i].getName() + " :\n";
            } else {
                name = "Directory " + list[i].getName() + " :\n";
            }
            String create = "Date of creation: " + (new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SS").format(bfa.creationTime().to(MILLISECONDS))) + "\n";
            String modify = "Date of last modification: " + (new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SS").format(bfa.lastModifiedTime().to(MILLISECONDS))) + "\n";
            String str = "\n ******************************** \n";
            out.write((name + create + modify + str).getBytes());
        }
    } finally {
            out.close();
        }
    }
}