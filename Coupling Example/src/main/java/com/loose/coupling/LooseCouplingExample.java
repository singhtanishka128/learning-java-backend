package com.loose.coupling;
public class LooseCouplingExample {

    public static void main() {

        //implementation of interface using the object of class implemented
        UserDataProvider databaseProvider = new UserDatabaseProvider();
        UserManager userManagerWithDB = new UserManager(databaseProvider);
        System.out.println(userManagerWithDB.getUserInfo());

        UserDataProvider newdatabaseProvider = new NewDatabase();
        UserManager userManagerWithNewDB = new UserManager(newdatabaseProvider);
        System.out.println(userManagerWithNewDB.getUserInfo());

        UserDataProvider webserviceProvider = new WebService();
        UserManager userManagerWithWS = new UserManager(webserviceProvider);
        System.out.println(userManagerWithWS.getUserInfo());

    }
}
