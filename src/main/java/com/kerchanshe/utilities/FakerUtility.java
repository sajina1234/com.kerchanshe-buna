package com.kerchanshe.utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	static Faker faker = new Faker();

	public static String getRandomName() {
		String name = faker.name().firstName();
		return name;
	}

	public static String getRandomFullName() {
		String name = faker.name().fullName();
		return name;
	}

	public static String getRandomAddress() {
		String streetAddress = faker.address().streetAddress();
		return streetAddress;
	}

	public static String getRandomLastName() {
		String lastName = faker.name().lastName();
		return lastName;
	}
	

}
