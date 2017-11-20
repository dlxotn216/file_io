package ex.file.source.io.standard;

import java.io.IOException;

public class UseSystem {

	public static void main(String[] args) {
		//
		try {
			byteToString();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void byteToString() throws IOException {
		//
		byte[] bytes = new byte[16];
		System.out.print("입력하세요 ->");
		System.in.read(bytes);
		
		String value = new String(bytes);
		
		System.out.println("입력한 내용은 '" + value + "' 입니다.");
	}
	
}
