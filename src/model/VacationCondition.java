package model;

public class VacationCondition {
	private String name;
	private int value;
	
	public VacationCondition() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public VacationCondition(String name, int value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	
	
}
