package com.example.harulg_hell.bap.Fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.harulg_hell.bap.R;


public class Fragment1 extends Fragment {

        FloatingActionButton fab;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

            fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.fab:
                            Snackbar.make(v, "This is snackbar", Snackbar.LENGTH_INDEFINITE)
                                    .setAction("Close", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Snackbar.make(view, "snackbar is closing", Snackbar.LENGTH_SHORT).show();
                                        }
                                    }).show();
                            break;
                    }
                }
            });

            return rootView;
        }
}
