package ex.file.source.io.serialize.domain;

import java.io.Serializable;

public class Club implements Serializable {

	private static final long serialVersionUID = -8116980050877959072L;
	private String name;
	
	public Club(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
