package com.example.keng.ch5_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    Button btn;
    RadioGroup tickettype,ticketnumber;
    int type_id,type_num;
    TextView txv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tickettype=(RadioGroup)findViewById(R.id.ticket_type);
        ticketnumber=(RadioGroup)findViewById(R.id.ticket_number);

        type_id=tickettype.getCheckedRadioButtonId();
        type_num=ticketnumber.getCheckedRadioButtonId();

        RadioButton select_type=(RadioButton)findViewById(type_id);
        RadioButton select_num=(RadioButton)findViewById(type_num);
        txv=(TextView)findViewById(R.id.ticket);
        txv.setText("買"+select_type.getText()+select_num.getText());
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(listener);


    }

    View.OnClickListener listener=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            txv=(TextView)findViewById(R.id.ticket);
            tickettype=(RadioGroup)findViewById(R.id.ticket_type);
            ticketnumber=(RadioGroup)findViewById(R.id.ticket_number);

            type_id=tickettype.getCheckedRadioButtonId();
            type_num=ticketnumber.getCheckedRadioButtonId();

            RadioButton select_type=(RadioButton)findViewById(type_id);
            RadioButton select_num=(RadioButton)findViewById(type_num);
            txv.setText("買"+select_type.getText()+select_num.getText());
            /*法ㄧ透過 switch進行設定
            switch (tickettype.getCheckedRadioButtonId()){
                case R.id.adult:
                    txv.setText("買全票");
                    break;
                case R.id.child:
                    txv.setText("買半票");
                    break;
                case R.id.senior:
                    txv.setText("買敬老票");
                    break;

            }*/
        }
    };
}
