package model;

import java.util.Date;

public class Job_History {
	private int JOB_HISTORY_ID;
	private String EMPLOYMENT_ID;
	private String DEPARTMENT;
	private String DIVISION;
	private Date FROM_DATE;
	private Date THRU_DATE;
	private String JOB_TITLE;
	private String SUPERVISOR;
	private  String LOCATION;
	private String TYPE_OF_WORK;
	public Job_History() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Job_History(int jOB_HISTORY_ID, String eMPLOYMENT_ID, String dEPARTMENT, String dIVISION, Date fROM_DATE,
			Date tHRU_DATE, String jOB_TITLE, String sUPERVISOR, String lOCATION, String tYPE_OF_WORK) {
		super();
		JOB_HISTORY_ID = jOB_HISTORY_ID;
		EMPLOYMENT_ID = eMPLOYMENT_ID;
		DEPARTMENT = dEPARTMENT;
		DIVISION = dIVISION;
		FROM_DATE = fROM_DATE;
		THRU_DATE = tHRU_DATE;
		JOB_TITLE = jOB_TITLE;
		SUPERVISOR = sUPERVISOR;
		LOCATION = lOCATION;
		TYPE_OF_WORK = tYPE_OF_WORK;
	}
	public int getJOB_HISTORY_ID() {
		return JOB_HISTORY_ID;
	}
	public void setJOB_HISTORY_ID(int jOB_HISTORY_ID) {
		JOB_HISTORY_ID = jOB_HISTORY_ID;
	}
	public String getEMPLOYMENT_ID() {
		return EMPLOYMENT_ID;
	}
	public void setEMPLOYMENT_ID(String eMPLOYMENT_ID) {
		EMPLOYMENT_ID = eMPLOYMENT_ID;
	}
	public String getDEPARTMENT() {
		return DEPARTMENT;
	}
	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}
	public String getDIVISION() {
		return DIVISION;
	}
	public void setDIVISION(String dIVISION) {
		DIVISION = dIVISION;
	}
	public Date getFROM_DATE() {
		return FROM_DATE;
	}
	public void setFROM_DATE(Date fROM_DATE) {
		FROM_DATE = fROM_DATE;
	}
	public Date getTHRU_DATE() {
		return THRU_DATE;
	}
	public void setTHRU_DATE(Date tHRU_DATE) {
		THRU_DATE = tHRU_DATE;
	}
	public String getJOB_TITLE() {
		return JOB_TITLE;
	}
	public void setJOB_TITLE(String jOB_TITLE) {
		JOB_TITLE = jOB_TITLE;
	}
	public String getSUPERVISOR() {
		return SUPERVISOR;
	}
	public void setSUPERVISOR(String sUPERVISOR) {
		SUPERVISOR = sUPERVISOR;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}
	public String getTYPE_OF_WORK() {
		return TYPE_OF_WORK;
	}
	public void setTYPE_OF_WORK(String tYPE_OF_WORK) {
		TYPE_OF_WORK = tYPE_OF_WORK;
	}
	
	
}
