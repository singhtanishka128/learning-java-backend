package com.tight.coupling;

public class TightCouplingExample {
    public static void main() {
        UserManager userManager = new UserManager();
        System.out.println(userManager.getUserInfo());
    }
}
