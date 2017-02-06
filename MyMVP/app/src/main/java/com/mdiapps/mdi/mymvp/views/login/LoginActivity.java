package com.mdiapps.mdi.mymvp.views.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mdiapps.mdi.mymvp.presenters.LoginPresenter;
import com.mdiapps.mdi.mymvp.R;
import com.mdiapps.mdi.mymvp.services.LoginService;
import com.mdiapps.mdi.mymvp.utils.ActivityUtil;

/**
 * Created by Mascot on 2/6/2017.
 */
public class LoginActivity extends AppCompatActivity implements LoginView {
    private EditText usernameView;
    private EditText passwordView;
    private Button btn_login;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameView = (EditText) findViewById(R.id.username);
        passwordView = (EditText) findViewById(R.id.password);
        btn_login = (Button) findViewById(R.id.login);
        presenter = new LoginPresenter(this, new LoginService());

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onLoginClicked();
            }
        });
    }

    @Override
    public String getUsername() {
        return usernameView.getText().toString();
    }

    @Override
    public void showUsernameError(int resId) {
        usernameView.setError(getString(resId));
    }

    @Override
    public String getPassword() {
        return passwordView.getText().toString();
    }

    @Override
    public void showPasswordError(int resId) {
        passwordView.setError(getString(resId));
    }

    @Override
    public void startMainActivity() {
        new ActivityUtil(this).startMainActivity();
    }

    @Override
    public void showLoginError(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show();
    }
}
