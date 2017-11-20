package ex.file.source.io.stream.reader;

import ex.file.source.io.stream.FileConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


@SuppressWarnings("resource")
public class BufferedTextPrinter {

	public static void main(String[] args) throws IOException {

		System.out.print("Enter text filename : ");
		String filename = new Scanner(System.in).nextLine();

		FileConfig fileConfig = new FileConfig();
		BufferedReader reader = new BufferedReader(new FileReader(fileConfig.getPathName() + "/" + filename));
		String readLine = null;
		while ((readLine = reader.readLine()) != null) {
			System.out.println(readLine);
		}

		reader.close();
	}
}
