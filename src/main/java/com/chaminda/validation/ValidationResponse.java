package com.chaminda.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ValidationResponse implements Response {

    private boolean valid;

    private final List<ValidationMessage> messages = new ArrayList<>();

    private ValidationResponse(boolean valid, List<ValidationMessage> messages) {
        this.valid = valid;
        this.messages.addAll(messages);
    }

    private ValidationResponse(boolean valid) {
        this.valid = valid;
    }

    @Override
    public boolean isValid() {
        return valid;
    }

    @Override public List<ValidationMessage> getMessages() {
        return messages;
    }

    public static Response valid() {
        return new ValidationResponse(true);
    }

    public static Response invalid(List<ValidationMessage> messages) {
        return new ValidationResponse(false, messages);
    }

    public static Response invalid(ValidationMessage message) {
        return new ValidationResponse(false, Collections.singletonList(message));
    }

}
