package com.pharmacy.android.dwa.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.FragmentPages.MainFragmentSelect;
import com.pharmacy.android.dwa.Home.MainHome;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.Constance;
import com.pharmacy.android.dwa.Utilities.SessionApp;

import spencerstudios.com.bungeelib.Bungee;

public class FragmentSettings extends Fragment {

    View rootView;
    LinearLayout Notifi,NotNotifi;
    ImageView imgNotifi,imgNotNotifi;
    TextView  txtNotifi,txtNotNotifi;

    SessionApp sessionApp;
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

         sessionApp=new SessionApp(getContext());

        initiElement();

        ActionElement();
        return rootView;
    }
    public void initiElement(){

Notifi=rootView.findViewById(R.id.LayleftNot);
NotNotifi=rootView.findViewById(R.id.LayRighttNot);

imgNotifi=rootView.findViewById(R.id.imgleftNot);
imgNotNotifi=rootView.findViewById(R.id.imgRighttNot);

RadioButton Arabic=rootView.findViewById(R.id.arbic);
RadioButton English=rootView.findViewById(R.id.english);
RadioGroup radioGroup =rootView.findViewById(R.id.RadioGroup);
        if (sessionApp.getLang().equals("en")) {
            radioGroup.check(R.id.english);
        } else if (sessionApp.getLang().equals("ar")) {
            radioGroup.check(R.id.arbic);
        }
Arabic.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        sessionApp.setLang("ar");
        Intent intent=new Intent(getActivity(),MainHome.class);
        getActivity().finish();
        startActivity(intent);
        Bungee.fade(getActivity());
    }
});
 English.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         sessionApp.setLang("en");
         Intent intent=new Intent(getActivity(),MainHome.class);
         getActivity().finish();
         startActivity(intent);
         Bungee.fade(getActivity());
     }
 });


txtNotifi=rootView.findViewById(R.id.leftNot);
txtNotNotifi=rootView.findViewById(R.id.RighttNot);
        Button logOut=rootView.findViewById(R.id.logOut);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionApp.setLogedin(false);
                sessionApp.setUserType("0");
                Intent intent=new Intent(getActivity(),MainHome.class);
                getActivity().finish();
                startActivity(intent);
                Bungee.fade(getActivity());
            }
        });


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
            case 1:
                if(sessionApp.getLang().equals("en")) {
                    Notifi.setBackground(getResources().getDrawable(R.drawable.border_profile_notif));
                }
                else {
                    Notifi.setBackground(getResources().getDrawable(R.drawable.border_profile_notif_raight));
                }

                txtNotifi.setTextColor(getResources().getColor(R.color.white));
                imgNotifi.setImageDrawable(getResources().getDrawable(R.drawable.enable_notification));

                NotNotifi.setBackground(null);
                txtNotNotifi.setTextColor(getResources().getColor(R.color.gray));
                imgNotNotifi.setImageDrawable(getResources().getDrawable(R.drawable.cloas_notification))

                ; break;
            case 2:     Notifi.setBackground(null);
                txtNotifi.setTextColor(getResources().getColor(R.color.gray));
                imgNotifi.setImageDrawable(getResources().getDrawable(R.drawable.cloas_notification));

                if(sessionApp.getLang().equals("en")) {
                    NotNotifi.setBackground(getResources().getDrawable(R.drawable.border_profile_notif_raight));
                }
                else {
                    NotNotifi.setBackground(getResources().getDrawable(R.drawable.border_profile_notif));
                }

                txtNotNotifi.setTextColor(getResources().getColor(R.color.white));
                imgNotNotifi.setImageDrawable(getResources().getDrawable(R.drawable.enable_notification));break;
        }
    }

    public void loadFragmentWithOutAnim(Fragment fragment) {

        getActivity().getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        //  transaction.setCustomAnimations(R.anim.left_slid, 0, 0, R.anim.r_slide);
        transaction.addToBackStack(null);
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();


    }


}
