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


public class PriceOfConsumptionedFuelFragment extends android.app.Fragment {
    TextWatcher tw;
    TextView wynik;
    EditText odleglosc, cena, spalanie;
    Double odleglosc1, cena1, spalanie1, wynik1, wynik2;
    String odleglosc2, cena2, spalanie2, wynik3;
    private AdView mAdView;


    public PriceOfConsumptionedFuelFragment() {
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
                    odleglosc2 = odleglosc.getText() + "";
                    cena2 = cena.getText() + "";
                    spalanie2 = spalanie.getText() + "";
                    odleglosc1 = Double.parseDouble(odleglosc2);
                    cena1 = Double.parseDouble(cena2);
                    spalanie1 = Double.parseDouble(spalanie2);

                    wynik1 = odleglosc1 / 100;
                    wynik2 = wynik1 * cena1 * spalanie1;
                    java.text.DecimalFormat df = new java.text.DecimalFormat();
                    df.setMaximumFractionDigits(2);
                    df.setMinimumFractionDigits(2);
                    wynik3 = (df.format(wynik2));
                    wynik.setText(wynik3);
                    return;
                } catch (Exception var2_6) {
                    wynik.setText(R.string.wrongScore);
                    return;
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
        View view = inflater.inflate(R.layout.fragment_price_of_consumptioned_fuel, container, false);
        ad(view);
        wynik = (TextView) view.findViewById(R.id.textView5);
        odleglosc = (EditText) view.findViewById(R.id.editText);
        cena = (EditText) view.findViewById(R.id.editText2);
        spalanie = (EditText) view.findViewById(R.id.editText3);
        TextView dystans = (TextView) view.findViewById(R.id.textView);
        TextView srednieSpalanie = (TextView) view.findViewById(R.id.textView3);
        SharedPreferences sp = getActivity().getSharedPreferences("Settings", MODE_PRIVATE);
        if (sp.getInt("dystans", 0) == 1 && sp.getInt("pojemnosc", 0) != 0) {
            odleglosc.setHint("Odleglosc w milach");
            dystans.setText(R.string.przejechaneMile);

            if (sp.getInt("pojemnosc", 0) == 1) {
                srednieSpalanie.setText(R.string.liczbaSpalonychGalonowUsNa100Mil);
            } else {
                srednieSpalanie.setText(R.string.liczbaSpalonychGalonowUeNa100Mil);
            }
        } else if (sp.getInt("dystans", 0) == 1) {

            odleglosc.setHint("Odleglosc w milach");
            dystans.setText(R.string.przejechaneMile);
            srednieSpalanie.setText(R.string.liczbaSpalonychLitrowNa100Mil);

        } else if (sp.getInt("pojemnosc", 0) != 0) {
            if (sp.getInt("pojemnosc", 0) == 1) {
                srednieSpalanie.setText(R.string.liczbaSpalonychGalonowUsNa100Km);

            } else if (sp.getInt("pojemnosc", 0) == 2) {
                srednieSpalanie.setText(R.string.liczbaSpalonychGalonowUeNa100Km);

            }

        }
        odleglosc.addTextChangedListener(tw);
        cena.addTextChangedListener(tw);
        spalanie.addTextChangedListener(tw);

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
