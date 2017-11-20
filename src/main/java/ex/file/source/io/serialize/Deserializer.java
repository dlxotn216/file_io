package ex.file.source.io.serialize;

import ex.file.source.io.serialize.domain.Member;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Deserializer {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//
		String filename = FileConfig.getPathName() + "/object.out";

		// read object from file
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
		Member savedMember = (Member) ois.readObject();

		System.out.println("member name : " + savedMember.getName());
		System.out.println("club name   : " + savedMember.getClub().getName());

		ois.close();
	}
	
}
