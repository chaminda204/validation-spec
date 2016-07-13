package com.chaminda.validation;


import java.util.List;
import java.util.stream.Collectors;

public class AndSpecification<E> extends AbstractSpecification<E> {

    @Override
    public Response processResponses(List<Response> validationResponses) {
        List<Response> validationErrors = validationResponses.stream().filter(error -> !error.isValid()).collect(Collectors.toList());

        if(validationErrors.isEmpty()){
            return ValidationResponse.valid();
        }

        return ValidationResponse.invalid(validationErrors.stream().flatMap(errorResponse -> errorResponse.getMessages().stream()).collect(Collectors.toList()));
    }

    public AndSpecification<E> and(Specification<E> specification) {
        specifications.add(specification);
        return this;
    }
}