package ex.file.source.io.file.createanddelete;

import java.io.File;
import java.io.IOException;



public class FileDelete {

	public static void main(String[] args) throws IOException {

		FileConfig fileConfig = new FileConfig();
		File file = new File(fileConfig.getCanonicalPath());

		boolean isDeleted = file.delete();
		System.out.println("file is deleted : " + isDeleted);
		System.out.println("file.exists() : " + file.exists());
	}

}
