package com.chaminda.validation;


public class ValidationMessage {

    private final String code;
    private final String description;

    public ValidationMessage(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("{%s:%s}", code, description);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other){
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        ValidationMessage that = (ValidationMessage) other;

        if (!code.equals(that.code)){
            return false;
        }
        return description.equals(that.description);

    }

    @Override
    public int hashCode() {
        int result = code.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
