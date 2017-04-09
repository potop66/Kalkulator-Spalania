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


public class FuelConsumptionFragment extends android.app.Fragment {
    TextWatcher tw;
    TextView wynik;
    EditText spalanie, dystans;
    float spalanie1, dystans1, wynik1;
    String spalanie2, dystans2, wynik2;
    SharedPreferences sp;
    private AdView mAdView;


    public FuelConsumptionFragment() {
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
                    spalanie2 = spalanie.getText() + "";
                    dystans2 = dystans.getText() + "";
                    dystans1 = Float.parseFloat(dystans2);
                    spalanie1 = Float.parseFloat(spalanie2);
                    wynik.setText(R.string.wrongScore);
                    wynik1 = spalanie1 / dystans1 * 100;
                    java.text.DecimalFormat df = new java.text.DecimalFormat();
                    df.setMaximumFractionDigits(2);
                    df.setMinimumFractionDigits(2);
                    wynik2 = (df.format(wynik1));
                    wynik.setText(wynik2);
                } catch (Exception var2_6) {
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
        View view = inflater.inflate(R.layout.fragment_fuel_consumption, container, false);
        ad(view);
        spalanie = (EditText) view.findViewById(R.id.editText6);
        dystans = (EditText) view.findViewById(R.id.editText7);
        wynik = (TextView) view.findViewById(R.id.textView13);


        sp = getActivity().getSharedPreferences("Settings", MODE_PRIVATE);
        TextView iloscSpalonejBenzyny = (TextView) view.findViewById(R.id.textView10);

        switch (sp.getInt("pojemnosc", 0)) {
            case 1:
                iloscSpalonejBenzyny.setText(R.string.iloscSpalonejBenzynyWGalachUs);
                break;
            case 2:
                iloscSpalonejBenzyny.setText(R.string.iloscSpalonejBenzynyWGalachUe);
                break;
        }
        if (sp.getInt("dystans", 0) == 1) {
            TextView dystansTV = (TextView) view.findViewById(R.id.textView11);
            dystansTV.setText(R.string.iloscPrzejechanychMil);
            dystans.setHint(R.string.przejechaneMile);
        }

        spalanie.addTextChangedListener(tw);
        dystans.addTextChangedListener(tw);

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

