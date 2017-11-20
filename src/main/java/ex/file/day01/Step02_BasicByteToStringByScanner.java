package ex.file.day01;

import java.util.Scanner;

public class Step02_BasicByteToStringByScanner {
    public static void main(String[] args){
        System.out.print("1~5 사이 정수 입력 -> ");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();

        if(1 <= number && number <= 5){
            System.out.println("입력 된 정수는 "+number+"입니다.");
        } else {
            System.out.printf("1에서 5 사이 정수만 입력 가능합니다");
        }
    }
}
