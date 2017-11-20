package ex.file.day01;

import java.io.File;
import java.io.IOException;

public class Step05_DirectoryControl {
    public static void main(String[] args) throws IOException {
        final String baseDir = "./";

        File file = new File(baseDir + "dir1");
        boolean isCreated = file.mkdir();
        System.out.println(isCreated);

        File file2 = new File(baseDir+"parent/dir2");
        isCreated = file2.mkdirs();
        System.out.println(isCreated);

        File file3 = new File(baseDir+"parent/dir3");
        isCreated = file3.mkdir();
        System.out.println(isCreated);

        File file4 = new File(baseDir+"aaaa/ttt");      //false
        isCreated = file4.mkdir();
        System.out.println(isCreated);
    }
}
