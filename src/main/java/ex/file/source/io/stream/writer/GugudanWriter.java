package ex.file.source.io.stream.writer;

import ex.file.source.io.stream.FileConfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


@SuppressWarnings("resource")
public class GugudanWriter {

	public static void main(String[] args) throws FileNotFoundException {

		System.out.print("Enter number : ");
		int dan = new Scanner(System.in).nextInt();

		FileConfig fileConfig = new FileConfig();
		File output = new File(fileConfig.getPathName() + "/gugudan_" + dan + ".txt");
		PrintWriter writer = new PrintWriter(output);

		for ( int i = 1; i <= 9; i++ ) {
			writer.printf("%d * %d = %d\n", dan, i, (dan * i));
		}

		System.out.println("gugudan file saved.");
		writer.close();
	}

}
