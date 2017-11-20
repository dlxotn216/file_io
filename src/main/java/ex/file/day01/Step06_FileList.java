package ex.file.day01;

import java.io.File;

public class Step06_FileList {
    public static void main(String[] args) {
        File file = new File("./");
        printDirectory(file, "", 1);
    }

    private static void printDirectory(File directory, String path, int depth) {
        if (directory.isFile()) {
            return;
        }

        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            return;
        }

        for (File f : files) {
            if (f.isFile()) {
                System.out.println("[F] : " + path + "/" + f.getName());
            } else {
                System.out.println("[D] : " + path + "/" + f.getName());
                printDirectory(f, path + "/" + f.getName(), depth + 1);
            }
        }
    }
}
