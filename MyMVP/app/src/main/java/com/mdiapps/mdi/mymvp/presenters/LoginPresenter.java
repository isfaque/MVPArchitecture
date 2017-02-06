package com.mdiapps.mdi.mymvp.presenters;

import com.mdiapps.mdi.mymvp.R;
import com.mdiapps.mdi.mymvp.services.LoginService;
import com.mdiapps.mdi.mymvp.views.login.LoginView;

/**
 * Created by Mascot on 2/6/2017.
 */
public class LoginPresenter {
    private LoginView view;
    private LoginService service;

    public LoginPresenter(LoginView view, LoginService service) {
        this.view = view;
        this.service = service;
    }

    public void onLoginClicked() {
        String username = view.getUsername();
        if (username.isEmpty()) {
            view.showUsernameError(R.string.username_error);
            return;
        }
        String password = view.getPassword();
        if (password.isEmpty()) {
            view.showPasswordError(R.string.password_error);
            return;
        }
        boolean loginSucceeded = service.login(username, password);
        if (loginSucceeded) {
            view.startMainActivity();
            return;
        }
        view.showLoginError(R.string.login_failed);
    }
}
