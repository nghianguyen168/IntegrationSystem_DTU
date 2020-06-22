package model;

public class PayCondition {
	private String name;
	private int value;
	
	public PayCondition() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PayCondition(String name, int value) {
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
