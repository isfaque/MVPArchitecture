package com.mdiapps.mdi.mymvp.utils;

import android.content.Context;
import android.content.Intent;

import com.mdiapps.mdi.mymvp.views.main.MainActivity;

/**
 * Created by Mascot on 2/6/2017.
 */
public class ActivityUtil {
    private Context context;

    public ActivityUtil(Context context) {
        this.context = context;
    }

    public void startMainActivity() {
        context.startActivity(new Intent(context, MainActivity.class));
    }
}
