package com.fjl.bm.bean;

import java.util.Arrays;

public class Tb_bm {
	private String bmid;
	private String bmimgs;
	private String[] bmimgss;
	private String bmname;
	private int age;
	private int salary;
	private int job_time ;
	private String edu;
	private String home;
	private String job;

	public String getBmid() {
		return bmid;
	}

	public void setBmid(String bmid) {
		this.bmid = bmid;
	}

	public String getBmimgs() {
		return bmimgs;
	}

	public void setBmimgs(String bmimgs) {
		this.bmimgs = bmimgs;
	}

	public String[] getBmimgss() {
		return bmimgss;
	}

	public void setBmimgss(String[] bmimgss) {
		this.bmimgss = bmimgss;
	}

	public String getBmname() {
		return bmname;
	}

	public void setBmname(String bmname) {
		this.bmname = bmname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getJob_time() {
		return job_time;
	}

	public void setJob_time(int job_time) {
		this.job_time = job_time;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Tb_bm{" +
				"bmid='" + bmid + '\'' +
				", bmimgs='" + bmimgs + '\'' +
				", bmimgss=" + Arrays.toString(bmimgss) +
				", bmname='" + bmname + '\'' +
				", age=" + age +
				", salary=" + salary +
				", job_time=" + job_time +
				", edu='" + edu + '\'' +
				", home='" + home + '\'' +
				", job='" + job + '\'' +
				'}';
	}
}
