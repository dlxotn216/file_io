package ex.file.day01;

import java.io.*;

public class Step04_FileCreateAndDelete {
    public static void main(String[] args) {
        System.out.println("User directory : " + System.getProperty("user.dir"));

        File file = new File("sample.txt");
        System.out.println(file.getName());

        try {
            boolean isCreated = file.createNewFile();
            if (!isCreated) {
                if(!file.exists()){
                    throw new FileNotFoundException();
                }
            }
            boolean isDeleted = file.delete();
            if (!isDeleted) {
                System.out.println("삭제된 결과가 없음");
            } else {
                System.out.println("삭제 완료");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
