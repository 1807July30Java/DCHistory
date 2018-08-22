package com.revature.service;

public class Character {
	private String name;
	private String age;
	private String powers;
	private String gender;
	
	public Character(String name, String age, String powers, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.powers = powers;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPowers() {
		return powers;
	}

	public void setPowers(String powers) {
		this.powers = powers;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
