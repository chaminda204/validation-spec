package com.chaminda.validation.validators;


import com.chaminda.validation.Response;
import com.chaminda.validation.Specification;
import com.chaminda.validation.ValidationMessage;
import com.chaminda.validation.ValidationResponse;
import com.chaminda.validation.entity.Person;

import static com.chaminda.validation.StringUtils.isNotEmpty;


public class FirstNameNotEmptyValidationSpec implements Specification<Person> {

    private static final String ERROR_CODE = "ER02";

    private static final String ERROR_MESSAGE = "Person name cannot be empty.";

    @Override
    public Response validate(Person entity) {
        if(isNotEmpty(entity.getFirstName())){
            return ValidationResponse.valid();
        }

        return ValidationResponse.invalid(new ValidationMessage(ERROR_CODE, ERROR_MESSAGE));
    }



}
