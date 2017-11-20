package ex.file.source.io.file.info;

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
		this.pathName = "./src/main/resources/io/file"; 
		this.fileName = "log4j.txt"; 
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// 
		StringBuilder builder = new StringBuilder(); 
		
		builder.append("pathName:").append(pathName); 
		builder.append(", fileName:").append(fileName); 
		
		return builder.toString(); 
	}
	
	public String getCanonicalPath() {
		return pathName + "/" + fileName;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}