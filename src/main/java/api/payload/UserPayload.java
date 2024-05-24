package api.payload;

import com.aventstack.extentreports.Status;

import api.reports.ExtentTestManager;

public class UserPayload {
	
	String username;
	String jobname;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	

}
