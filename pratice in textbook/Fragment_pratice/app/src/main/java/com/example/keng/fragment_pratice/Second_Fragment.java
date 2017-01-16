package com.example.keng.fragment_pratice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Second_Fragment extends Fragment {

    private static  final String MESSAGE="Message";
    private String msg;

    public static Second_Fragment newInstance(String msg){
        Second_Fragment fragment=new Second_Fragment();
        Bundle args=new Bundle();
        args.putString(MESSAGE,msg);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle saveInstanceStated){
        super.onCreate(saveInstanceStated);
        if(getArguments()!=null){
            msg=getArguments().getString(MESSAGE);
        }
    }
    public Second_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView output=(TextView) getView().findViewById(R.id.output);
        output.setText(msg);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_, container, false);
    }

}
