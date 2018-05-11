package com.example.acroapp.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * BaseActivity would be the parent {@link AppCompatActivity} for all of the activities in this app.
 * This would be also the place to define common behaviors like analytics collection.
 */
public class BaseActivity extends AppCompatActivity {

    /**
     * Helper method to get the root view and facilitate the showing of {@link android.support.design.widget.Snackbar}
     * @return the root {@link View} element
     */
    protected View getRootView() {
        final ViewGroup contentViewGroup = findViewById(android.R.id.content);
        View rootView = null;

        if(contentViewGroup != null)
            rootView = contentViewGroup.getChildAt(0);

        if(rootView == null)
            rootView = getWindow().getDecorView().getRootView();

        return rootView;
    }
}
