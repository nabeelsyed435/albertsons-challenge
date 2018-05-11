package com.example.acroapp.search;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.acroapp.R;
import com.example.acroapp.app.AcroApp;
import com.example.acroapp.base.BaseActivity;
import com.example.acroapp.service.to.Lf;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity
        implements SearchContract.View, NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.etSearch) EditText searchET;
    @BindView(R.id.rvResults) RecyclerView resultsRV;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.nav_view) NavigationView navigationView;

    @Inject
    SearchPresenter searchPresenter;

    private SearchAdapter searchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initViews();
        initDagger();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        searchPresenter.unsubscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        searchPresenter.detach();
    }

    private void initViews() {
        searchAdapter = new SearchAdapter();
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        resultsRV.setAdapter(searchAdapter);
        resultsRV.setLayoutManager(new LinearLayoutManager(this));
    }
    private void initDagger() {
        DaggerSearchComponent
                .builder()
                .appComponent(AcroApp.getDaggerAppComponent())
                .searchModule(new SearchModule(this))
                .build()
                .inject(this);
    }

    private boolean isInputValid() {
        if(searchET.getText().toString() == null || searchET.getText().toString().isEmpty()) {
            return false;
        }
        return true;
    }

    @OnClick(R.id.btSearch)
    void searchAcronym() {
        if(isInputValid()) {
            searchPresenter.loadData(searchET.getText().toString());
        }
    }

    @Override
    public void onFetchDataStarted() {
        Snackbar.make(getRootView(), "This is main activity onFetchDataStarted", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onFetchDataCompleted() {
        Snackbar.make(getRootView(), "This is main activity onFetchDataCompleted", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onFetchDataSuccess(List<Lf> acronyms) {
        searchAdapter.updateAcronyms(acronyms);
    }

    @Override
    public void onFetchDataError(Throwable throwable) {
        Snackbar.make(getRootView(), "This is main activity onFetchDataError", Snackbar.LENGTH_LONG).show();
    }

}
