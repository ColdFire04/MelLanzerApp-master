package com.example.calengray.mellanzer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private jobsFragment jobsFragment;
    private scheduleFragment scheduleFragment;
    private peopleFragment peopleFragment;
    private equipmentFragment equipmentFragment;
    private newJobFragment newJobFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_frame,new jobsFragment());
        fragmentTransaction.commit();




        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);


        jobsFragment = new jobsFragment();
        scheduleFragment = new scheduleFragment();
        peopleFragment = new peopleFragment();
        equipmentFragment = new equipmentFragment();
        newJobFragment = new newJobFragment();

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_jobs:

                        setFragment(jobsFragment);
                        return true;

                    case R.id.nav_schedule:

                        setFragment(scheduleFragment);
                        return true;

                    case R.id.nav_people:

                        setFragment(peopleFragment);
                        return true;

                    case R.id.nav_equipment:

                        setFragment(equipmentFragment);
                        return true;

                    case R.id.nav_newJob:

                        setFragment(newJobFragment);
                        return true;

                        default:
                            return false;

                }
            }


            private void setFragment(Fragment fragment) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frame, fragment);
                fragmentTransaction.commit();

            }
        });
        }

    }


