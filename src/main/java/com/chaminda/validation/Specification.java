package com.chaminda.validation;


public  interface Specification<E> {

    Response validate(E entity);

}

