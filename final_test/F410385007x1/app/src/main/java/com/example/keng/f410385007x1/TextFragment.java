package com.example.keng.f410385007x1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment {

    TextView txt;
    public TextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_text, container, false);
        txt=(TextView) view.findViewById(R.id.output);
        // Inflate the layout for this fragment
        return view;
    }
    public void changvalue(double temp){
        txt.setText("轉換溫度："+String.valueOf(temp));
    }

}
