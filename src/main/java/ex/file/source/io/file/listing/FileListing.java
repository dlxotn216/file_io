package ex.file.source.io.file.listing;

import java.io.File;
import java.io.IOException;

public class FileListing {

	public static void main(String[] args) throws IOException {

		FileConfig fileConfig = new FileConfig();

		File directory = new File(fileConfig.getPathName());
		System.out.println("file.isDirectory() : " + directory.isDirectory());

		for (File file: directory.listFiles()) {
			System.out.println((file.isFile() ? "[F] " : "[D] ") + file.getName());
		}
	}
}
