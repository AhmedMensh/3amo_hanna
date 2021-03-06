package com.pharmacy.android.dwa.LogReg;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.Drivers.MainDrivers;
import com.pharmacy.android.dwa.Home.MainHome;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.Constance;
import com.pharmacy.android.dwa.Utilities.SessionApp;

import java.util.Locale;

import spencerstudios.com.bungeelib.Bungee;

public class Login extends AppCompatActivity {
    SessionApp sessionApp;
     LinearLayout ContinueAsGestLayout;
    Button Login;
    Button signUp;
    EditText name,password;
    public static AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.3F);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sessionApp = new SessionApp(Login.this);
        setLanguageForApp(sessionApp.getLang());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Typeface  typeface= Typeface.createFromAsset(getAssets(), "fonts/LobsterTwo-Regular.ttf");

        TextView txtWelcom=findViewById(R.id.txtWelcom);
        txtWelcom.setTypeface(typeface);

        name=findViewById(R.id.name);
        password=findViewById(R.id.password);

         Login=findViewById(R.id.Login);
         signUp=findViewById(R.id.signUp);
        TextView Asguest=findViewById(R.id.asguest);
          ContinueAsGestLayout=findViewById(R.id.ContinueAsGestLayout);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setAnimation(buttonClick);
                Login.setEnabled(false);
                Login.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Login.setEnabled(true);
                    }
                }, Constance.Timer);
            if(name.getText().toString().equals("user") && password.getText().toString().equals("123456") && sessionApp.getUserType().equals("1")){
                sessionApp.setLogedin(true);
                Intent intent=new Intent(Login.this,MainHome.class);
                finish();
                startActivity(intent);
                Bungee.fade(Login.this);
            }else if(name.getText().toString().equals("driver") && password.getText().toString().equals("123123") && sessionApp.getUserType().equals("2")) {
                sessionApp.setLogedin(true);
                Intent intent=new Intent(Login.this,MainDrivers.class);
                finish();
                startActivity(intent);
                Bungee.fade(Login.this);
            }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setAnimation(buttonClick);
                signUp.setEnabled(false);
                signUp.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        signUp.setEnabled(true);
                    }
                }, Constance.Timer);
                Intent intent=new Intent(Login.this,Regisration.class);
                finish();
                startActivity(intent);
                Bungee.fade(Login.this);
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
                Intent intent=new Intent(Login.this,MainHome.class);
                finish();
                startActivity(intent);
                Bungee.fade(Login.this);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Login.this,ChooseUser.class);
        finish();
        startActivity(intent);
        Bungee.fade(Login.this);
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
