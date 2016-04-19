package com.kechengpai.bean;

public class Course {
	private int c_id;
	private String name;
	private String teacher;
	private String code;
	private int numbers;
	public Course(int c_id, String name, String teacher, String code,
			int numbers) {
		super();
		this.c_id = c_id;
		this.name = name;
		this.teacher = teacher;
		this.code = code;
		this.numbers = numbers;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	
	
	
	
	
}
