package com.example.projectandroidedesa;

import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private PengajuanFragment pengajuanFragment;
    private PengaturanFragment pengaturanFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        pengajuanFragment = new PengajuanFragment();
        pengaturanFragment = new PengaturanFragment();

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(homeFragment);
                        return true;
                    case R.id.nav_pengajuan:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        return true;
                    case R.id.nav_pengaturan:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        return true;
                        default:
                            return false;
                }
            }

            private void setFragment(Fragment fragment) {
                
            }
        });
    }

}