package com.example.keng.fragment_;


import android.app.Activity;
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
public class BlankFragment extends Fragment {
    EditText txtheight,txtweight;
    Button button;
    BMIListener activityCallback;
    public interface BMIListener{
        public void buttonClicked(double bmi);
    }
    public BlankFragment() {
        // Required empty public constructor
    }
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            activityCallback=(BMIListener)activity;
        }catch (ClassCastException ex){
            throw new ClassCastException(activity.toString()+"需實做 BMIListener");
        }
    }
    public void buttonClicked(View v){
        double height,weight;
        double bmi;
        height=Double.parseDouble(txtheight.getText().toString());
        weight=Double.parseDouble(txtweight.getText().toString());
        height/=100;
        bmi=weight/(height*height);
        activityCallback.buttonClicked(bmi);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank, container, false);
        txtheight=(EditText)view.findViewById(R.id.height);
        txtweight=(EditText)view.findViewById(R.id.weight);
        button=(Button)view.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }

        });

        return view;
    }


}
