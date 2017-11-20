package ex.file.source.io.stream.reader;

import ex.file.source.io.stream.FileConfig;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


@SuppressWarnings("resource")
public class TextPrinter {

	public static void main(String[] args) throws IOException {

		System.out.print("Enter text filename : ");
		String filename = new Scanner(System.in).nextLine();

		FileConfig fileConfig = new FileConfig();
		FileReader reader = new FileReader(fileConfig.getPathName() + "/" + filename);
		int ch = 0;
		while ((ch = reader.read()) != -1) {
			System.out.print((char) ch);
		}

		reader.close();
	}

}
