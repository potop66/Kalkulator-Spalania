package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static android.content.Context.MODE_PRIVATE;


public class DrivedDistanceFragment extends android.app.Fragment {
    TextWatcher tw;
    EditText spalanie, spaloneLitry;
    TextView wynik;
    Double spalanie1, spaloneLitry1;
    private AdView mAdView;


    public DrivedDistanceFragment() {
        tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    spalanie1 = Double.parseDouble(spalanie.getText() + "");
                    spaloneLitry1 = Double.parseDouble(spaloneLitry.getText() + "");
                    Double wynik1 = spaloneLitry1 / spalanie1 * 100;
                    java.text.DecimalFormat df = new java.text.DecimalFormat();
                    df.setMaximumFractionDigits(2);
                    df.setMinimumFractionDigits(2);
                    String wynik2 = (df.format(wynik1));
                    wynik.setText(wynik2);
                } catch (Exception var2_5) {
                    wynik.setText(R.string.wrongScore);
                }
            }
        };
    }

    public void ad(View view) {
        mAdView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drived_distance, container, false);
        ad(view);
        wynik = (TextView) view.findViewById(R.id.textView22);
        spalanie = (EditText) view.findViewById(R.id.editText10);
        spaloneLitry = (EditText) view.findViewById(R.id.editText11);
        SharedPreferences sp = getActivity().getSharedPreferences("Settings", MODE_PRIVATE);
        TextView iloscSpalonejBenzyny = (TextView) view.findViewById(R.id.textView20);

        switch (sp.getInt("pojemnosc", 0)) {
            case 1:
                iloscSpalonejBenzyny.setText(R.string.iloscSpalonejBenzynyWGalachUs);
                break;
            case 2:
                iloscSpalonejBenzyny.setText(R.string.iloscSpalonejBenzynyWGalachUe);
                break;
        }
        if (sp.getInt("dystans", 0) == 1) {
            TextView spalanie1 = (TextView) view.findViewById(R.id.textView19);
            TextView dystans = (TextView) view.findViewById(R.id.textView21);
            spalanie1.setText(R.string.spalanieNa100Mil);
            dystans.setText(R.string.przejechaneMile);
        }
        spalanie.addTextChangedListener(tw);
        spaloneLitry.addTextChangedListener(tw);


        return view;
    }


    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }


}
