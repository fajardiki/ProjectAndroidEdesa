package com.example.projectandroidedesa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public boolean onCreateOptionMenu(Home menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, (android.view.Menu) menu);
        return true;
    }

    public boolean onOptionItemSelected(MenuItem item){
        if (item.getItemId()==R.id.home){
            startActivity(new Intent(this, Home.class));
        } else if (item.getItemId()==R.id.pengajuan){
            startActivity(new Intent(this, Pengajuan.class));
        }

        return true;
    }
}