package com.chaminda.validation.entity;

import java.util.Date;

public class Person {

    private Long id;

    private String firstName;

    private String lastName;

    private String homeAddress;

    private String officeAddress;

    private Date dateOfBirth;

    private String driversLicenceNo;

    public Person(PersonBuilder personBuilder) {
        this.id = personBuilder.id;
        this.firstName = personBuilder.firstName;
        this.lastName = personBuilder.lastName;
        this.dateOfBirth = personBuilder.dateOfBirth;
        this.homeAddress = personBuilder.homeAddress;
        this.officeAddress = personBuilder.officeAddress;
        this.driversLicenceNo = personBuilder.driversLicenceNo;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDriversLicenceNo() {
        return driversLicenceNo;
    }

    public static class PersonBuilder{

        private Long id;

        private String firstName;

        private String lastName;

        private String homeAddress;

        private String officeAddress;

        private Date dateOfBirth;

        private String driversLicenceNo;

        public Person build(){
            return new Person(this);
        }

        public PersonBuilder withId(Long id){
            this.id = id;
            return this;
        }

        public PersonBuilder withFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder withHomeAddress(String homeAddress){
            this.homeAddress = homeAddress;
            return this;
        }

        public PersonBuilder withOfficeAddress(String officeAddress){
            this.officeAddress = officeAddress;
            return this;
        }

        public PersonBuilder withDateOfBirth(Date dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public PersonBuilder withDriversLicenceNo(String driversLicenceNo){
            this.driversLicenceNo = driversLicenceNo;
            return this;
        }

    }
}
