package com.chaminda.validation;


import java.util.List;

public interface Response {

    boolean isValid();

    List<ValidationMessage> getMessages();
}
