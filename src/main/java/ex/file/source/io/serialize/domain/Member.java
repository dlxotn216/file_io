package ex.file.source.io.serialize.domain;

import java.io.Serializable;

public class Member implements Serializable {

	private static final long serialVersionUID = -4762386593719929582L;

	private String name;
	
	private Club club;
	
	public Member(String name, Club club) {
		//
		this.name = name;
		this.club = club;
	}

	public String getName() {
		return name;
	}

	public Club getClub() {
		return club;
	}
	
}
