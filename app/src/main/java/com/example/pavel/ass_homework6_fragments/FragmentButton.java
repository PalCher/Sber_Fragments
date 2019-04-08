package com.example.pavel.ass_homework6_fragments;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.Button;

public class FragmentButton extends Fragment {
    private Button button;
    private ActivityCallbacks activityCallbacks;
    private String data;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityCallbacks = (ActivityCallbacks) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement onSomeEventListener");
        }
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_btn, container, false);
        return view;
    }

    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        button = view.findViewById(R.id.btn);
        button.setOnClickListener(new ButtonListener());
    }





    private class ButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Bundle bundle = new Bundle();
            data = activityCallbacks.getData();
            bundle.putString("data", data );
            FragmentManager manager = getChildFragmentManager();

            manager.beginTransaction()
                    .replace(R.id.child_fragment, ChildFragment.newInstance(bundle))
                    .commitNow();
//            activityCallbacks.pressButton();
        }
    }

    public interface ActivityCallbacks{
         String getData();
    }
}
