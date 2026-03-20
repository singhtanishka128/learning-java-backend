package com.loose.coupling;

public class NewDatabase implements UserDataProvider{
    @Override
    public String getUserDetails() {
        return "new details from new database";
    }
}
