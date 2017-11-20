package ex.file.source.quiz.donotcall.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import ex.file.source.quiz.donotcall.config.FileConfig;
import ex.file.source.quiz.donotcall.domain.DoNotCall;
import ex.file.source.quiz.donotcall.util.FileUtil;
import org.apache.log4j.Logger;


public class DoNotCallReader {
	
	private static final String DEFAULT_ENCODE_STR = "UTF-8";
	private static Logger logger = Logger.getLogger(DoNotCallReader.class);

	private String pathName; 
	private String fileName; 
	
	public DoNotCallReader(FileConfig fileConfig) {
		//
		this.pathName = fileConfig.getPathName(); 
		this.fileName = fileConfig.getFileName(); 
	}
	
	public BufferedReader readFile() {
		//
		return readFile(DEFAULT_ENCODE_STR);
	}

	public BufferedReader readFile(String encodeStr) {
		//
		try {
			File file = FileUtil.readFile(this.pathName, this.fileName);
			FileInputStream fis = new FileInputStream(file);
			return new BufferedReader(new InputStreamReader(fis, Charset.forName(encodeStr)));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public List<DoNotCall> readContents(BufferedReader reader) {
		//
		List<DoNotCall> results = new ArrayList<DoNotCall>();
		
		int count = 0;
		try {
			String line = null;
			while (true) {
				if ((line = reader.readLine()) == null) {
					break;
				}
				count++;
				DoNotCall donotcall = new DoNotCall(line);
				results.add(donotcall);
				logger.info(donotcall);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		logger.info("DoNotCall count --> " + count);
		
		return results;
	}
	
}
