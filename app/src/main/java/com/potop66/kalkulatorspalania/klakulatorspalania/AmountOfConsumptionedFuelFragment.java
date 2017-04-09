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


public class AmountOfConsumptionedFuelFragment extends android.app.Fragment {
    TextView wynik;
    EditText przejechaneKm, spalanieNa100km;
    TextWatcher tw;
    Double przejechaneKmD, spalanieNa100kmD;
    private AdView mAdView;


    public AmountOfConsumptionedFuelFragment() {
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
                    przejechaneKmD = Double.parseDouble(przejechaneKm.getText() + "");
                    spalanieNa100kmD = Double.parseDouble(spalanieNa100km.getText() + "");
                    Double wynik1 = (przejechaneKmD / 100) * spalanieNa100kmD;
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
        View view = inflater.inflate(R.layout.fragment_amount_of_consumptioned_fuel, container, false);
        ad(view);
        wynik = (TextView) view.findViewById(R.id.textView5);
        przejechaneKm = (EditText) view.findViewById(R.id.editText);
        spalanieNa100km = (EditText) view.findViewById(R.id.editText3);
        TextView dystans = (TextView) view.findViewById(R.id.textView);
        TextView srednieSpalanie = (TextView) view.findViewById(R.id.textView3);
        TextView iloscSpalonejBenzyny = (TextView) view.findViewById(R.id.textView4);

        SharedPreferences sp = getActivity().getSharedPreferences("Settings", MODE_PRIVATE);
        if (sp.getInt("dystans", 0) == 1 && sp.getInt("pojemnosc", 0) != 0) {

            przejechaneKm.setHint("Odleglosc w milach");
            dystans.setText(R.string.przejechaneMile);
            if (sp.getInt("pojemnosc", 0) == 1) {
                srednieSpalanie.setText(R.string.liczbaSpalonychGalonowUsNa100Mil);
                iloscSpalonejBenzyny.setText(R.string.iloscSpalonejBenzynyWGalachUs);
            } else {
                srednieSpalanie.setText(R.string.liczbaSpalonychGalonowUeNa100Mil);
                iloscSpalonejBenzyny.setText(R.string.iloscSpalonejBenzynyWGalachUe);

            }
        } else if (sp.getInt("dystans", 0) == 1) {

            przejechaneKm.setHint("Odleglosc w milach");
            dystans.setText(R.string.przejechaneMile);
            srednieSpalanie.setText(R.string.liczbaSpalonychLitrowNa100Mil);

        } else if (sp.getInt("pojemnosc", 0) != 0) {

            if (sp.getInt("pojemnosc", 0) == 1) {
                srednieSpalanie.setText(R.string.liczbaSpalonychGalonowUsNa100Km);
                iloscSpalonejBenzyny.setText(R.string.iloscSpalonejBenzynyWGalachUs);

            } else if (sp.getInt("pojemnosc", 0) == 2) {
                srednieSpalanie.setText(R.string.liczbaSpalonychGalonowUeNa100Km);
                iloscSpalonejBenzyny.setText(R.string.iloscSpalonejBenzynyWGalachUe);

            }
        }

        przejechaneKm.addTextChangedListener(tw);
        spalanieNa100km.addTextChangedListener(tw);
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

