/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 6. 10.
 */

package ex.file.source.quiz.donotcall.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.file.NoSuchFileException;
import java.util.StringTokenizer;

import javax.naming.InvalidNameException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class FileUtil {
	//
	static Logger logger = Logger.getLogger(FileUtil.class);
	private static final String fileSeparator = System.getProperty("file.separator");

	private static String getFullPathName(String pathName) throws IOException, InvalidNameException {
		//
		StringTokenizer tokenizer = null;
		StringBuilder pathBuilder = new StringBuilder();

		if (pathName.startsWith("..")) {
			String cannonicalPath = (new File("..")).getCanonicalPath();
			pathBuilder.append(cannonicalPath).append(fileSeparator);
			pathName = pathName.substring(3); // remove "../"
		} else if (pathName.startsWith(".")) {
			String cannonicalPath = (new File(".")).getCanonicalPath();
			pathBuilder.append(cannonicalPath).append(fileSeparator);
			pathName = pathName.substring(2); // remove "./"
		}

		if (pathName.contains("/")) {
			if (pathName.startsWith("/")) {
				pathBuilder.append(fileSeparator);
			}
			tokenizer = new StringTokenizer(pathName, "/");
		} else if (pathName.contains("\\")) {
			tokenizer = new StringTokenizer(pathName, "\\");
		} else {
			throw new InvalidNameException(pathName);
		}

		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			pathBuilder.append(token).append(fileSeparator);
		}

		return pathBuilder.toString();
	}

	public static File createFile(String pathName, String fileName) {
		//
		File newFile = null;

		try {
			StringBuilder builder = new StringBuilder();
			builder.append(getFullPathName(pathName));
			builder.append(fileName);

			String fullFileName = builder.toString();
			newFile = new File(fullFileName);

			if (!newFile.exists()) {
				newFile.createNewFile();
			}
		} catch (InvalidNameException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return newFile;
	}

	public static RandomAccessFile writeRandomFile(String pathName, String fileName) {
		//
		RandomAccessFile randomFile = null;

		try {
			StringBuilder builder = new StringBuilder();
			builder.append(getFullPathName(pathName));
			builder.append(fileName);

			String fullFileName = builder.toString();
			randomFile = new RandomAccessFile(fullFileName, "rw");
		} catch (InvalidNameException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return randomFile;
	}

	public static RandomAccessFile readRandomFile(String pathName, String fileName) {
		//
		RandomAccessFile randomFile = null;
		try {
			StringBuilder builder = new StringBuilder();
			builder.append(getFullPathName(pathName));
			builder.append(fileName);

			String fullFileName = builder.toString();
			randomFile = new RandomAccessFile(fullFileName, "r");
		} catch (FileNotFoundException e) {
			// do nothing, random file object is null;
		} catch (InvalidNameException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (randomFile == null) {
			logger.debug("Fail to create file : " + fileName); 
		}
		
		return randomFile;
	}

	public static File readFile(String pathName, String fileName) {
		//
		File newFile = null;

		try {
			StringBuilder builder = new StringBuilder();
			builder.append(getFullPathName(pathName));
			builder.append(fileName);

			String fullFileName = builder.toString();
			newFile = new File(fullFileName);

			if (!newFile.exists()) {
				throw new NoSuchFileException(fullFileName);
			}

		} catch (InvalidNameException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return newFile;
	}

	public static void renameFile(String pathName, String sourceFileName, String targetFileName) {
		//
		File sourceFile = readFile(pathName, sourceFileName); 
		File targetFile = createFile(pathName, targetFileName); 
		sourceFile.renameTo(targetFile); 
	}

	public static File copyFile(String pathName, String sourceFileName, String targetFileName) {
		//
		File targetFile = null; 
		try {
			File sourceFile = readFile(pathName, sourceFileName); 
			targetFile = createFile(pathName, targetFileName);
			InputStream inputStream = new FileInputStream(sourceFile);
			OutputStream outputStream = new FileOutputStream(targetFile);

			int length = 0; 
			byte[] buffer = new byte[1024];
			
			while ((length = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, length);
			}

			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return targetFile; 
	}

	public static void main(String[] args) throws IOException, InvalidNameException {
		//
		PropertyConfigurator.configure("log4j.properties");
		File file = readFile("./src/main/resources", "ZipCodeSeoul(Unicode).txt");
		logger.debug("file size --> " + file.getTotalSpace());

		checkPath();
	}

	private static void checkPath() throws IOException, InvalidNameException {
		//
		System.out.println(getFullPathName("/hello/my/world"));
		System.out.println(getFullPathName("./hello/my/world"));
		System.out.println(getFullPathName("../hello/my/world"));
		System.out.println(getFullPathName("c:\\hello\\my\\world"));
		System.out.println(getFullPathName("world"));
	}
}