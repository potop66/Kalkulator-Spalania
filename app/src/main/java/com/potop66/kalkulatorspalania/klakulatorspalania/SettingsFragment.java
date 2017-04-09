package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static android.content.Context.MODE_PRIVATE;


public class SettingsFragment extends android.app.Fragment {

    String[] dystans_spinner_content;
    String[] pojemnosc_spinner_content;
    SharedPreferences.Editor editor;
    private AdView mAdView;


    public SettingsFragment() {
    }

    public void setArrays() {
        Resources res = getResources();
        dystans_spinner_content = res.getStringArray(R.array.dystans);
        pojemnosc_spinner_content = res.getStringArray(R.array.pojemnosc);
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
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        ad(view);
        Spinner dystans = (Spinner) view.findViewById(R.id.spinner);
        Spinner pojemnosc = (Spinner) view.findViewById(R.id.spinner2);
        setArrays();

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Settings", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        dystans.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dystans_spinner_content));
        dystans.setSelection(sharedPreferences.getInt("dystans", 0));
        dystans.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position1, long id) {
                editor.putInt("dystans", position1);
                editor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        pojemnosc.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, pojemnosc_spinner_content));
        pojemnosc.setSelection(sharedPreferences.getInt("pojemnosc", 0));
        pojemnosc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position1, long id) {
                editor.putInt("pojemnosc", position1);
                editor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


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
