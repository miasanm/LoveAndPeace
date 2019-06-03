package com.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.example.myapplication.Fragment.OneFragment;
import com.example.myapplication.Mine.ThreeFragment;
import com.example.myapplication.Fragment.TwoFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

     @Override
     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
         fragmentManager = getSupportFragmentManager();
         transaction = fragmentManager.beginTransaction();
         switch (item.getItemId()) {
             case R.id.navigation_home:
                 transaction.replace(R.id.content,new OneFragment());
                 transaction.commit();
                 return true;
             case R.id.navigation_dashboard:
                 transaction.replace(R.id.content,new TwoFragment());
                 transaction.commit();
                 return true;
             case R.id.navigation_notifications:
                 transaction.replace(R.id.content,new ThreeFragment());
                 transaction.commit();
                 return true;

        }
        return false;
     }
    };


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.navigation);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;

    // 设置默认进来是tab 显示的页面
    private void setDefaultFragment(){
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content,new OneFragment());
        transaction.commit();
    }

    public void onBackPressd(){
        super.onBackPressed();
        ActivityCollector.finishAll();
    }

}
