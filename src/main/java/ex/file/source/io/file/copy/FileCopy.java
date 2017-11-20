package ex.file.source.io.file.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {

		FileConfig fileConfig = new FileConfig();
		
		File sourceFile = new File(fileConfig.getPathName() + "/source.properties");
		File targetFile = new File(fileConfig.getPathName() + "/target.properties");

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(sourceFile);
			fos = new FileOutputStream(targetFile);

			byte[] buf = new byte[256];
			int readBytes = 0;
			while((readBytes = fis.read(buf)) != -1) {
				fos.write(buf, 0, readBytes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) fos.close();
				if (fis != null) fis.close();
			} catch (Exception e) {}
		}
	}

}
