package model;

public class BenefitReport {
	private int status;
	private int value;
	public BenefitReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BenefitReport(int status, int value) {
		super();
		this.status = status;
		this.value = value;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
}
