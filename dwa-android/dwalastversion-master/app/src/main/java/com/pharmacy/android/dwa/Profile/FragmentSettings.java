package com.pharmacy.android.dwa.Profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.R;

public class FragmentSettings extends Fragment {

    View rootView;
    LinearLayout Notifi,NotNotifi;
    ImageView imgNotifi,imgNotNotifi;
    TextView  txtNotifi,txtNotNotifi;

    public FragmentSettings() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView=inflater.inflate(R.layout.fragment_setting, container, false);


        initiElement();

        ActionElement();
        return rootView;
    }
    public void initiElement(){

Notifi=rootView.findViewById(R.id.LayleftNot);
NotNotifi=rootView.findViewById(R.id.LayRighttNot);

imgNotifi=rootView.findViewById(R.id.imgleftNot);
imgNotNotifi=rootView.findViewById(R.id.imgRighttNot);

txtNotifi=rootView.findViewById(R.id.leftNot);
txtNotNotifi=rootView.findViewById(R.id.RighttNot);


        actionClick(1);
    }

    public void ActionElement(){

        Notifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionClick(1);
            }
        });
        NotNotifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionClick(2);
            }
        });
    }
    public  void setMessageToast(String mess)
    {
        Toast.makeText(getContext(),mess+"",Toast.LENGTH_SHORT).show();
    }

    public void actionClick(int id){
        switch (id){
            case 1:         Notifi.setBackground(getResources().getDrawable(R.drawable.border_profile_notif));
                txtNotifi.setTextColor(getResources().getColor(R.color.white));
                imgNotifi.setImageDrawable(getResources().getDrawable(R.drawable.enable_notification));

                NotNotifi.setBackground(null);
                txtNotNotifi.setTextColor(getResources().getColor(R.color.gray));
                imgNotNotifi.setImageDrawable(getResources().getDrawable(R.drawable.cloas_notification)); break;
            case 2:     Notifi.setBackground(null);
                txtNotifi.setTextColor(getResources().getColor(R.color.gray));
                imgNotifi.setImageDrawable(getResources().getDrawable(R.drawable.cloas_notification));

                NotNotifi.setBackground(getResources().getDrawable(R.drawable.border_profile_notif_raight));
                txtNotNotifi.setTextColor(getResources().getColor(R.color.white));
                imgNotNotifi.setImageDrawable(getResources().getDrawable(R.drawable.enable_notification));break;
        }
    }


}
