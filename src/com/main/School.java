package com.main;

public class School{

	private Integer id;
	private String name;
	private String address;
	private String grade;
	private String post;
	private String section;

	public School() {
	}

	public School(Integer id, String name, String address, String grade, String section) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.grade = grade;
		this.section = section;
	}

	public School(Integer id, String name, String address, String post) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.post = post;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public void showAll() {
		System.out.println("The data of Student and teacher are : ");
	}
	
}
