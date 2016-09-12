package Lesson5;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ReadReplaceFile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input your file with directory: ");
        String file = sc.nextLine();
        System.out.println("Input String for replacement: ");
        String oldStr = sc.nextLine();
        System.out.println("Input new String: ");
        String newStr = sc.nextLine();

        try {
            rplcStrFile(file, oldStr, newStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public static void rplcStrFile(String file, String oldStr, String newStr) throws IOException {
    RandomAccessFile raf = null;
    try {
        raf = new RandomAccessFile(file, "rw");
        byte[] buf = new byte[(int) raf.length()];
        raf.read(buf);
        String s = new String(buf).replace(oldStr, newStr);
        raf.setLength(s.length());
        buf = new byte[s.length()];
        buf = s.getBytes();
        raf.seek(0);
        raf.write(buf);
    } finally {
        raf.close();
    }
}
}