package com.example.pavel.ass_homework6_fragments;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class FragmentEditText extends Fragment {

    private EditText editText;
    private CustomBroadcastReciever mReciever;
    private IntentFilter mIntentFilter;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        return view;
    }

    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.editText);
        mReciever = new CustomBroadcastReciever(new MyViewCallback());
        mIntentFilter = new IntentFilter("com.example.pavel.ass_homework6_fragments");
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().registerReceiver(mReciever, mIntentFilter);
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(mReciever);

    }

    private class MyViewCallback implements ViewCallback{

        @Override
        public void onStatusChanged(String state) {

            editText.setText(state);
        }
    }


}
