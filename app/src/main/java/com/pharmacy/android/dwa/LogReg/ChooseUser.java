package com.pharmacy.android.dwa.LogReg;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.Home.MainHome;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.Constance;
import com.pharmacy.android.dwa.Utilities.SessionApp;

import java.util.Locale;

import spencerstudios.com.bungeelib.Bungee;

public class ChooseUser extends AppCompatActivity {
    SessionApp sessionApp;
     LinearLayout ContinueAsGestLayout;
    LinearLayout Customer;
    LinearLayout Driver;
    public static AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.3F);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sessionApp = new SessionApp(ChooseUser.this);
        setLanguageForApp(sessionApp.getLang());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_user);

        Typeface  typeface= Typeface.createFromAsset(getAssets(), "fonts/LobsterTwo-Regular.ttf");

        TextView txtWelcom=findViewById(R.id.txtWelcom);
        TextView haveHelthy=findViewById(R.id.haveHelthy);
        txtWelcom.setTypeface(typeface);
        haveHelthy.setTypeface(typeface);



        Customer=findViewById(R.id.customer);
         Driver=findViewById(R.id.driver);
        TextView Asguest=findViewById(R.id.asguest);
          ContinueAsGestLayout=findViewById(R.id.ContinueAsGestLayout);

        Customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setAnimation(buttonClick);
                Customer.setEnabled(false);
                Customer.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Customer.setEnabled(true);
                    }
                }, Constance.Timer);

              sessionApp.setUserType("1");


                Intent intent=new Intent(ChooseUser.this,Login.class);
                finish();
                startActivity(intent);
                Bungee.fade(ChooseUser.this);

            }
        });

        Driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setAnimation(buttonClick);
                Driver.setEnabled(false);
                Driver.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Driver.setEnabled(true);
                    }
                }, Constance.Timer);
                sessionApp.setUserType("2");
                Intent intent=new Intent(ChooseUser.this,Login.class);
                finish();
                startActivity(intent);
                Bungee.fade(ChooseUser.this);
            }
        });

        ContinueAsGestLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setAnimation(buttonClick);
                ContinueAsGestLayout.setEnabled(false);
                ContinueAsGestLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ContinueAsGestLayout.setEnabled(true);
                    }
                }, Constance.Timer);
                sessionApp.setUserType("3");
                Intent intent=new Intent(ChooseUser.this,MainHome.class);
                finish();
                startActivity(intent);
                Bungee.fade(ChooseUser.this);
            }
        });

    }

    @Override
    public void onBackPressed() {

        Intent intent=new Intent(ChooseUser.this,MainHome.class);
        finish();
        startActivity(intent);
        Bungee.fade(ChooseUser.this);
    }

    public  void setMessageToast(String mess){
        Toast.makeText(this,mess+"",Toast.LENGTH_SHORT).show();
    }

    private void setLanguageForApp(String languageToLoad) {
        Locale locale;
        if (languageToLoad.equals("en")) { //use any value for default
            //locale =  Resources.getSystem().getConfiguration().locale;
            locale = new Locale("en");
        } else {

            locale = new Locale(languageToLoad);

        }
        Locale.setDefault(locale);

        Configuration config = new Configuration();

        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());

    }
}
