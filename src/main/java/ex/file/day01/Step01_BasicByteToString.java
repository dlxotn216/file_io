package ex.file.day01;

import java.io.IOException;

public class Step01_BasicByteToString {

    public static void main(String[] args) throws Exception {
        byteToString();
    }

    private static void byteToString() throws IOException {
        byte[] bytes = new byte[16];

        System.out.print("입력하세요 -> ");
        System.in.read(bytes);

        String value = new String(bytes);
        System.out.println("입력된 값 : " + value);
    }
}
