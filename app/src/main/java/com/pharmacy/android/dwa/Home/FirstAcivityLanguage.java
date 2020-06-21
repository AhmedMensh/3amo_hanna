package com.pharmacy.android.dwa.Home;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.Drivers.MainDrivers;
import com.pharmacy.android.dwa.LogReg.ChooseUser;
import com.pharmacy.android.dwa.LogReg.Login;
import com.pharmacy.android.dwa.LogReg.Regisration;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.SessionApp;

import java.util.Locale;

import spencerstudios.com.bungeelib.Bungee;

public class FirstAcivityLanguage extends AppCompatActivity {
    SessionApp sessionApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLanguageForApp("en");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_language);
sessionApp=new SessionApp(FirstAcivityLanguage.this);
        Typeface typeface= Typeface.createFromAsset(getAssets(), "fonts/LobsterTwo-Regular.ttf");

        TextView txtWelcom=findViewById(R.id.txtWelcom);
        txtWelcom.setTypeface(typeface);
        Button Arabic=findViewById(R.id.Ar);
        Button English=findViewById(R.id.En);


        English.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sessionApp.setLang("en");
                if(sessionApp.Logedin() && sessionApp.getUserType().equals("1")){
                    Intent intent=new Intent(FirstAcivityLanguage.this,MainHome.class);
                    finish();
                    startActivity(intent);
                    Bungee.fade(FirstAcivityLanguage.this);
                }else   if(sessionApp.Logedin() && sessionApp.getUserType().equals("2")){
                    Intent intent=new Intent(FirstAcivityLanguage.this,MainDrivers.class);
                    finish();
                    startActivity(intent);
                    Bungee.fade(FirstAcivityLanguage.this);
                }else{
                    Intent intent=new Intent(FirstAcivityLanguage.this,ChooseUser.class);
                    finish();
                    startActivity(intent);
                    Bungee.fade(FirstAcivityLanguage.this);
                }

            }
        });

        Arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

sessionApp.setLang("ar");
                if(sessionApp.Logedin() && sessionApp.getUserType().equals("1")){
                    Intent intent=new Intent(FirstAcivityLanguage.this,MainHome.class);
                    finish();
                    startActivity(intent);
                    Bungee.fade(FirstAcivityLanguage.this);
                }else   if(sessionApp.Logedin() && sessionApp.getUserType().equals("2")){
                    Intent intent=new Intent(FirstAcivityLanguage.this,MainDrivers.class);
                    finish();
                    startActivity(intent);
                    Bungee.fade(FirstAcivityLanguage.this);
                }else{
                    Intent intent=new Intent(FirstAcivityLanguage.this,ChooseUser.class);
                    finish();
                    startActivity(intent);
                    Bungee.fade(FirstAcivityLanguage.this);
                }



            }
        });
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
