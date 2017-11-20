package ex.file.source.io.file.info;

import java.io.File;
import java.io.IOException;

public class FileInfoDisplay {

	public static void main(String[] args) throws IOException {
		//
		FileConfig fileConfig = new FileConfig();
		File file = new File(fileConfig.getCanonicalPath());
		
		System.out.println("getName(): " + file.getName());
		System.out.println("getParent(): " + file.getParent());
		System.out.println("getPath(): " + file.getPath());
		System.out.println("getAbsolutePath(): " + file.getAbsolutePath());
		System.out.println("getCanonicalPath(): " + file.getCanonicalPath());
		System.out.println("length(): " + file.length() + "bytes");
		System.out.println("isFile(): " + file.isFile());
		System.out.println("isDirectory(): " + file.isDirectory());
	}
	
}
