package com.chaminda.validation.validators;

import com.chaminda.validation.Response;
import com.chaminda.validation.Specification;
import com.chaminda.validation.ValidationMessage;
import com.chaminda.validation.ValidationResponse;
import com.chaminda.validation.entity.Person;

public class DobNotEmptyValidationSpec implements Specification<Person> {

    private static final String ERROR_CODE = "ER04";

    private static final String ERROR_MESSAGE = "Date of birth cannot be empty.";

    @Override
    public Response validate(Person person) {
        if(person.getDateOfBirth() != null){
            return ValidationResponse.valid();
        }

        return ValidationResponse.invalid(new ValidationMessage(ERROR_CODE, ERROR_MESSAGE));
    }
}
