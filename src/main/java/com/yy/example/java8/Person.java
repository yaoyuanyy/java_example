package com.yy.example.java8;

public class Person{

    private String firstName;
    private String lastName;
    
    public Person(){}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public static int compareFirstNames(Person lhs, Person rhs) {
		return lhs.firstName.compareTo(rhs.firstName);
	}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
