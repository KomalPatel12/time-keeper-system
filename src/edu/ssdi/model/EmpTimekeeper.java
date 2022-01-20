/****************************Author : Akanksha Gupta ****************************************/
package edu.ssdi.model;

public class EmpTimekeeper {
	Integer empId;
	String timeIn,timeOut,tkDate, duration;
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}
	public String getTkDate() {
		return tkDate;
	}
	public void setTkDate(String tkDate) {
		this.tkDate = tkDate;
	}
}