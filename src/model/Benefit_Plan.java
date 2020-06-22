package model;

public class Benefit_Plan {
	private int benefit_Plan_Id;
	private String plan_Name;
	private int deductable;
	private int percentage_Copay;
	public Benefit_Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Benefit_Plan(int benefit_Plan_Id, String plan_Name, int deductable, int percentage_Copay) {
		super();
		this.benefit_Plan_Id = benefit_Plan_Id;
		this.plan_Name = plan_Name;
		this.deductable = deductable;
		this.percentage_Copay = percentage_Copay;
	}
	public int getBenefit_Plan_Id() {
		return benefit_Plan_Id;
	}
	public void setBenefit_Plan_Id(int benefit_Plan_Id) {
		this.benefit_Plan_Id = benefit_Plan_Id;
	}
	public String getPlan_Name() {
		return plan_Name;
	}
	public void setPlan_Name(String plan_Name) {
		this.plan_Name = plan_Name;
	}
	public int getDeductable() {
		return deductable;
	}
	public void setDeductable(int deductable) {
		this.deductable = deductable;
	}
	public int getPercentage_Copay() {
		return percentage_Copay;
	}
	public void setPercentage_Copay(int percentage_Copay) {
		this.percentage_Copay = percentage_Copay;
	}
	
}
