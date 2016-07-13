package com.chaminda.validation;


import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSpecification<E> implements Specification<E> {

    List<Specification<E>> specifications = new ArrayList<>();

    @Override
    public Response validate(E entity) {
        final List<Response> validationResponses = new ArrayList<>();

        specifications.stream().parallel().forEach(spec -> {
            Response response = spec.validate(entity);

            if(!response.isValid()){
                validationResponses.add(response);
            }
        });

        return processResponses(validationResponses);
    }

    public abstract Response processResponses(List<Response> validationResponses) ;
}
