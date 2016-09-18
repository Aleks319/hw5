package Lesson5;
import java.io.*;
import java.util.Scanner;
public class ReadReplaceFile2 {
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
        InputStream instr = null;
        OutputStream outstr = null;
        try {
            instr = new BufferedInputStream(new FileInputStream(file));
            byte[] buf = new byte[instr.available()];
            instr.read(buf);
            String str = new String(buf).replace(oldStr, newStr);
            buf = str.getBytes();
            outstr = new BufferedOutputStream(new FileOutputStream(file));
            outstr.write(buf);
        } finally {
            instr.close();
            outstr.close();
        }
    }
}