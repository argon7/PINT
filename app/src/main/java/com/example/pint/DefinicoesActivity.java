package com.example.pint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DefinicoesActivity extends AppCompatActivity {
    ImageView politica, permissoes, acerca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definicoes);

        politica = (ImageView) findViewById(R.id.btnPoli);
        permissoes = (ImageView) findViewById(R.id.btnPerm);
        acerca = (ImageView) findViewById(R.id.btnAcerca);
        final Intent pol = new Intent(this, PoliticasActivity.class);
        final Intent per = new Intent(this, PermissoesActivity.class);
        final Intent ace = new Intent(this, AcercaActivity.class);

        politica.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(pol);
            }
        });
        permissoes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(per);
            }
        });
        acerca.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(ace);
            }
        });
    }
}
