package com.example.acroapp.about;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.acroapp.R;
import com.example.acroapp.base.BaseActivity;

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public static Intent getAboutIntent(Context context) {
        return new Intent(context, AboutActivity.class);
    }
}
