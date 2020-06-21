package com.pharmacy.android.dwa.Utilities;

import android.content.Context;
import android.content.SharedPreferences;


public class SessionApp {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;

    public SessionApp(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences("myapp", context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void setLogedin(boolean login) {
        editor.putBoolean("logedin", login);
        editor.commit();

    }

    public boolean Logedin() {
        return preferences.getBoolean("logedin", false);
    }


    public void addToCartString(float price) {
        editor.putFloat("priceCart", price);
        editor.commit();

    }

    public float getCartString() {
        return preferences.getFloat("priceCart", 0);
    }

    public String getLang() {
        return preferences.getString("lang", "en");
    }

    public void setLang(String lang) {
        editor.putString("lang", lang);
        editor.commit();

    }

    //****userInfo

    public void setIdUser(String ID) {
        editor.putString("userID", ID);
        editor.commit();

    }

    public String getUserID() {
        return preferences.getString("userID", null);
    }

    public String getUserName() {
        return preferences.getString("userName", null);
    }

    public void setUserName(String ID) {
        editor.putString("userName", ID);
        editor.commit();

    }

    public String getUserPhone() {
        return preferences.getString("UserPhone", null);
    }

    public void setUserPhone(String ID) {
        editor.putString("UserPhone", ID);
        editor.commit();

    }

    public String getUserEmail() {
        return preferences.getString("UserEmail", null);
    }

    public void setUserEmail(String ID) {
        editor.putString("UserEmail", ID);
        editor.commit();

    }

    public String getUserAddress() {
        return preferences.getString("UserAddress", null);
    }

    public void setUserAddress(String ID) {
        editor.putString("UserAddress", ID);
        editor.commit();

    }

    public void setUserLongitiud(String ID) {
        editor.putString("Longitiud", ID);
        editor.commit();

    }

    public String getUserAddressLongitiud() {
        return preferences.getString("Longitiud", null);
    }

    public void setUserLatitud(String ID) {
        editor.putString("Latitud", ID);
        editor.commit();

    }

    public String getUserAddressLatitud() {
        return preferences.getString("Latitud", null);
    }

    public String getUserPassword() {
        return preferences.getString("Password", null);
    }

    public void setUserPassword(String ID) {
        editor.putString("Password", ID);
        editor.commit();

    }

    public String getUserType() {
        return preferences.getString("Type", "0");
    }

    public void setUserType(String Type) {
        editor.putString("Type", Type);
        editor.commit();

    }

    public String getUserToken() {
        return preferences.getString("Token", null);
    }

    public void setUserToken(String Token) {
        editor.putString("Token", Token);
        editor.commit();

    }


    public String getSignInType() {
        return preferences.getString("SignInType", "1");
    }

    public void setSignInType(String Token) {
        editor.putString("SignInType", Token);
        editor.commit();
    }

    public String getPaymentType() {
        return preferences.getString("payment", "1");
    }

    public void setPaymentType(String Token) {
        editor.putString("payment", Token);
        editor.commit();
    }


}
