package com.example.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class topFragment extends Fragment {
    EditText editText;
    Button button;
    OnMessageReader onMessageReader;


    public topFragment() {
        // Required empty public constructor
    }

    public interface OnMessageReader{
        public void onMessageRead(String message);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top, container, false);

        editText = (EditText)view.findViewById(R.id.editText);
        button = (Button)view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                onMessageReader.onMessageRead(message);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            onMessageReader = (OnMessageReader)activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "must override onMessageRead!");
        }

    }
}
