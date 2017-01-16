package com.example.keng.class20161114;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private static final String message="MESSAGE";
    private String msg;
    View view;
    TextView txt;
    public static SecondFragment newInstance(String msg){

        SecondFragment fragment=new SecondFragment();

        Bundle arg=new Bundle();
        arg.putString(message,msg);
        fragment.setArguments(arg);

        return fragment;
    }

    //@Override
    public void OnCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments()!=null) {
            msg=getArguments().getString(message);
        }
    }
    public void Output(double tmp){
        txt.setText(Double.toString(tmp));
    }
    public SecondFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_second2, container, false);
        txt=(TextView)view.findViewById(R.id.output);
        // Inflate the layout for this fragment
        return view ;
    }


}
