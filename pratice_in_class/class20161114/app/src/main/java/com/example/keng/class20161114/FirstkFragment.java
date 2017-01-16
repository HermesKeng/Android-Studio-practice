package com.example.keng.class20161114;


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
public class FirstkFragment extends Fragment {

    Listener activityCallback;
    Button btn1,btn2;
    EditText edtxt;
    Activity activity;
    View view;
    public FirstkFragment() {
        // Required empty public constructor
    }
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try { // 取得父活動物件
            activityCallback = (Listener) activity; }
        catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() +
                    "需實作BMIListener"); }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_firstk,container,false);



        btn1=(Button)view.findViewById(R.id.btn1);
        btn2=(Button)view.findViewById(R.id.btn2);
        edtxt=(EditText)view.findViewById(R.id.input);
        // Inflate the layout for this fragment
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double tmp,output;
                tmp=Double.parseDouble(edtxt.getText().toString());
                output=(tmp-32)*5/9;
                activityCallback.BtnClick(output);
            }
        });
        return view;
    }
    public interface  Listener{
        public void BtnClick(double tmp);
    }
}
