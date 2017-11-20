package ex.file.source.quiz.donotcall.domain;

import java.util.StringTokenizer;

public class DoNotCall {

	private String birthday;
	
	private String name;
	
	private String contactNo;
	
	public DoNotCall(String line) {
		//
		if (line != null) {
			StringTokenizer tokenizer = new StringTokenizer(line, "|"); 
			
			this.birthday = tokenizer.nextToken();  
			this.name = tokenizer.nextToken().replace(" ", "");
			this.contactNo = tokenizer.nextToken(); 
		}
	}
	
	public DoNotCall(String birthday, String name, String contactNo) {
		//
		this.birthday = birthday;
		this.name = name.replace(" ", "");
		this.contactNo = contactNo;
	}
	
	@Override
	public String toString() {
		//
		return this.birthday + "," + this.name + "," + this.contactNo;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
}
