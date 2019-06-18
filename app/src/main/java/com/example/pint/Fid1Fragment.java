package com.example.pint;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fid1Fragment extends Fragment {

    TextView Prom, Acum, Resg, Aval;

    public Fid1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fid1, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Prom = (TextView) getView().findViewById(R.id.btnPromo);
        Acum = (TextView) getView().findViewById(R.id.btnAcum);
        Resg = (TextView) getView().findViewById(R.id.btnResg);
        Aval = (TextView) getView().findViewById(R.id.btnAval);
        Fragment promFrag = Fid1ContFragment.newInstance();

        Prom.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        Prom.setTextColor(getResources().getColor(R.color.corMenu));
        Acum.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        Acum.setTextColor(Color.BLACK);
        Resg.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        Resg.setTextColor(Color.BLACK);
        Aval.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        Aval.setTextColor(Color.BLACK);
        openFragment(promFrag);

        Prom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment promFrag = Fid1ContFragment.newInstance();
                Prom.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                Prom.setTextColor(getResources().getColor(R.color.corMenu));
                Acum.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                Acum.setTextColor(Color.BLACK);
                Resg.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                Resg.setTextColor(Color.BLACK);
                Aval.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                Aval.setTextColor(Color.BLACK);
                openFragment(promFrag);
            }
        });

        Acum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment acumFrag = Fid2Fragment.newInstance();
                Prom.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                Prom.setTextColor(Color.BLACK);
                Acum.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                Acum.setTextColor(getResources().getColor(R.color.corMenu));
                Resg.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                Resg.setTextColor(Color.BLACK);
                Aval.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                Aval.setTextColor(Color.BLACK);
                openFragment(acumFrag);
            }
        });

        Resg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment resgFrag = Fid3Fragment.newInstance();
                Prom.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                Prom.setTextColor(Color.BLACK);
                Acum.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                Acum.setTextColor(Color.BLACK);
                Resg.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                Resg.setTextColor(getResources().getColor(R.color.corMenu));
                Aval.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                Aval.setTextColor(Color.BLACK);
                openFragment(resgFrag);
            }
        });

        Aval.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment avalFrag = Fid4Fragment.newInstance();
                Prom.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                Prom.setTextColor(Color.BLACK);
                Acum.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                Acum.setTextColor(Color.BLACK);
                Resg.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                Resg.setTextColor(Color.BLACK);
                Aval.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                Aval.setTextColor(getResources().getColor(R.color.corMenu));
                openFragment(avalFrag);
            }
        });
    }

    public static Fid1Fragment newInstance() {
        return new Fid1Fragment();
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.DispFid1, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
