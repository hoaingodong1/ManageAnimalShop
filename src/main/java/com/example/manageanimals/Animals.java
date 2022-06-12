package com.example.manageanimals;

import java.sql.Date;

public class Animals {
    public int id;
    public String name;
    public String type;
    public String gender;
    public String image;
    public Float height;
    public Float weight;
    public String birthday;
    public Float price;


    public Animals(int id, String name, String type, String gender, String image, float height, float weight, String birthday, float price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.gender = gender;
        this.image = image;
        this.height = height;
        this.weight = weight;
        this.birthday = birthday;
        this.price = price;
    }
    public Animals( String name, String type,String gender, String image, Float height, Float weight, String birthday, Float price) {
        this.name = name;
        this.type = type;
        this.gender=gender;
        this.image = image;
        this.height = height;
        this.weight = weight;
        this.birthday = birthday;
        this.price = price;
    }

    public Animals(String name, String type, String gender, String image, float weight, float height, String birthday, float price, int id) {
        this.name=name;
        this.type=type;
        this.gender=gender;
        this.image=image;
        this.weight=weight;
        this.height=height;
        this.birthday=birthday;
        this.price=price;
        this.id=id;
    }
}


//    public int getId() {
//        return id;
//    }
//    public String getName() {
//        return name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public Double getHeight() {
//        return height;
//    }
//
//    public Double getWeight() {
//        return weight;
//    }
//
//    public Date getBirthday() {
//        return birthday;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//
//
//
//
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setName() {
//        this.name = name;
//    }
//
//    public void setType() {
//        this.type = type;
//    }
//
//    public void setGender() {
//        this.gender = gender;
//    }
//
//    public void setImage() {
//        this.image = image;
//    }
//
//    public void setHeight() {
//        this.height = height;
//    }
//
//    public void setWeight() {
//        this.weight = weight;
//    }
//
//    public void setBirthday() {
//        this.birthday = birthday;
//    }
//
//    public void setPrice() {
//        this.price = price;
//    }
//}

