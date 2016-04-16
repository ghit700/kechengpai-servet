package com.kechengpai.bean;

/**
 * Created by Administrator on 2016/4/15.
 */
public class Student extends User{
    public Student(String account, String password, String school, String name,
			int type) {
		super(account, password, school, name, type);
		// TODO Auto-generated constructor stub
	}

	private int s_id;
   
    private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	


    
    

  
}
