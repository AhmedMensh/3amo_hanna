package com.pharmacy.android.dwa.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

public class FragmentMainProfile extends Fragment {

    View rootView;

    LinearLayout LayPersonal,LaySettings,LayAboutUs;
    ImageView imgPersonal,imgSetting,imgAboutUs;
    TextView personal,setting,aboutUs;




    public FragmentMainProfile() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView=inflater.inflate(R.layout.fragment_profile, container, false);
       Constance.MainFGragment=1;
        MainHome.back.setVisibility(View.VISIBLE);
        MainHome.Scan.setVisibility(View.GONE);

        MainHome.title.setText(R.string.profile);
        MainHome.subTitle.setText(R.string.personalInfo);
        initiElement();

        ActionElement();
        return rootView;
    }
    public void initiElement(){

        LayPersonal=rootView.findViewById(R.id.LayPersonal);
        LaySettings=rootView.findViewById(R.id.LaySetting);
        LayAboutUs=rootView.findViewById(R.id.LayAboutUs);
        imgPersonal=rootView.findViewById(R.id.imgPersonal);
        imgSetting=rootView.findViewById(R.id.imgSetting);
        imgAboutUs=rootView.findViewById(R.id.imgAboutUs);
        personal=rootView.findViewById(R.id.Personal);
        setting=rootView.findViewById(R.id.setting);
        aboutUs=rootView.findViewById(R.id.AboutUs);
        NavigationClick(1);

    }

    public void ActionElement(){
        LayPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setAnimation(MainHome.buttonClick);
                NavigationClick(1);
            }
        });

        LaySettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setAnimation(MainHome.buttonClick);
                NavigationClick(2);
            }
        });

        LayAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setAnimation(MainHome.buttonClick);
                NavigationClick(3);
            }
        });

    }

    public void NavigationClick(int id){

        switch (id){
            case 1:
                imgPersonal.setImageDrawable(getResources().getDrawable(R.drawable.pr_a1));
                personal.setTextColor(getResources().getColor(R.color.white));

                imgSetting.setImageDrawable(getResources().getDrawable(R.drawable.pr_b2));
                setting.setTextColor(getResources().getColor(R.color.gray));

                imgAboutUs.setImageDrawable(getResources().getDrawable(R.drawable.pr_c2));
                aboutUs.setTextColor(getResources().getColor(R.color.gray));
                LayPersonal.setBackgroundColor(getResources().getColor(R.color.RedDark));
                LaySettings.setBackground(getResources().getDrawable(R.drawable.boredrcorner5dp));
                LayAboutUs.setBackground(getResources().getDrawable(R.drawable.boredrcorner5dp));
                loadFragmentWithOutAnim(new FragmentPersonal());
                break;

            case 2:
                imgPersonal.setImageDrawable(getResources().getDrawable(R.drawable.pr_a2));
                personal.setTextColor(getResources().getColor(R.color.gray));

                imgSetting.setImageDrawable(getResources().getDrawable(R.drawable.pr_b1));
                setting.setTextColor(getResources().getColor(R.color.white));

                imgAboutUs.setImageDrawable(getResources().getDrawable(R.drawable.pr_c2));
                aboutUs.setTextColor(getResources().getColor(R.color.gray));
                LaySettings.setBackgroundColor(getResources().getColor(R.color.RedDark));
                LayPersonal.setBackground(getResources().getDrawable(R.drawable.boredrcorner5dp));
                LayAboutUs.setBackground(getResources().getDrawable(R.drawable.boredrcorner5dp));

                loadFragmentWithOutAnim(new FragmentSettings());

                break;

            case 3:
                imgPersonal.setImageDrawable(getResources().getDrawable(R.drawable.pr_a2));
                personal.setTextColor(getResources().getColor(R.color.gray));

                imgSetting.setImageDrawable(getResources().getDrawable(R.drawable.pr_b2));
                setting.setTextColor(getResources().getColor(R.color.gray));

                imgAboutUs.setImageDrawable(getResources().getDrawable(R.drawable.pr_c1));
                aboutUs.setTextColor(getResources().getColor(R.color.white));
                LayAboutUs.setBackgroundColor(getResources().getColor(R.color.RedDark));
                LayPersonal.setBackground(getResources().getDrawable(R.drawable.boredrcorner5dp));
                LaySettings.setBackground(getResources().getDrawable(R.drawable.boredrcorner5dp));
                loadFragmentWithOutAnim(new FragmentAbouUs());
                break;
        }

    }
    public  void setMessageToast(String mess)
    {
        Toast.makeText(getContext(),mess+"",Toast.LENGTH_SHORT).show();
    }


    public void loadFragmentWithOutAnim(Fragment fragment) {

       // getActivity().getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        //  transaction.setCustomAnimations(R.anim.left_slid, 0, 0, R.anim.r_slide);
        transaction.addToBackStack(null);
        transaction.replace(R.id.frame_Profile_contener, fragment);
        transaction.commit();


    }

}
