package Lesson5;
import java.io.*;
import java.util.Scanner;

public class CopyFiles {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input directory: ");

        String path = sc.nextLine();

        System.out.println("Input new directory: ");
        String newpath = sc.nextLine();

        copyFiles(path, newpath);

    }

    static void copyFiles(String path, String newpath) throws IOException {
        File list[] = new File(path).listFiles();
        InputStream in = null;
        OutputStream out = null;

        for (int i = 0; i< list.length; i++) {
            if(list[i].isFile()) {
                in = new FileInputStream(list[i].getCanonicalFile());
                try {
                    out = new FileOutputStream(newpath + "\\" + list[i].getName());
                    try {
                        byte[] buf = new byte[1024];
                        int r;
                        do {
                            r = in.read(buf, 0, buf.length);
                            if (r > 0)
                                out.write(buf, 0, r);
                        } while (r > 0);
                    } finally {
                        out.close();
                    }
                } finally {
                    in.close();
                }
            }
        }
    }
}