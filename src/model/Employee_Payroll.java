package model;

public class Employee_Payroll {

		private String idEmployee;
		private int Employee_Number;
		private String last_Name;
		private String first_Name;
		private String midle_Name;
		private int SSN;
		private String pay_Rate;
		private int pay_Rate_idPay_Rate;
		private int vacation_Days;
		private int paid_To_Day;
		private int paid_Last_Year;
		public Employee_Payroll() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Employee_Payroll(String idEmployee, int employee_Number, String last_Name, String first_Name, int sSN,
				String pay_Rate, int pay_Rate_idPay_Rate, int vacation_Days, int paid_To_Day, int paid_Last_Year) {
			super();
			this.idEmployee = idEmployee;
			Employee_Number = employee_Number;
			this.last_Name = last_Name;
			this.first_Name = first_Name;
			SSN = sSN;
			this.pay_Rate = pay_Rate;
			this.pay_Rate_idPay_Rate = pay_Rate_idPay_Rate;
			this.vacation_Days = vacation_Days;
			this.paid_To_Day = paid_To_Day;
			this.paid_Last_Year = paid_Last_Year;
		}
		
		public Employee_Payroll(String idEmployee, int employee_Number, String last_Name, String first_Name,
				String midle_Name) {
			super();
			this.idEmployee = idEmployee;
			Employee_Number = employee_Number;
			this.last_Name = last_Name;
			this.first_Name = first_Name;
			this.midle_Name = midle_Name;
		}
		

		public String getMidle_Name() {
			return midle_Name;
		}

		public void setMidle_Name(String midle_Name) {
			this.midle_Name = midle_Name;
		}

		public String getIdEmployee() {
			return idEmployee;
		}
		public void setIdEmployee(String idEmployee) {
			this.idEmployee = idEmployee;
		}
		public int getEmployee_Number() {
			return Employee_Number;
		}
		public void setEmployee_Number(int employee_Number) {
			Employee_Number = employee_Number;
		}
		public String getLast_Name() {
			return last_Name;
		}
		public void setLast_Name(String last_Name) {
			this.last_Name = last_Name;
		}
		public String getFirst_Name() {
			return first_Name;
		}
		public void setFirst_Name(String first_Name) {
			this.first_Name = first_Name;
		}
		public int getSSN() {
			return SSN;
		}
		public void setSSN(int sSN) {
			SSN = sSN;
		}
		public String getPay_Rate() {
			return pay_Rate;
		}
		public void setPay_Rate(String pay_Rate) {
			this.pay_Rate = pay_Rate;
		}
		public int getPay_Rate_idPay_Rate() {
			return pay_Rate_idPay_Rate;
		}
		public void setPay_Rate_idPay_Rate(int pay_Rate_idPay_Rate) {
			this.pay_Rate_idPay_Rate = pay_Rate_idPay_Rate;
		}
		public int getVacation_Days() {
			return vacation_Days;
		}
		public void setVacation_Days(int vacation_Days) {
			this.vacation_Days = vacation_Days;
		}
		public int getPaid_To_Day() {
			return paid_To_Day;
		}
		public void setPaid_To_Day(int paid_To_Day) {
			this.paid_To_Day = paid_To_Day;
		}
		public int getPaid_Last_Year() {
			return paid_Last_Year;
		}
		public void setPaid_Last_Year(int paid_Last_Year) {
			this.paid_Last_Year = paid_Last_Year;
		}
		
		
		
}
