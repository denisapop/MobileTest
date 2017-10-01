package com.popescu.mobiletest.model;

/**
 * Created by atnm-4 on 30/09/2017.
 */

public class UserProfileInfo {

    private String field;
    private String value;

    public UserProfileInfo(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
