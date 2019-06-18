package com.example.pint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class OpcoesFragment extends Fragment {

    public OpcoesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_opcoes, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView perfil = (TextView) getView().findViewById(R.id.btnEditar);
        TextView historico = (TextView) getView().findViewById(R.id.btnHist);
        TextView definicoes = (TextView) getView().findViewById(R.id.btnDefini);

        perfil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Perfil = new Intent(getActivity(), PerfilActivity.class);
                startActivity(Perfil);
            }
        });

        historico.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Historico = new Intent(getActivity(), HistoricoActivity.class);
                startActivity(Historico);
            }
        });

        definicoes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Definicoes = new Intent(getActivity(), DefinicoesActivity.class);
                startActivity(Definicoes);
            }
        });
    }

    public static OpcoesFragment newInstance() {
        return new OpcoesFragment();
    }
}
