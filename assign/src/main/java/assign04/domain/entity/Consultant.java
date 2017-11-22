package assign04.domain.entity;

public class Consultant {

	private long id;
	
	private String name;
	
	private int assignLimit;
	
	public Consultant(long id, String name, int assignLimit) {
		//
		this.id = id;
		this.name = name;
		this.assignLimit = assignLimit;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public int getAssignLimit() {
		return assignLimit;
	}

	@Override
	public String toString() {
		//
		return id + "/" + name;
	}
	
}
