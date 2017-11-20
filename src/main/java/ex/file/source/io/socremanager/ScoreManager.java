package ex.file.source.io.socremanager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ScoreManager {

	private Scanner scanner;

	public static void main(String[] args) throws IOException {
		//
		ScoreManager scoreManager = new ScoreManager();
		scoreManager.launch();
	}

	private void launch() throws IOException {
		this.scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Select menu");
			System.out.println("1. Register score");
			System.out.println("2. Retrieve score");
			System.out.println("3. Exit");
			System.out.print(">> ");
			String selectNum = scanner.nextLine();
			if ("3".equals(selectNum)) {
				break;
			} else {
				if ("1".equals(selectNum)) {
					doRegister();
				} else if ("2".equals(selectNum)) {
					doRetrieve();
				} else {
					System.out.println("Unknown menu. Please retry.");
				}
			}
		}
	}

	private void doRegister() throws IOException {
		System.out.print("Student number : ");
		String studentNo = scanner.nextLine();

		System.out.print("Grade : ");
		String grade = scanner.nextLine();

		System.out.print("Score : ");
		String score = scanner.nextLine();

		System.out.print("Rank : ");
		String rank = scanner.nextLine();

		File dataFile = new File(FileConfig.getPathName() + "/record_" + studentNo +".dat");
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(dataFile));

		dos.writeInt(Integer.parseInt(studentNo));
		dos.writeChar(grade.charAt(0));
		dos.writeFloat(Float.parseFloat(score));
		dos.writeShort(Short.parseShort(rank));

		System.out.println("saved...");
		dos.close();
	}



	private void doRetrieve() throws IOException {
		System.out.print("Enter student number : ");
		String number = scanner.nextLine();

		File dataFile = new File(FileConfig.getPathName() + "/record_" + number +".dat");
		if (!dataFile.exists()) {
			System.out.println("Data file not found.");
			return;
		}

		DataInputStream dis = new DataInputStream(new FileInputStream(dataFile));

		int studentNo = dis.readInt();
		char grade = dis.readChar();
		float score = dis.readFloat();
		short rank = dis.readShort();

		System.out.println("- StudentNo : " + studentNo);
		System.out.println("- Grade     : " + grade);
		System.out.println("- Score     : " + score);
		System.out.println("- Rank      : " + rank);

		dis.close();
	}
}
