package ex.file.source.io.file.createanddelete;

import java.io.File;
import java.io.IOException;


public class FileCreation {

	public static void main(String[] args) throws IOException {

		FileConfig fileConfig = new FileConfig();
		File file = new File(fileConfig.getCanonicalPath());

		boolean isCreated = file.createNewFile();
		System.out.println("new file is created : " + isCreated);
		System.out.println("file.exists() : " + file.exists());
	}

}
