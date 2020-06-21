package com.pharmacy.android.dwa.DataModel;

public class AddressDataModel {
    String Titel;
    String Address;

    public AddressDataModel(String titel, String address) {
        Titel = titel;
        Address = address;
    }

    public String getTitel() {
        return Titel;
    }

    public void setTitel(String titel) {
        Titel = titel;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
