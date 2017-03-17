package com.sdajava.ProjectCompany;

import java.io.Serializable;

public class Employee implements Serializable {

    private String name;
    private String lastName;
    private char gender;
    private int depNumber;
    private float salary;
    private int age;
    private int childNumber;
    private boolean marital;

    public void salaryRise(float rise){
        float a = 0;
        if (getMarital() == true){
            a = (float) (getSalary() * 0.03);
        }
        this.salary = this.salary * (1 + rise) + (float)(this.salary * 0.02 * getChildNumber()) + a;
    }

    public boolean salaryCheck(float threshold){
        return (getSalary() > threshold);
    }

    public void shortShow() {
        System.out.println("Name=" + getName() + " ,LastName=" + getLastName() + " ,Salary=" + getSalary());
    }

    public void showSpecial(){
        System.out.println("Name=" + getName().toUpperCase() + " ,LastName=" + getLastName().toUpperCase());
    }

    @Override
    public String toString() {
        String a; String b;
        if(getGender() == 'M')
            a = "Male";
        else
            a = "Female";

        if(getMarital() == true)
            b = "Married";
        else
            b = "Not Married";

        return "Employee [name=" + name + ", lastName=" + lastName + ", gender=" + a + ", depNumber=" + depNumber
                + ", salary=" + salary + ", age=" + age + ", childNumber=" + childNumber + ", marital=" + b + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getDepNumber() {
        return depNumber;
    }

    public void setDepNumber(int depNumber) {
        this.depNumber = depNumber;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getChildNumber() {
        return childNumber;
    }

    public void setChildNumber(int childNumber) {
        this.childNumber = childNumber;
    }

    public boolean getMarital() {
        return marital;
    }

    public void setMarital(boolean marital) {
        this.marital = marital;
    }



}
