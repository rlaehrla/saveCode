package com.momo.dto;

public class Job {
	private String job_Code;
	private String job_Name;
	
	@Override
	public String toString() {
		return job_Name + "/" + job_Code;
	}

	public String getJob_Code() {
		return job_Code;
	}

	public void setJob_Code(String job_Code) {
		this.job_Code = job_Code;
	}

	public String getJob_Name() {
		return job_Name;
	}

	public void setJob_Name(String job_Name) {
		this.job_Name = job_Name;
	}
	

	
}
