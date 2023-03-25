package com.example.hangryapp;

import java.util.ArrayList;

public class FoodModel {
    String foodName;
    String price;

    public FoodModel(String foodName, String price) {
        this.foodName = foodName;
        this.price = price;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getPrice() {
        return price;
    }

    public static ArrayList<FoodModel> createFoodList(int numContacts) {
        ArrayList<FoodModel> contacts = new ArrayList<FoodModel>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new FoodModel("Person ", "1000"));
        }

        return contacts;
    }
}
