package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Employee {
	private String employee_ID;
	private String first_Name;
	private String lase_Name;
	private String current_Middle_Name;
	private Date birth_Day;
	private String social_Security_Number;
	private String driver_License;
	private String current_Address_1;
	private String current_Address_2;
	private String current_City;
	private String current_Country;
	private String current_Zip;
	private String current_Gender;
	private String curren_Phone_Number;
	private String current_Personal_email;
	private String  current_marital_status;
	private String ethnicity;
	private int benefit_plan_id;
	private int num_of_vacation;
	private String department;
	private Date hiringDate;
	private Benefit_Plan benefit_Plan;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String employee_ID, String first_Name, String lase_Name, String current_Middle_Name, Date birth_Day,
			String social_Security_Number, String driver_License, String current_Address_1, String current_Address_2,
			String current_City, String current_Country, String current_Zip, String current_Gender,
			String curren_Phone_Number, String current_Personal_email, String current_marital_status, String ethnicity,
			int benefit_plan_id) {
		super();
		this.employee_ID = employee_ID;
		this.first_Name = first_Name;
		this.lase_Name = lase_Name;
		this.current_Middle_Name = current_Middle_Name;
		this.birth_Day = birth_Day;
		this.social_Security_Number = social_Security_Number;
		this.driver_License = driver_License;
		this.current_Address_1 = current_Address_1;
		this.current_Address_2 = current_Address_2;
		this.current_City = current_City;
		this.current_Country = current_Country;
		this.current_Zip = current_Zip;
		this.current_Gender = current_Gender;
		this.curren_Phone_Number = curren_Phone_Number;
		this.current_Personal_email = current_Personal_email;
		this.current_marital_status = current_marital_status;
		this.ethnicity = ethnicity;
		this.benefit_plan_id = benefit_plan_id;
		
	}
	
	

	
	
	public Employee(String employee_ID, String first_Name, String lase_Name, String current_Middle_Name,
			Benefit_Plan benefit_Plan) {
		super();
		this.employee_ID = employee_ID;
		this.first_Name = first_Name;
		this.lase_Name = lase_Name;
		this.current_Middle_Name = current_Middle_Name;
		this.benefit_Plan = benefit_Plan;
	}
	public Employee(String employee_ID, String first_Name, String lase_Name, String current_Middle_Name,
			String department, Date hiringDate) {
		super();
		this.employee_ID = employee_ID;
		this.first_Name = first_Name;
		this.lase_Name = lase_Name;
		this.current_Middle_Name = current_Middle_Name;
		this.department = department;
		this.hiringDate = hiringDate;
	}
	public Employee(String employee_ID, String first_Name, String lase_Name, String current_Middle_Name,
			String department,String email, Date hiringDate) {
		super();
		this.employee_ID = employee_ID;
		this.first_Name = first_Name;
		this.lase_Name = lase_Name;
		this.current_Middle_Name = current_Middle_Name;
		this.department = department;
		this.current_Personal_email=email;
		this.hiringDate = hiringDate;
	}
	public Employee(String employee_ID, String first_Name, String lase_Name, String current_Middle_Name,
			String current_Personal_email, int num_of_vacation, String department) {
		super();
		this.employee_ID = employee_ID;
		this.first_Name = first_Name;
		this.lase_Name = lase_Name;
		this.current_Middle_Name = current_Middle_Name;
		this.current_Personal_email = current_Personal_email;
		this.num_of_vacation = num_of_vacation;
		this.department = department;
	}
	public String getEmployee_ID() {
		return employee_ID;
	}
	public void setEmployee_ID(String employee_ID) {
		this.employee_ID = employee_ID;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getLase_Name() {
		return lase_Name;
	}
	public void setLase_Name(String lase_Name) {
		this.lase_Name = lase_Name;
	}
	public String getCurrent_Middle_Name() {
		return current_Middle_Name;
	}
	public void setCurrent_Middle_Name(String current_Middle_Name) {
		this.current_Middle_Name = current_Middle_Name;
	}
	public Date getBirth_Day() {
		return birth_Day;
	}
	public void setBirth_Day(Date birth_Day) {
		this.birth_Day = birth_Day;
	}
	public String getSocial_Security_Number() {
		return social_Security_Number;
	}
	public void setSocial_Security_Number(String social_Security_Number) {
		this.social_Security_Number = social_Security_Number;
	}
	public String getDriver_License() {
		return driver_License;
	}
	public void setDriver_License(String driver_License) {
		this.driver_License = driver_License;
	}
	public String getCurrent_Address_1() {
		return current_Address_1;
	}
	public void setCurrent_Address_1(String current_Address_1) {
		this.current_Address_1 = current_Address_1;
	}
	public String getCurrent_Address_2() {
		return current_Address_2;
	}
	public void setCurrent_Address_2(String current_Address_2) {
		this.current_Address_2 = current_Address_2;
	}
	public String getCurrent_City() {
		return current_City;
	}
	public void setCurrent_City(String current_City) {
		this.current_City = current_City;
	}
	public String getCurrent_Country() {
		return current_Country;
	}
	public void setCurrent_Country(String current_Country) {
		this.current_Country = current_Country;
	}
	public String getCurrent_Zip() {
		return current_Zip;
	}
	public void setCurrent_Zip(String current_Zip) {
		this.current_Zip = current_Zip;
	}
	public String getCurrent_Gender() {
		return current_Gender;
	}
	public void setCurrent_Gender(String current_Gender) {
		this.current_Gender = current_Gender;
	}
	public String getCurren_Phone_Number() {
		return curren_Phone_Number;
	}
	public void setCurren_Phone_Number(String curren_Phone_Number) {
		this.curren_Phone_Number = curren_Phone_Number;
	}
	public String getCurrent_Personal_email() {
		return current_Personal_email;
	}
	public void setCurrent_Personal_email(String current_Personal_email) {
		this.current_Personal_email = current_Personal_email;
	}
	public String getCurrent_marital_status() {
		return current_marital_status;
	}
	public void setCurrent_marital_status(String current_marital_status) {
		this.current_marital_status = current_marital_status;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public int getBenefit_plan_id() {
		return benefit_plan_id;
	}
	public void setBenefit_plan_id(int benefit_plan_id) {
		this.benefit_plan_id = benefit_plan_id;
	}
	public int getNum_of_vacation() {
		return num_of_vacation;
	}
	public void setNum_of_vacation(int num_of_vacation) {
		this.num_of_vacation = num_of_vacation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getHiringDate() {
		return hiringDate;
	}
	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}
	public Benefit_Plan getBenefit_Plan() {
		return benefit_Plan;
	}
	public void setBenefit_Plan(Benefit_Plan benefit_Plan) {
		this.benefit_Plan = benefit_Plan;
	}
	
	
	
}
