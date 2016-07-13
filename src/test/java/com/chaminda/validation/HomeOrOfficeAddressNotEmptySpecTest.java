package com.chaminda.validation;


import org.junit.Test;

import com.chaminda.validation.OrSpecification;
import com.chaminda.validation.Response;
import com.chaminda.validation.Specification;
import com.chaminda.validation.entity.Person;
import com.chaminda.validation.validators.HomeAddressNotEmptySpec;
import com.chaminda.validation.validators.OfficeAddressNotEmptySpec;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeOrOfficeAddressNotEmptySpecTest {

    @Test
    public void shouldValidateGivenPersonWithHomeAddress(){
        //given
        Person testPerson = new Person.PersonBuilder()
                .withFirstName("First")
                .withLastName("Last")
                .withHomeAddress("Home address")
                .build();

        //and
        Specification<Person> officeOrHomeAddressSpec = new OrSpecification<Person>()
        .or(new OfficeAddressNotEmptySpec()).or(new HomeAddressNotEmptySpec());
        //when
        Response response = officeOrHomeAddressSpec.validate(testPerson);

        //then
        assertThat(response).isNotNull();
        assertThat(response.isValid()).isTrue();
    }

    @Test
    public void shouldValidateGivenPersonWithOfficeAddress(){
        //given
        Person testPerson = new Person.PersonBuilder()
                .withFirstName("First")
                .withLastName("Last")
                .withOfficeAddress("Office address")
                .build();

        //and
        Specification<Person> officeOrHomeAddressSpec = new OrSpecification<Person>()
        .or(new OfficeAddressNotEmptySpec()).or(new HomeAddressNotEmptySpec());
        
        //when
        Response response = officeOrHomeAddressSpec.validate(testPerson);

        //then
        assertThat(response).isNotNull();
        assertThat(response.isValid()).isTrue();
    }

    @Test
    public void shouldInvalidateGivenPersonWithNoHomeOrOfficeAddress(){
        //given
        Person testPerson = new Person.PersonBuilder()
                .withFirstName("First")
                .withLastName("Last")
                .build();

        //and
        Specification<Person> officeOrHomeAddressSpec = new OrSpecification<Person>()
                .or(new OfficeAddressNotEmptySpec()).or(new HomeAddressNotEmptySpec());
        //when
        Response response = officeOrHomeAddressSpec.validate(testPerson);

        //then
        assertThat(response).isNotNull();
        assertThat(response.isValid()).isFalse();
    }

}
