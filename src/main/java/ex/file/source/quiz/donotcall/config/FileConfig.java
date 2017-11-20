package ex.file.source.quiz.donotcall.config;

/**
 * @author namoosori
 *
 */
public class FileConfig {
	//
	private String pathName; 
	private String fileName;
	
	/**
	 * 
	 */
	public FileConfig() {
		//
		this.pathName = "./src/main/resources/quiz/donotcall";
		this.fileName = "donotcall.dat";
	}
	
	@Override
	public String toString() {
		//
		return this.pathName + "/" + this.fileName;
	}

	public String getPathName() {
		return pathName;
	}

	public String getFileName() {
		return fileName;
	}
	
}