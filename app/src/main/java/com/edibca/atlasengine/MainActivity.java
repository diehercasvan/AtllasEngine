package com.edibca.atlasengine;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private Toolbar toolbar;
    private FrameLayout frlBlackboard;
    private FrameLayout frg_Info, frg_Info_image;
    private ImageView imgBtnTextInfo;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadToolbar();
        loadDrawerLayout();
        loadNavigationView();
        loadView();


    }

    private void loadView() {

        General.General.ACTIVITY=this;
        General.General.CONTEXT=this;

        frlBlackboard = (FrameLayout) findViewById(R.id.container_blackboard);
        frg_Info = (FrameLayout) findViewById(R.id.container_Info);
        frg_Info_image = (FrameLayout) findViewById(R.id.container_InfoImage);



    }

    private void loadToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void loadFlotingButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void loadDrawerLayout() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void loadNavigationView() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.activity_main_drawer, popup.getMenu());
        popup.show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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

        switch (item.getItemId()) {


            case R.id.btnInfo:
                selectionFragmentInfo(0);

                break;
            case R.id.btnMoreImage:

                selectionFragmentInfo(1);
                break;
            case R.id.btnTool:
                selectionTool(4);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    private void selectionTool(int dataSelection) {

        switch (dataSelection) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                if (frlBlackboard.getVisibility() == View.GONE) {
                    frlBlackboard.setVisibility(View.VISIBLE);
                } else {
                    frlBlackboard.setVisibility(View.GONE);
                }
                break;
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }

    }

    private void selectionFragmentInfo(int iTypeFragment) {

        if (iTypeFragment == 0) {
            if (frg_Info.getVisibility() == View.VISIBLE) {
                animationImageInfo(0, frg_Info);
            } else {
                animationImageInfo(1, frg_Info);
                if (frg_Info_image.getVisibility() == View.VISIBLE) {
                    animationTextInfo(0, frg_Info_image);
                }
            }

        } else {
            if (frg_Info_image.getVisibility() == View.VISIBLE) {
                animationTextInfo(0, frg_Info_image);
            } else {
                animationTextInfo(1, frg_Info_image);
                if (frg_Info.getVisibility() == View.VISIBLE) {
                    animationImageInfo(0, frg_Info);
                }
            }
        }
    }

    private void animationTextInfo(int itype, FrameLayout fragment) {
        Animation animation = null;
        fragment.clearAnimation();
        if (itype == 0) {
            animation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.slide_down);

            fragment.setVisibility(View.GONE);

        } else {
            animation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.slide_up);
            fragment.setVisibility(View.VISIBLE);
        }
        fragment.startAnimation(animation);

    }

    private void animationImageInfo(int itype, FrameLayout fragment) {
        Animation animation = null;
        fragment.clearAnimation();
        if (itype == 0) {
            animation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.slide_right);

            fragment.setVisibility(View.GONE);

        } else {
            animation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.slide_left);
            fragment.setVisibility(View.VISIBLE);
        }
        fragment.startAnimation(animation);

    }
}
