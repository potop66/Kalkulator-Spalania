package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;


public class MainActivity extends Activity implements MainScreenFragment.OnMainScreenActionsRecorded {
    Context context = this;
    android.app.FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        android.app.FragmentTransaction transaction;
        transaction = fragmentManager.beginTransaction();
        MainScreenFragment fragment = new MainScreenFragment();
        transaction.replace(R.id.fragment_frame, fragment);
        transaction.commit();
    }

    public void startUpFragment(android.app.Fragment fragment) {
        fragmentManager = getFragmentManager();
        android.app.FragmentTransaction transaction;
        transaction = fragmentManager.beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_frame, fragment);
        transaction.commit();
    }

    @Override
    public void position(int position) {

        switch (position) {
            case 0:
                startUpFragment(new FuelConsumptionFragment());

                break;

            case 1:
                startUpFragment(new PriceOfConsumptionedFuelFragment());
                break;

            case 2:
                startUpFragment(new AmountOfBoughtFuelFragment());
                break;

            case 3:
                startUpFragment(new DrivedDistanceFragment());
                break;
            case 4:
                startUpFragment(new AmountOfConsumptionedFuelFragment());
                break;
        }


    }

    @Override
    public void imageButtonClicked() {
        fragmentManager = getFragmentManager();
        android.app.FragmentTransaction transaction;
        transaction = fragmentManager.beginTransaction();
        SettingsFragment fragment = new SettingsFragment();
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_frame, fragment);
        transaction.commit();
    }
}