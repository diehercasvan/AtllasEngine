package com.edibca.atlasengine;


import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import DTO.Content_Object_Page;
import class_project.General;
import class_project.MenuFragment;
import class_project.MyDragListener;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private Toolbar toolbar;
    private FrameLayout frlBlackboard;
    private FrameLayout frg_Info, frg_Info_image;
    private ImageView imgBtnTextInfo;
    private NavigationView navigationView;
    private RelativeLayout rly_container_drag, rly_general_screen;
    private ArrayList<String> sTitle;
    private int iContFragment = 0;
    private MenuItem[] menuItems;
    private MenuFragment menuFragment = new MenuFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        General.ACTIVITY = this;
        General.CONTEXT = this;
        General.ROUTE = Environment.getExternalStorageDirectory().getAbsolutePath();

        setContentView(R.layout.activity_main);
        loadToolbar();
        loadDrawerLayout();
        loadNavigationView();
        loadView();


    }

    private void loadView() {


        frlBlackboard = (FrameLayout) findViewById(R.id.container_blackboard);

        frg_Info = (FrameLayout) findViewById(R.id.container_Info);
        frg_Info_image = (FrameLayout) findViewById(R.id.container_InfoImage);

        rly_container_drag = (RelativeLayout) findViewById(R.id.container_drag);
        rly_container_drag.setOnDragListener(new MyDragListener());
        General.RELATIVE_LAYOUT = rly_container_drag;

        rly_general_screen = (RelativeLayout) findViewById(R.id.Container_fragment_general);
        General.RELATIVE_LAYOUT_SCREEN = rly_general_screen;
        sTitle = new ArrayList<>();

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
        menuItems = new MenuItem[3];
        menuItems[0] = menu.findItem(R.id.btnInfo);
        menuItems[1] = menu.findItem(R.id.btnMoreImage);
        menuItems[2] = menu.findItem(R.id.btnTool);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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
        final List<MenuItem> items = new ArrayList<>();
        Menu menu = navigationView.getMenu();


        for (int i = 0; i < menu.size(); i++) {
            items.add(menu.getItem(i));
        }

        int id = item.getItemId();

        if (id == R.id.nav_video) {
            // Handle the camera action
            selectionOption(0);
        } else if (id == R.id.nav_image) {
            selectionOption(1);

        } else if (id == R.id.nav_gallery) {
            selectionOption(2);
        } else if (id == R.id.nav_gallery2) {
            selectionOption(3);
        } else if (id == R.id.nav_pdf) {

        } else if (id == R.id.nav_multi_page) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        item.setChecked(true);
        int position = items.indexOf(item);

        Log.i("position", position + "");
        setTitle(item.getTitle());

        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }

    }


    private void selectionFragmentInfo(int iTypeFragment) {
        FragmentTransaction fTransaction = null;
        if (iTypeFragment == 0) {
            if (frg_Info.getVisibility() == View.VISIBLE) {
                animationImageInfo(0, frg_Info);
            } else {
                frg_Info.removeAllViews();
                fTransaction = getSupportFragmentManager().beginTransaction();
                fTransaction.replace(R.id.container_Info, menuFragment.selectFragmentMenu(4));
                fTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fTransaction.addToBackStack(null);
                fTransaction.commit();

                animationImageInfo(1, frg_Info);
                if (frg_Info_image.getVisibility() == View.VISIBLE) {
                    animationTextInfo(0, frg_Info_image);
                }
            }

        } else {
            if (frg_Info_image.getVisibility() == View.VISIBLE) {
                animationTextInfo(0, frg_Info_image);
            } else {
                frg_Info_image.removeAllViews();
                fTransaction = getSupportFragmentManager().beginTransaction();
                fTransaction.replace(R.id.container_InfoImage, menuFragment.selectFragmentMenu(5));
                fTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fTransaction.addToBackStack(null);
                fTransaction.commit();

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

    private void closeInfo(FrameLayout fragment) {
        Animation animation = null;
        fragment.clearAnimation();
        if (fragment.getVisibility() == View.VISIBLE) {
            animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
            fragment.setVisibility(View.GONE);
            fragment.startAnimation(animation);
        }
    }

    private void selectionOption(int iOption) {
        closeInfo(frg_Info_image);
        closeInfo(frg_Info);
        Content_Object_Page content_object_page = new Content_Object_Page();
        content_object_page.loadObjectPage(iOption);

        iconsTool();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_view, menuFragment.selectFragmentMenu(iOption));
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        sTitle.add(iContFragment, getTitle().toString());
        iContFragment++;
    }
    private void iconsTool(){
        if (General.DTO_GENERAL.isbTextIcon()) {
            menuItems[0].setVisible(true);
        } else {
            menuItems[0].setVisible(false);
        }

        if (General.DTO_GENERAL.isbImgIcon()) {
            menuItems[1].setVisible(true);
        } else {
            menuItems[1].setVisible(false);
        }



    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            iContFragment--;
            setTitle(sTitle.get(iContFragment));

        }
        return super.onKeyDown(keyCode, event);
    }
}
