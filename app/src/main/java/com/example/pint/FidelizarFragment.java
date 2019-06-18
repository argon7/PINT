package com.example.pint;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;


public class FidelizarFragment extends Fragment {

    TextView desc, txtdesc, mapa, aval;
    MapView map;
    CardView ava;
    ImageView voltar;

    public FidelizarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fidelizar, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        desc = (TextView) getView().findViewById(R.id.btnDesc);
        txtdesc = (TextView) getView().findViewById(R.id.txtDesc);
        mapa = (TextView) getView().findViewById(R.id.btnMapa);
        map = (MapView) getView().findViewById(R.id.mapVi);
        aval = (TextView) getView().findViewById(R.id.btnAval);
        ava = (CardView) getView().findViewById(R.id.Card);
        voltar = (ImageView) getView().findViewById(R.id.btnVoltar);

        desc.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        desc.setTextColor(getResources().getColor(R.color.corMenu));


        desc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                desc.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                desc.setTextColor(getResources().getColor(R.color.corMenu));
                txtdesc.setVisibility(View.VISIBLE);
                mapa.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                mapa.setTextColor(Color.BLACK);
                map.setVisibility(View.GONE);
                aval.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                aval.setTextColor(Color.BLACK);
                ava.setVisibility(View.GONE);
            }
        });

        mapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                desc.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                desc.setTextColor(Color.BLACK);
                txtdesc.setVisibility(View.GONE);
                mapa.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                mapa.setTextColor(getResources().getColor(R.color.corMenu));
                map.setVisibility(View.VISIBLE);
                aval.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                aval.setTextColor(Color.BLACK);
                ava.setVisibility(View.GONE);
            }
        });

        aval.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                desc.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                desc.setTextColor(Color.BLACK);
                txtdesc.setVisibility(View.GONE);
                mapa.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                mapa.setTextColor(Color.BLACK);
                map.setVisibility(View.GONE);
                aval.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                aval.setTextColor(getResources().getColor(R.color.corMenu));
                ava.setVisibility(View.VISIBLE);
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

    public static FidelizarFragment newInstance() {

        return new FidelizarFragment();
    }
}
