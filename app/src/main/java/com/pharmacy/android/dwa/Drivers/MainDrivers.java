package com.pharmacy.android.dwa.Drivers;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.DriverFragments.FragmentNewOrderDriver;
import com.pharmacy.android.dwa.DriverFragments.FragmentDeliveredOrderDriver;
import com.pharmacy.android.dwa.Home.MainHome;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.Constance;
import com.pharmacy.android.dwa.Utilities.SessionApp;

import java.util.Locale;

import spencerstudios.com.bungeelib.Bungee;

public class MainDrivers extends AppCompatActivity {
    ActionBar mActionBar;
    View actionBar;
    LayoutInflater mInflater;

    LinearLayout nav1,nav2, nav3;
    TextView navTxt1,navTxt2, navTxt3;

    public static AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.3F);

    ImageView navImg1,navImg2,navImg3;
    SessionApp sessionApp;


    public static TextView title,subTitle;

    public static Typeface typeface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sessionApp = new SessionApp(MainDrivers.this);
        setLanguageForApp(sessionApp.getLang());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_driver);

         typeface= Typeface.createFromAsset(getAssets(), "fonts/LobsterTwo-Regular.ttf");
        loadActionBar();

        nav1=findViewById(R.id.nav1);
        nav2=findViewById(R.id.nav2);
        nav3=findViewById(R.id.nav3);

        navImg1=findViewById(R.id.imgNav1);
        navImg2=findViewById(R.id.imgNav2);
        navImg3=findViewById(R.id.imgNav3);


        navTxt1=findViewById(R.id.txtNav1);
        navTxt2=findViewById(R.id.txtNav2);
        navTxt3=findViewById(R.id.txtNav3);

        BottomNavigation(R.id.nav1);

        actionsClick();
    }

    public void loadActionBar(){
        mActionBar = getSupportActionBar();
        assert mActionBar != null;
        mActionBar.setElevation(0);
        mActionBar.setTitle(null);

        mInflater = LayoutInflater.from(this);
        actionBar = mInflater.inflate(R.layout.custom_action_bar_driver, null);


         title=actionBar.findViewById(R.id.title);
         subTitle=actionBar.findViewById(R.id.subTitle);

        mActionBar.setCustomView(actionBar);
        mActionBar.setDisplayShowCustomEnabled(true);
        ((Toolbar) actionBar.getParent()).setContentInsetStartWithNavigation(0);
        ((Toolbar) actionBar.getParent()).setContentInsetsRelative(0, 0);



    }


    public void BottomNavigation(int ID){
        switch (ID)
        {
            case R.id.nav1:
                navImg1.setImageDrawable(getResources().getDrawable(R.drawable.new_order_true));
                navImg2.setImageDrawable(getResources().getDrawable(R.drawable.deliverd_order));
                navImg3.setImageDrawable(getResources().getDrawable(R.drawable.started));
                navTxt1.setTextColor(getResources().getColor(R.color.black));
                navTxt2.setTextColor(getResources().getColor(R.color.gray));
                navTxt3.setTextColor(getResources().getColor(R.color.gray));

                loadFragmentWithOutAnim(new FragmentNewOrderDriver());
                break;
            case R.id.nav2:

                    navImg1.setImageDrawable(getResources().getDrawable(R.drawable.new_order));
                    navImg2.setImageDrawable(getResources().getDrawable(R.drawable.deliverd_oredr_true));
                    navImg3.setImageDrawable(getResources().getDrawable(R.drawable.started));
                    navTxt1.setTextColor(getResources().getColor(R.color.gray));
                    navTxt2.setTextColor(getResources().getColor(R.color.black));
                    navTxt3.setTextColor(getResources().getColor(R.color.gray));
                   loadFragmentWithOutAnim(new FragmentDeliveredOrderDriver());

                break;
            case R.id.nav3:
                navImg1.setImageDrawable(getResources().getDrawable(R.drawable.new_order));
                navImg2.setImageDrawable(getResources().getDrawable(R.drawable.deliverd_order));
                navImg3.setImageDrawable(getResources().getDrawable(R.drawable.started_now));
                navTxt1.setTextColor(getResources().getColor(R.color.gray));
                navTxt2.setTextColor(getResources().getColor(R.color.gray));
                navTxt3.setTextColor(getResources().getColor(R.color.black));

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainDrivers.this, MainHome.class);
                        finish();
                        startActivity(intent);
                        Bungee.fade(MainDrivers.this);
                        sessionApp.setLogedin(false);
                        sessionApp.setUserType("0");
                    }
                },500);
                break;


        }

    }


    public void actionsClick(){
        nav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setAnimation(buttonClick);
                nav1.setEnabled(false);
                nav1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nav1.setEnabled(true);
                    }
                },Constance.Timer);
                BottomNavigation(R.id.nav1);
            }
        });


        nav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setAnimation(buttonClick);
                nav2.setEnabled(false);
                nav2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nav2.setEnabled(true);
                    }
                },Constance.Timer);
                BottomNavigation(R.id.nav2);
            }
        });
        nav3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setAnimation(buttonClick);
                nav3.setEnabled(false);
                nav3.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nav3.setEnabled(true);
                    }
                },Constance.Timer);
                BottomNavigation(R.id.nav3);
            }
        });

    }
    public void loadFragmentWithOutAnim(Fragment fragment) {
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //  transaction.setCustomAnimations(R.anim.left_slid, 0, 0, R.anim.r_slide);
        transaction.addToBackStack(null);
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();


    }

    @Override
    public void onBackPressed() {
        if(Constance.MainFGragment==1){
            BottomNavigation(R.id.nav1);
            Constance.MainFGragment=0;

        }
        else if(Constance.MainFGragment==0){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else {
            super.onBackPressed();
            Constance.MainFGragment=1;
        }


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


/*




    int RESULT_LOAD_IMAGE = 1;
    int TAKE_PICTURE=2;
    final int REQUEST_CODE_ASK_PERMISSIONS = 123;
    final int REQUEST_CODE_ASK_PERMISSIONS1= 124;
    ImageView loadImg;





    public void ScanContent() {
        LayoutInflater inf = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        android.support.v7.app.AlertDialog.Builder mBuilder =
                new android.support.v7.app.AlertDialog.Builder(MainHome.this,R.style.DialogTheme);
        final View mView = inf.inflate(R.layout.content_scan, null, true);


        LinearLayout back =mView.findViewById(R.id.back);
         loadImg=mView.findViewById(R.id.imgTake);

        LinearLayout nav1 =mView.findViewById(R.id.nav1);
        LinearLayout nav2 =mView.findViewById(R.id.nav2);
        LinearLayout nav3 =mView.findViewById(R.id.nav3);




        nav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckUserPermsions();
            }
        });
        nav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCameraPermission();
            }
        });

        nav3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadImg.setImageBitmap(null);
            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // view.startAnimation(buttonClick);
                dialog.dismiss();
            }
        });
        mBuilder.setView(mView);
        dialog = mBuilder.create();
       // dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setLayout(WindowManager.LayoutParams.FILL_PARENT,
                WindowManager.LayoutParams.FILL_PARENT);

        dialog.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    LoadImage();
                } else {
                    Toast.makeText(MainHome.this, "gallery access deny", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            case REQUEST_CODE_ASK_PERMISSIONS1:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    takePictuer();
                } else {
                    Toast.makeText(MainHome.this, "camera access deny", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath1 = cursor.getString(columnIndex);
            cursor.close();

            loadImg.setImageBitmap(BitmapFactory.decodeFile(picturePath1));
            loadImg.setVisibility(View.VISIBLE);
        }else if(requestCode == TAKE_PICTURE && resultCode == RESULT_OK && null != data){
            Bitmap photo = (Bitmap)data.getExtras().get("data");
            loadImg.setImageBitmap(photo);
            loadImg.setVisibility(View.VISIBLE);
        }
    }

    void LoadImage() {

            Intent i = new Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

            startActivityForResult(i, RESULT_LOAD_IMAGE);



    }

    void  takePictuer(){

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, TAKE_PICTURE);
    }
    public void CheckUserPermsions() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(getBaseContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                                android.Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }
        }

        LoadImage();

    }
    private void checkCameraPermission(){
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.CAMERA) !=
                    PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                                android.Manifest.permission.CAMERA},
                        REQUEST_CODE_ASK_PERMISSIONS1);
                return;
            }
        }
        takePictuer();
    }

 */