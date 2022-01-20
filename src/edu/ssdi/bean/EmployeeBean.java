/* ******************
 * 
 * 
 Author: Komal Patel
 	This class defines all the attributes of Employee Details, and used by all employee related operations.
 * 
 *
 ********************/
package edu.ssdi.bean;

public class EmployeeBean {
	
	 private int empId;
	 private String firstName;
	 private String middleName;
	 private String lastName;
	 private String birthDate;
	 private String gender;
	 private String phoneNumber;
	 private String email;
	 private String ssn;
	 private String highestEducation;
	 private String designation;
	 private String effectiveDate;
	 private String joiningDate;
	 private String joiningPosition;
	 private String employmentType;
	 private String managerId;
	 private String project;
	 private String departmentName;
	 private String newPassword;
	 private String password;
	 private String username;
	 private String roleId;
	 private String fullName;
	 
	public void setEmployeeId(int empId) {
		 this.empId = empId;
	 }
	 public int getEmployeeId() {
		 return empId;
	 }
	 
	public void setFirstName(String firstName) {
		 this.firstName = firstName;
	 }
	 public String getFirstName() {
		 return firstName;
	 }
	 
	 public void setMiddleName(String middleName) {
		 this.middleName = middleName;
	 }
	 public String getMiddleName() {
		 return middleName;
	 }
	 
	 public String getLastName() {
		 return lastName;
	}
	public void setLastName(String lastName) {
	this.lastName = lastName;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSsn() {
		return ssn;
	}
	
	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}
	public String getHighestEducation() {
		return highestEducation;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	 public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
		
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	public String getJoiningPosition() {
		return joiningPosition;
	}
	public void setJoiningPosition(String joiningPosition) {
		this.joiningPosition = joiningPosition;
	}
	
	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
