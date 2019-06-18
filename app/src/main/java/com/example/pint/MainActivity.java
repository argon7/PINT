package com.example.pint;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 7117; //qualquer nr aqui servia
    List<AuthUI.IdpConfig> providers;
    Button btn_sign_out;



    TextView esqpass, registar, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sign_out = findViewById(R.id.btn_sign_out_ac);


        btn_sign_out.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                //logout
                AuthUI.getInstance()
                        .signOut(MainActivity.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                btn_sign_out.setEnabled(false);
                                showSignInOptions();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),

                new AuthUI.IdpConfig.PhoneBuilder().build(),

                new AuthUI.IdpConfig.FacebookBuilder().build(),

                new AuthUI.IdpConfig.GoogleBuilder().build()
        );

        showSignInOptions();

        esqpass = (TextView) findViewById(R.id.btnEsqPass);
        registar = (TextView) findViewById(R.id.btnRegistar);
        login = (TextView) findViewById(R.id.btnLogin);

        final Intent esq = new Intent(this, EsquecerPasswordActivity.class);
        final Intent reg = new Intent(this, RegistarActivity.class);
        final Intent log = new Intent(this, HomeActivity.class);

        esqpass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(esq);
            }
        });
        registar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(reg);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(log);
            }
        });
    }

    private void showSignInOptions() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setTheme(R.style.Theme_for_Login)
                        .build(), MY_REQUEST_CODE
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE) {
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK) {
                //get User
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                //show email on toast
                Toast.makeText(this, "" + user.getEmail(), Toast.LENGTH_SHORT).show();
                //set buton signout
                btn_sign_out.setEnabled(true);
            }
            else
            {
                Toast.makeText(this, "" +response.getError().getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}

