package com.example.pint;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    Fragment homeFragment = HomeFragment.newInstance();
    Fragment walletFragment = WalletFragment.newInstance();
    Fragment opcoesFragment = OpcoesFragment.newInstance();
    Fragment mensagensFragment = MensagensFragment.newInstance();
    Fragment notificacoesFragment = NotificacaoFragment.newInstance();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    openFragment(homeFragment);
                    return true;

                case R.id.navigation_dashboard:
                    openFragment(walletFragment);
                    return true;
                case R.id.navigation_notifications:
                    openFragment(opcoesFragment);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        openFragment(homeFragment);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        openFragment(homeFragment);

        ImageView mensa = (ImageView) findViewById(R.id.btnMess);
        mensa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openFragment(mensagensFragment);
            }
        });

        ImageView notif = (ImageView) findViewById(R.id.btnNot);
        notif.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openFragment(notificacoesFragment);
            }
        });
    }


    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.display, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
