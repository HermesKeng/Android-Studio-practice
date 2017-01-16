package com.example.keng.f410385007x1;


import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class TransFragment extends Fragment
                                    implements DialogInterface.OnClickListener{

    EditText temp;
    Button btn;
    TempListener activityCallback;
    double temprature;
    double ans;

    @Override
    public void onClick(DialogInterface dialog, int which) {
        ans=0;
        if(which==DialogInterface.BUTTON_POSITIVE){
            //轉華氏
            ans=temprature*(9/5)+32;
            activityCallback.onbuttonClick(ans);

        }
        else if(which==DialogInterface.BUTTON_NEGATIVE){
            //轉攝氏
            temprature-=32.0;
            ans=temprature;
            ans=ans*(5/9);
            ans=temprature;
            activityCallback.onbuttonClick(ans);
        }
    }



    public interface TempListener{
        public void onbuttonClick(double temp);
    }
    public TransFragment() {
        // Required empty public constructor
    }
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            activityCallback=(TempListener)activity;
        }catch (ClassCastException ex){
            throw new ClassCastException(activity.toString()+"TransFragment");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_trans, container, false);
        temp=(EditText)view.findViewById(R.id.temprature);
        btn=(Button)view.findViewById(R.id.trans);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click(v);
            }
        });

        return view;
    }
    public void Click(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        temprature=Double.parseDouble(temp.getText().toString());
        builder.setTitle("溫度轉換");
        builder.setMessage("請選擇轉換單位");
        builder.setPositiveButton("轉華氏",this);
        builder.setNegativeButton("轉攝氏",this);
        builder.show();


    }

}
