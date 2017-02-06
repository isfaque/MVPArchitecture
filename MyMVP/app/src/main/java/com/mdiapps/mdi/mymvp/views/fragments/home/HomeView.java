package com.mdiapps.mdi.mymvp.views.fragments.home;

/**
 * Created by Mascot on 2/6/2017.
 */
public interface HomeView {
    String getUsername();

    void showUsernameError(int resId);

    String getPassword();

    void showPasswordError(int resId);

    void startContactFragment();

    void showLoginError(int resId);
}
