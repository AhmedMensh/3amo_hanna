package com.pharmacy.android.dwa.Cart;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pharmacy.android.dwa.Home.MainHome;
import com.pharmacy.android.dwa.LogReg.Login;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.Constance;
import com.pharmacy.android.dwa.Utilities.SessionApp;

import java.util.Locale;

import spencerstudios.com.bungeelib.Bungee;

public class MainCart extends AppCompatActivity {
    public static TextView title, subTitle, coora1, coora2, coora3, coora4;
    public static AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.3F);
    public static TextView TitleFragment;
    public LinearLayout back;
    SessionApp sessionApp;
    ActionBar mActionBar;
    View actionBar;
    LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sessionApp = new SessionApp(MainCart.this);
        setLanguageForApp(sessionApp.getLang());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cart);
        loadActionBar();
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/LobsterTwo-Regular.ttf");
        TitleFragment = findViewById(R.id.txtTitle);
        TitleFragment.setTypeface(typeface);
        initElement();

    }

    public void initElement() {

        coora1 = findViewById(R.id.coora1);
        coora2 = findViewById(R.id.coora2);
        coora3 = findViewById(R.id.coora3);
        coora4 = findViewById(R.id.coora4);

        loadFragmentWithOutAnim(new FragmentCartProducts());
        coora1.setBackground(getResources().getDrawable(R.drawable.coora1));
        coora2.setBackground(getResources().getDrawable(R.drawable.coora));
        coora3.setBackground(getResources().getDrawable(R.drawable.coora));
        coora4.setBackground(getResources().getDrawable(R.drawable.coora));

    }

    public void loadActionBar() {
        mActionBar = getSupportActionBar();
        assert mActionBar != null;
        mActionBar.setElevation(0);
        mActionBar.setTitle(null);

        mInflater = LayoutInflater.from(this);
        actionBar = mInflater.inflate(R.layout.custom_action_bar_cart, null);


        back = actionBar.findViewById(R.id.back);
        title = actionBar.findViewById(R.id.title);
        subTitle = actionBar.findViewById(R.id.subTitle);

        title.setText(getString(R.string.cart));
//        subTitle.setText(getString(R.string.youhave6));

        mActionBar.setCustomView(actionBar);
        mActionBar.setDisplayShowCustomEnabled(true);
        ((Toolbar) actionBar.getParent()).setContentInsetStartWithNavigation(0);
        ((Toolbar) actionBar.getParent()).setContentInsetsRelative(0, 0);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setAnimation(buttonClick);
                back.setEnabled(false);
                back.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        back.setEnabled(true);
                    }
                }, Constance.Timer);
                Intent intent = new Intent(MainCart.this, MainHome.class);
                finish();
                startActivity(intent);
                Bungee.fade(MainCart.this);
            }
        });

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


    public void loadFragmentWithOutAnim(Fragment fragment) {
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //  transaction.setCustomAnimations(R.anim.left_slid, 0, 0, R.anim.r_slide);
        transaction.addToBackStack(null);
        transaction.replace(R.id.frame_container_cart, fragment);
        transaction.commit();


    }

    @Override
    public void onBackPressed() {

        Intent intent=new Intent(MainCart.this,MainHome.class);
        finish();
        startActivity(intent);
        Bungee.fade(MainCart.this);
    }
}
