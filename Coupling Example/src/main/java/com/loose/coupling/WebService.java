package com.loose.coupling;

public class WebService implements UserDataProvider{
    @Override
    public String getUserDetails() {
        return "details comin in using web services";
    }
}
