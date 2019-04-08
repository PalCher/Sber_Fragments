package com.example.pavel.ass_homework6_fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentButton.ActivityCallbacks {

    private FragmentEditText fragmentEditText;
    private ChildFragment childFragment;
    private FragmentButton fragmentButton;
    private String data;
    private EditText mEditText;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(MyService.newIntent(MainActivity.this));


    }


    @Override
    public String getData() {
        fragmentEditText = (FragmentEditText) getSupportFragmentManager().findFragmentById(R.id.fragment_text);
        mEditText = fragmentEditText.getView().findViewById(R.id.editText);
        data = mEditText.getText().toString();
        return data;
    }
}
