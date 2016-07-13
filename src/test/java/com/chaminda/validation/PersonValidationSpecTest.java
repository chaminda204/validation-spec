package com.chaminda.validation;


import org.junit.Test;

import com.chaminda.validation.AndSpecification;
import com.chaminda.validation.OrSpecification;
import com.chaminda.validation.Response;
import com.chaminda.validation.Specification;
import com.chaminda.validation.ValidationMessage;
import com.chaminda.validation.entity.Person;
import com.chaminda.validation.validators.*;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonValidationSpecTest {

    @Test
    public void shouldValidateGivenValidPerson(){
        //given
        Person testPerson = new Person.PersonBuilder()
                .withFirstName("First")
                .withLastName("Last")
                .withDateOfBirth(new Date())
                .build();

        //and
        Specification<Person> personPersonValidationSpec = new AndSpecification<Person>()
                .and(new FirstNameNotEmptyValidationSpec())
                .and(new LastNameNotEmptyValidationSpec())
                .and(new DobNotEmptyValidationSpec());

        //when
        Response response = personPersonValidationSpec.validate(testPerson);

        //then
        assertThat(response).isNotNull();
        assertThat(response.isValid()).isTrue();

    }

    @Test
    public void shouldInvalidatePersonWithEmptyFirstName(){
        //given
        Person testPerson = new Person.PersonBuilder()
                .withFirstName("")
                .withLastName("Last")
                .withDateOfBirth(new Date())
                .build();

        //and
        Specification<Person> personPersonValidationSpec = new AndSpecification<Person>()
                .and(new FirstNameNotEmptyValidationSpec())
                .and(new LastNameNotEmptyValidationSpec())
                .and(new DobNotEmptyValidationSpec());

        //when
        Response response = personPersonValidationSpec.validate(testPerson);

        //then
        assertThat(response).isNotNull();
        assertThat(response.isValid()).isFalse();

    }

    @Test
    public void shouldValidatePersonWithValidData(){
        //given
        Person testPerson = new Person.PersonBuilder()
                .withFirstName("First")
                .withLastName("Last")
                .withHomeAddress("Home Address")
                .withDateOfBirth(new Date())
                .build();

        //and
        Specification<Person> personPersonValidationSpec = new AndSpecification<Person>()
                .and(new FirstNameNotEmptyValidationSpec())
                .and(new LastNameNotEmptyValidationSpec())
                .and(new DobNotEmptyValidationSpec())
                .and(new OrSpecification<Person>()
                        .or(new OfficeAddressNotEmptySpec())
                        .or(new HomeAddressNotEmptySpec()
                        )
                );

        //when
        Response response = personPersonValidationSpec.validate(testPerson);

        //then
        assertThat(response).isNotNull();
        assertThat(response.isValid()).isTrue();

    }

    @Test
    public void shouldInvalidatePersonWithNoOfficeOrHomeAddress(){
        //given
        Person testPerson = new Person.PersonBuilder()
                .withFirstName("First")
                .withLastName("Last")
                .withHomeAddress("")
                .withDateOfBirth(new Date())
                .build();

        //and
        Specification<Person> personPersonValidationSpec = new AndSpecification<Person>()
                .and(new FirstNameNotEmptyValidationSpec())
                .and(new LastNameNotEmptyValidationSpec())
                .and(new DobNotEmptyValidationSpec())
                .and(new OrSpecification<Person>()
                        .or(new OfficeAddressNotEmptySpec())
                        .or(new HomeAddressNotEmptySpec()
                        )
                );


        //when
        Response response = personPersonValidationSpec.validate(testPerson);

        //then
        assertThat(response).isNotNull();
        assertThat(response.isValid()).isFalse();
        assertThat(response.getMessages().contains(new ValidationMessage("ER05", "Home address should not be empty."))).isTrue();
        assertThat(response.getMessages().contains(new ValidationMessage("ER06", "Office address should not be empty."))).isTrue();
    }

    @Test
    public void shouldInvalidatePersonWithInvalidSpec(){
        //given
        Person testPerson = new Person.PersonBuilder()
                .withFirstName("First")
                .withLastName("Last")
                .withHomeAddress("Home Address")
                .withDateOfBirth(new Date())
                .build();

        //and
        Specification<Person> personPersonValidationSpec = new AndSpecification<Person>()
                .and(new FirstNameNotEmptyValidationSpec())
                .and(new LastNameNotEmptyValidationSpec())
                .and(new DobNotEmptyValidationSpec())
                .and(new OrSpecification<Person>()
                        .or(new HomeAddressNotEmptySpec())
                        .or(new OfficeAddressNotEmptySpec())
                        )
                .and(new AlwaysInvalidValidationSpec());

        //when
        Response response = personPersonValidationSpec.validate(testPerson);

        //then
        assertThat(response).isNotNull();
        assertThat(response.isValid()).isFalse();
        assertThat(response.getMessages().contains(new ValidationMessage("ER03", "Always Invalid"))).isTrue();
    }
}
