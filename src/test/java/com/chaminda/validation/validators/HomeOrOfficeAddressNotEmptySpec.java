package com.chaminda.validation.validators;

import com.chaminda.validation.Response;
import com.chaminda.validation.Specification;
import com.chaminda.validation.entity.Person;


public class HomeOrOfficeAddressNotEmptySpec implements Specification<Person> {


    @Override
    public Response validate(Person entity) {
        return null;
    }
}
