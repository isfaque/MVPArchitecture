package com.mdiapps.mdi.mymvp.views.login;

/**
 * Created by Mascot on 2/6/2017.
 */
public interface LoginView {
    String getUsername();

    void showUsernameError(int resId);

    String getPassword();

    void showPasswordError(int resId);

    void startMainActivity();

    void showLoginError(int resId);
}
