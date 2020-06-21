package com.pharmacy.android.dwa.DataModel;

public class ItemCartModel {


    String Name;
    String weight;
    String Count;
    String Price;
    String isTackPic;

    public ItemCartModel(String name, String weight, String count, String price, String isTackPic) {
        Name = name;
        this.weight = weight;
        Count = count;
        Price = price;
        this.isTackPic = isTackPic;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getIsTackPic() {
        return isTackPic;
    }

    public void setIsTackPic(String isTackPic) {
        this.isTackPic = isTackPic;
    }
}
