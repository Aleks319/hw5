package Lesson5.Recursion;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RecursionNew {

    private static void listAll(String path, ArrayList<String> res)
            throws IOException
    {
        File dir = new File(path);
        File[] list = dir.listFiles();

        for (File f : list) {
            if (f.isFile() && f.getName().length() > 5 && f.getName().charAt(1) == 'A') {
                res.add("F: " + f.getCanonicalPath());
            } else if (!f.isFile()) {
                if(f.getName().length() > 5 && f.getName().charAt(1) == 'A') {
                    res.add("D: " + f.getCanonicalPath());
                    listAll(f.getCanonicalPath(), res);
                } else {
                    listAll(f.getCanonicalPath(), res);
                }
            } else {
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter directory: ");
        String path = sc.nextLine();
        ArrayList<String> res = new ArrayList<String>();

        try {
            listAll(path, res);
        } catch (IOException e) {
            e.printStackTrace();
        }

      for (String s : res) {
          System.out.println(s);
      }
    }
}