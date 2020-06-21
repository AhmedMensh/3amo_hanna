package com.pharmacy.android.dwa.MessageApp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.Home.MainHome;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.Constance;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FragmentMessages extends Fragment {

    View rootView;
    LinearLayout lin_layout;
    RelativeLayout rel_layout;
    ImageView sendMess;
    EditText messageArea;
    ScrollView scrollView;



    public FragmentMessages() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView=inflater.inflate(R.layout.fragment_messages, container, false);
       Constance.MainFGragment=1;
        MainHome.back.setVisibility(View.VISIBLE);
        MainHome.Scan.setVisibility(View.GONE);

        MainHome.title.setText(R.string.chat);
        MainHome.subTitle.setText(R.string.how_help_you);
        initiElement();

        ActionElement();
        return rootView;
    }
    public void initiElement(){

        lin_layout = rootView.findViewById(R.id.lin_layout);
       // rel_layout = rootView.findViewById(R.id.rel_layout);
        sendMess = rootView.findViewById(R.id.send);
        messageArea =rootView.findViewById(R.id.input_mess);
        scrollView = rootView.findViewById(R.id.scrollView1);
        scrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        }, Constance.Timer);
    }

    public void ActionElement(){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd , HH:mm:ss");
         String strDate1 = sdf.format(new Date());
        addMessageBox( "Hi, how we can help you :) ?", 2, strDate1);



        sendMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = messageArea.getText().toString();
                if (!messageText.equals("")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd , HH:mm:ss");
                    final String strDate1 = sdf.format(new Date());
                    addMessageBox( messageText, 1, strDate1);
                    messageArea.setText("");

                    addMessageBox( "ok, we will do that", 2, strDate1);
                }


            }
        });

    }
    public  void setMessageToast(String mess)
    {
        Toast.makeText(getContext(),mess+"",Toast.LENGTH_SHORT).show();
    }


    public void addMessageBox( String message, int type, String datesend) {
        LayoutInflater inf = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);



        if (type == 1) {
            View  mView = inf.inflate(R.layout.content_messages_end, null, true);
            TextView messSEND = mView.findViewById(R.id.messEnd);
            final TextView   dateMess = mView.findViewById(R.id.date);
            TextView sender = mView.findViewById(R.id.sender);
            messSEND.setText(message);
            dateMess.setText(datesend);
            dateMess.setVisibility(View.GONE);
            sender.setTypeface(MainHome.typeface);
            lin_layout.addView(mView);
            messSEND.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(dateMess.getVisibility() == View.VISIBLE) {
                        dateMess.setVisibility(View.GONE);
                    }else if(dateMess.getVisibility() == View.GONE){
                        dateMess.setVisibility(View.VISIBLE);
                    }
                }
            });
        } else {
            View  mView = inf.inflate(R.layout.content_messages_start, null, true);
            TextView messSEND = mView.findViewById(R.id.messEnd);
            final TextView   dateMess = mView.findViewById(R.id.date);
            TextView sender = mView.findViewById(R.id.sender);
            messSEND.setText(message);
            dateMess.setText(datesend);
            dateMess.setVisibility(View.GONE);
            sender.setTypeface(MainHome.typeface);
            lin_layout.addView(mView);
            messSEND.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(dateMess.getVisibility() == View.VISIBLE) {
                        dateMess.setVisibility(View.GONE);
                    }else if(dateMess.getVisibility() == View.GONE){
                        dateMess.setVisibility(View.VISIBLE);
                    }
                }
            });
        }


        scrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        }, Constance.Timer);
    }

}
