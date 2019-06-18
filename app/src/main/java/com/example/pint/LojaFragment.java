package com.example.pint;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.TextView;

public class LojaFragment extends Fragment {

    SearchView searchView;
    TextView ver;

    public LojaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_loja, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        searchView=(SearchView) getView().findViewById(R.id.txtPesquisa);
        searchView.setQueryHint("Search View");
        ver = (TextView) getView().findViewById(R.id.btnVer);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getActivity().getBaseContext(), query, Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getActivity().getBaseContext(), newText, Toast.LENGTH_LONG).show();
                return false;
            }
        });

        ver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment lojFrag = FidelizarFragment.newInstance();
                openFragment(lojFrag);
            }
        });
    }

    public static LojaFragment newInstance() {

        return new LojaFragment();
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.display, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
