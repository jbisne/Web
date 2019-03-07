package com.study.jsp;

//짱중요한 파트다.
//1.DTO에 데이터 다 떄려넣기 2.DAO 만들기 
//3.DAO,DTO쓰이는 memberSelect 만들기 가 순서
//DAO DTO 는 항상같이쓰인다.

public class MemberDTO 
{
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String gender;
	
	public MemberDTO(String id, String pw, String name, String phone, String gender)
	{
		this.id = id;
		this.pw = pw;
		this.name =name;
		this.phone = phone;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}

