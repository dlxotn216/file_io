package ex.file.day01;

import java.io.File;
import java.io.IOException;

public class Step03_FileMetaDisplay {
    public static void main(String[] args) throws IOException {
        System.out.println("User directory : " + System.getProperty("user.dir"));

        File file = new File("sample.txt");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalFile());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getParent());
        System.out.println(file.getParentFile());

        //canonical path-> 유일함
//        Abs path : /home/originfile
//        Can path : /home/originfile
//        Abs path : /home/symlink              -> 심볼릭 링크인 경우
//        Can path : /home/originfile
//        Abs path : /home/./././originfile
//        Can path : /home/originfile

    }
}
