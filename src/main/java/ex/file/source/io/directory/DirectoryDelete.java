package ex.file.source.io.directory;

import java.io.File;
import java.io.IOException;

public class DirectoryDelete {

	public static void main(String[] args) throws IOException {

		FileConfig fileConfig = new FileConfig();

		File dir1 = new File(fileConfig.getPathName() + "/dir1");
		System.out.println("file.exists() : " + dir1.exists());
		boolean isDeleted = dir1.delete();
		System.out.println("directory is deleted : " + isDeleted);
		
		// 하위에 dir2 디렉토리가 존재하므로 삭제되지 않는다.
		File parent = new File(fileConfig.getPathName() + "/parent");
		System.out.println("file.exists() : " + parent.exists());
		isDeleted = parent.delete();
		System.out.println("directory is deleted : " + isDeleted);
		
		File dir2 = new File(fileConfig.getPathName() + "/parent/dir2");
		System.out.println("file.exists() : " + dir2.exists());
		isDeleted = dir2.delete();
		System.out.println("directory is deleted : " + isDeleted);
	}
	
}
