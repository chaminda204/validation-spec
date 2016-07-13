package com.chaminda.validation.validators;

import com.chaminda.validation.Response;
import com.chaminda.validation.Specification;
import com.chaminda.validation.ValidationMessage;
import com.chaminda.validation.ValidationResponse;
import com.chaminda.validation.entity.Person;

public class AlwaysInvalidValidationSpec implements Specification<Person> {

    @Override
    public Response validate(Person entity) {
        return ValidationResponse.invalid(new ValidationMessage("ER03", "Always Invalid"));
    }
}
