package Lesson5.FindFiles;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

public class FindFilesNew {

    static class MyFileFilter implements FilenameFilter {
        private String ext;

        public MyFileFilter(String ext) {
            this.ext = ext;
        }

        public boolean accept(File dir, String name) {
            return name.endsWith(ext);
        }
    }

    private static void findFiles(String srcPath, String ext, ArrayList<String> list) throws IOException {
        File dir = new File(srcPath);
        File[] files = dir.listFiles(new MyFileFilter(ext));

        for (int i = 0; i < files.length; i++) {
            list.add(srcPath + "\\" + files[i].getName());
        }
    }

    private static void findFilesNew(String srcPath, String[] listext, ArrayList<String> list) throws IOException {
        File dir = new File(srcPath);

        for (String s: listext) {
            File[] files = dir.listFiles(new MyFileFilter(s));
            for (int i = 0; i < files.length; i++) {
                list.add(srcPath + "\\" + files[i].getName());
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        String[] listext = {".txt", ".doc", ".docx"};

        try {
            findFiles("D:\\new", ".txt", list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("\n" + "**************************" + "\n");

        try {
            findFilesNew("D:\\new", listext, list2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : list2) {
            System.out.println(s);
        }
    }
}