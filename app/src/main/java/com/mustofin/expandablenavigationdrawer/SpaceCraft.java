package com.mustofin.expandablenavigationdrawer;

import android.widget.ImageView;

public class SpaceCraft {

//    String name, propellant;
//    int image;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPropellant() {
//        return propellant;
//    }
//
//    public void setPropellant(String propellant) {
//        this.propellant = propellant;
//    }
//
//    public int getImage() {
//        return image;
//    }
//
//    public void setImage(int image) {
//        this.image = image;
//    }

    private int id;
    private String name;
    private String address;
    private String tel;
    private String goldcard;
    private String standardcard;
    private String imageUrl;

    public SpaceCraft(int id, String name, String address, String tel, String goldcard, String standardcard, String imageUrl) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.goldcard = goldcard;
        this.standardcard = standardcard;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    public String getGoldcard() {
        return goldcard;
    }

    public String getStandardcard() {
        return standardcard;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
