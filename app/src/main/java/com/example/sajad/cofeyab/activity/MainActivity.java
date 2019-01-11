package com.example.sajad.cofeyab.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.sajad.cofeyab.R;
import com.example.sajad.cofeyab.fragment.Cofees;
import com.example.sajad.cofeyab.fragment.Home;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    FragmentTransaction home = getSupportFragmentManager().beginTransaction();
                    home.replace(R.id.container_framelayout, new Home());
                    home.commit();
                return true;
                case R.id.cofe:
                    FragmentTransaction cofe = getSupportFragmentManager().beginTransaction();
                    cofe.replace(R.id.container_framelayout, new Cofees());
                    cofe.addToBackStack(null);
                    cofe.commit();
                    return true;
                case R.id.call_with_us:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isOnline()) {
            navigation = findViewById(R.id.navigation);
            navigation.setSelectedItemId(R.id.home);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container_framelayout, new Home());
            ft.commit();
        } else {
            Toast.makeText(this, "no", Toast.LENGTH_SHORT).show();
        }
    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

}
