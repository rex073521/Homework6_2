package com.example.rex.homework6_2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by REX on 2015/4/22.
 */
public class InfoFragment extends Fragment {

    public InfoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(container == null) {
            return null;
        }

        Bundle bundle = this.getArguments();
        double height=bundle.getDouble("height");
        double weight=bundle.getDouble("weight");
        View view = inflater.inflate(R.layout.activity_info, container, false);
        TextView txtView = (TextView)view.findViewById(R.id.txtView);
        double bmi = weight/((height*height)/10000);
        //將計算出的bmi數值取至小數點兩位數
        DecimalFormat df=new DecimalFormat();
        bmi=Double.parseDouble(df.format(bmi));
        if(bmi<18.5){
            txtView.setText(bmi+"\n"+getString(R.string.bmiThin));
        }else if(bmi>24){
            txtView.setText(bmi+"\n"+getString(R.string.bmiFat));
        }else{
            txtView.setText(bmi+"\n"+getString(R.string.bmiOK));
        }
        return view;
    }
}
