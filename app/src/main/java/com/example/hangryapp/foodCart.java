package com.example.hangryapp;

import java.util.ArrayList;

public class foodCart {
    static ArrayList<String> foodItems;
    static int price;

    public foodCart(ArrayList<String> foodItems , int price){
        foodCart.foodItems = foodItems;
        foodCart.price = price;
    }

    public static ArrayList<String> getFoodItems() {
        return foodItems;
    }

    public static void setFoodItems(ArrayList<String> foodItems) {
        foodCart.foodItems = foodItems;
    }

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        foodCart.price = price;
    }

    public static void clearCart(){
        foodItems.clear();
        price = 0;
    }
}
