package com.example.pint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegistarActivity extends AppCompatActivity {
    TextView termos, politica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar);

        termos =(TextView) findViewById(R.id.btnTermos);
        politica = (TextView) findViewById(R.id.btnPolitica);
        final Intent ter = new Intent(this, TermosActivity.class);
        final Intent pol = new Intent(this, PoliticasActivity.class);

        termos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(ter);
            }
        });
        politica.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(pol);
            }
        });
    }
}
