package com.potop66.kalkulatorspalania.klakulatorspalania;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainScreenFragment extends android.app.Fragment {

    String title[];
    String subtitle[];
    List<Map<String, String>> data = new ArrayList<Map<String, String>>();
    private OnMainScreenActionsRecorded mListener;
    private AdView mAdView;


    public MainScreenFragment() {
    }

    public void ad(View view) {
        mAdView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof OnMainScreenActionsRecorded) {
            mListener = (OnMainScreenActionsRecorded) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void getMyResources() {
        Resources res = getResources();
        title = res.getStringArray(R.array.title);
        subtitle = res.getStringArray(R.array.subtitle);
        for (int j = 0; j < title.length; j++) {
            HashMap hashMap = new HashMap();
            hashMap.put("title", title[j]);
            hashMap.put("subtitle", subtitle[j]);
            data.add(hashMap);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMyResources();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_screen, container, false);
        ad(view);
        ListView list = (ListView) view.findViewById(android.R.id.list);
        ImageButton settingsButton = (ImageButton) view.findViewById(R.id.imageButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.imageButtonClicked();
            }
        });

        SimpleAdapter adapter = new SimpleAdapter(getActivity(),
                data,
                R.layout.list,
                new String[]{"title", "subtitle"},
                new int[]{android.R.id.text1, android.R.id.text2});

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.position(position);
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

    public interface OnMainScreenActionsRecorded {
        // TODO: Update argument type and name
        void position(int position);

        void imageButtonClicked();
    }


}
