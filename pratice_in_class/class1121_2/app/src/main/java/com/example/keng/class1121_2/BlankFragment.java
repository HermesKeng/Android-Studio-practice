package com.example.keng.class1121_2;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
//extend DialogFragment
class MyDialog extends DialogFragment {

    public static MyDialog newInstance(String Title) {
        
        Bundle args = new Bundle();
        MyDialog dig = new MyDialog();
        args.putString("title",Title);
        dig.setArguments(args);
        return dig;
    }
    public AlertDialog OnCreateDialog(Bundle savedInstanceState){
        String title=getArguments().getString("title");
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder.setTitle(title)
                .setMessage("確定結束本程式?")
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((MainActivity)getActivity()).doPositiveClick();
                    }
                })
                .setNegativeButton("確認", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((MainActivity)getActivity()).doNeagtiveClick();
                    }
                })
                .create();
    }
    public MyDialog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

}
