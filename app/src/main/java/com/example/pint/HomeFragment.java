package com.example.pint;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    TextView loja, cat, perto;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        loja = (TextView) getView().findViewById(R.id.btnLojas);
        cat = (TextView) getView().findViewById(R.id.btnCategorias);
        perto = (TextView) getView().findViewById(R.id.btnPerto);

        Fragment lojaFrag = LojaFragment.newInstance();
        loja.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        cat.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        perto.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        openFragment(lojaFrag);


        loja.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment lojFrag = LojaFragment.newInstance();
                loja.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                cat.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                perto.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                openFragment(lojFrag);
            }
        });

        cat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment catFrag = CategoriasFragment.newInstance();
                loja.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                cat.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                perto.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                openFragment(catFrag);
            }
        });

        perto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment pertoFrag = PertoFragment.newInstance();
                loja.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                cat.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                perto.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                openFragment(pertoFrag);
            }
        });
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.displayfrag, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
