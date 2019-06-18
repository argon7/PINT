package com.example.pint;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;

public class WalletFragment extends Fragment {
    TextView voltar, cart;
    ImageView pesquisa;
    SearchView pesq;
    ListView lista;

    public WalletFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wallet, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        voltar = (TextView) getView().findViewById(R.id.btnAddCard);
        pesquisa = (ImageView) getView().findViewById(R.id.btnPesquisa);
        final Intent log = new Intent(getActivity(), HomeActivity.class);
        pesq = (SearchView) getView().findViewById(R.id.txtPesquisa);
        lista = (ListView) getView().findViewById(R.id.lstCartoes);
        final Fragment cartao = Fid1Fragment.newInstance();
        cart = (TextView) getView().findViewById(R.id.btnCartao);

        voltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(log);
            }
        });
        pesquisa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pesq.setVisibility(View.VISIBLE);
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openFragment(cartao);
            }
        });
        /*lista.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openFragment(cartao);
            }
        });*/
    }

    public static WalletFragment newInstance() {
        return new WalletFragment();
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.DisplayWallet, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}