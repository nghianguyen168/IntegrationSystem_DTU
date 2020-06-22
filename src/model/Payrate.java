package model;

public class Payrate {
	private String idEmployee;
	private int idPay_Rate;
	private String pay_Rate_Name;
	private int value;
	private int tax_Percentage;
	private int pay_Type;
	private int pay_Amount;
	private int pt_Level_C;
	public Payrate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payrate(int idPay_Rate, String pay_Rate_Name, int value, int tax_Percentage, int pay_Type, int pay_Amount,
			int pt_Level_C) {
		super();
		this.idPay_Rate = idPay_Rate;
		this.pay_Rate_Name = pay_Rate_Name;
		this.value = value;
		this.tax_Percentage = tax_Percentage;
		this.pay_Type = pay_Type;
		this.pay_Amount = pay_Amount;
		this.pt_Level_C = pt_Level_C;
	}
	
	public Payrate(String idEmployee, int idPay_Rate, String pay_Rate_Name, int value, int tax_Percentage, int pay_Type,
			int pay_Amount, int pt_Level_C) {
		super();
		this.idEmployee = idEmployee;
		this.idPay_Rate = idPay_Rate;
		this.pay_Rate_Name = pay_Rate_Name;
		this.value = value;
		this.tax_Percentage = tax_Percentage;
		this.pay_Type = pay_Type;
		this.pay_Amount = pay_Amount;
		this.pt_Level_C = pt_Level_C;
	}
	public int getIdPay_Rate() {
		return idPay_Rate;
	}
	public void setIdPay_Rate(int idPay_Rate) {
		this.idPay_Rate = idPay_Rate;
	}
	public String getPay_Rate_Name() {
		return pay_Rate_Name;
	}
	public void setPay_Rate_Name(String pay_Rate_Name) {
		this.pay_Rate_Name = pay_Rate_Name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getTax_Percentage() {
		return tax_Percentage;
	}
	public void setTax_Percentage(int tax_Percentage) {
		this.tax_Percentage = tax_Percentage;
	}
	public int getPay_Type() {
		return pay_Type;
	}
	public void setPay_Type(int pay_Type) {
		this.pay_Type = pay_Type;
	}
	public int getPay_Amount() {
		return pay_Amount;
	}
	public void setPay_Amount(int pay_Amount) {
		this.pay_Amount = pay_Amount;
	}
	public int getPt_Level_C() {
		return pt_Level_C;
	}
	public void setPt_Level_C(int pt_Level_C) {
		this.pt_Level_C = pt_Level_C;
	}
	public String getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}
	
	

}
