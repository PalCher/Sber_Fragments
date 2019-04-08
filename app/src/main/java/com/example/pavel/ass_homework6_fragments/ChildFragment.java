package com.example.pavel.ass_homework6_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ChildFragment extends Fragment {
    private TextView textView;
    private Bundle bundle;



    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child, container, false);
        return view;
    }

    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        textView = view.findViewById(R.id.tv_child);
        bundle = getArguments();
        textView.setText(bundle.getString("data"));

    }

    public static ChildFragment newInstance(Bundle bundle){
        ChildFragment fragment = new ChildFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
