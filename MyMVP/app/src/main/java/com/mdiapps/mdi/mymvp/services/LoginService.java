package com.mdiapps.mdi.mymvp.services;

/**
 * Created by Mascot on 2/6/2017.
 */
public class LoginService {
    public boolean login(String username, String password) {
        return "james".equals(username) && "bond".equals(password);
    }
}
