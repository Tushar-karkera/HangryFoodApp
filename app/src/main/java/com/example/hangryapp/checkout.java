package com.example.hangryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class checkout extends AppCompatActivity {

    TextView orders , price,num1,num2,num3,num4,expiry,cardHolder;
    EditText cardNumber,editExpiry;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //orders = findViewById(R.id.ordered_items);
        price = findViewById(R.id.price_to_pay);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        editExpiry=findViewById(R.id.editExpiry);
        expiry =findViewById(R.id.textView4);
        cardHolder = findViewById(R.id.cardholder);
        button = findViewById(R.id.button);

         cardNumber = findViewById(R.id.editCardNumber);
//        StringBuilder foodItems = new StringBuilder();
//        for(String food : foodCart.getFoodItems()){
//            foodItems.append(food);
//        }
        //orders.setText(foodCart.getFoodItems().toString());
        price.setText("₹"+ foodCart.price);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cardnumber = cardNumber.getText().toString();
                num1.setText(cardnumber);
                num2.setText(splice(cardnumber,4,8));
                num3.setText(splice(cardnumber,8,12));
                num4.setText(splice(cardnumber,12,16));
                expiry.setText(editExpiry.getText().toString());
                cardHolder.setText(getIntent().getExtras().getString("userName").toUpperCase());
            }
        });

    }
    public String splice(String number,int start,int end){
        String temp = "";
        for(int i=start;i<end;i++){
            temp+= number.charAt(i);
        }
        return temp;
    }
}