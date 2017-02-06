package com.mdiapps.mdi.mymvp.views.fragments.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mdiapps.mdi.mymvp.presenters.HomePresenter;
import com.mdiapps.mdi.mymvp.R;
import com.mdiapps.mdi.mymvp.services.HomeService;
import com.mdiapps.mdi.mymvp.views.fragments.contact.ContactFragment;

/**
 * Created by Mascot on 2/6/2017.
 */
public class HomeFragment extends Fragment implements HomeView {

    private EditText usernameView;
    private EditText passwordView;
    private Button btn_login;
    private HomePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        usernameView = (EditText) v.findViewById(R.id.username);
        passwordView = (EditText) v.findViewById(R.id.password);
        btn_login = (Button) v.findViewById(R.id.login);
        presenter = new HomePresenter(this, new HomeService());

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onLoginClicked();
            }
        });

        return v;
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
    public void startContactFragment() {
        Fragment fr;
        fr = new ContactFragment();
        FragmentManager fm = getFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.main_content, fr);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void showLoginError(int resId) {
        Toast.makeText(getActivity(), getString(resId), Toast.LENGTH_SHORT).show();
    }


}
