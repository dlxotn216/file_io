package ex.file.source.io.serialize;

import ex.file.source.io.serialize.domain.Club;
import ex.file.source.io.serialize.domain.Member;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Serializer {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//
		Club club = new Club("JavaStudy");
		Member member = new Member("Harold", club);

		String filename = FileConfig.getPathName() + "/object.out";

		// save object to file 
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
		oos.writeObject(member);

		oos.close();
	}
}
