package ex.file.source.io.standard;

import java.util.Scanner;

public class Standard {

	public static void main(String[] args) {
		//
		System.out.println("1에서 5사이의 정수를 입력하세요.");

		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		scanner.close();

		if (0 < choice && choice <= 5) {
			System.out.println("입력한 수는 " + choice + "입니다.");
		} else {
			System.out.println("1에서 5사이의 정수만 가능합니다.");
		}
	}

}
