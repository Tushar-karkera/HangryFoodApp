package com.example.hangryapp;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerFoodAdapter extends RecyclerView.Adapter<RecyclerFoodAdapter.ViewHolder> {

    ArrayList<FoodModel> foodList;
    ArrayList<String> cart = new ArrayList<>();
    Integer total=0;
    Context context;
    RecyclerFoodAdapter(ArrayList<FoodModel> foodList,Context context){
        this.foodList = foodList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerFoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dashboard_item_1,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerFoodAdapter.ViewHolder holder, int position) {

        holder.foodName.setText(foodList.get(position).getFoodName());
        holder.price.setText("₹"+foodList.get(position).getPrice());
        //holder.img.setImageResource(R.drawable.plus_icon);
        //holder.img.setTag("plus");

        //FoodModel temp = foodList.get(position);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView img = (ImageView)view;
                Toast.makeText(context, "clicked "+String.valueOf(img.getTag()), Toast.LENGTH_SHORT).show();
//                if(holder.img.getTag().toString().equals("plus")){
//                    cart.add(foodList.get(position).foodName);
//                    total += Integer.parseInt(foodList.get(position).price);
//                    foodCart.setFoodItems(cart);
//                    foodCart.setPrice(total);
//                    holder.img.setImageResource(R.drawable.tick_icon);
//                    holder.img.setTag("tick");
//                    Toast.makeText(context, "cart is "+cart.toString()+" total amount is : "+String.valueOf(total), Toast.LENGTH_SHORT).show();
//                }else if(holder.img.getTag().toString().equals("tick")){
//                    cart.remove(cart.indexOf(holder.foodName.getText().toString()));
//                    total -= Integer.parseInt(foodList.get(position).price);
//                    holder.img.setImageResource(R.drawable.plus_icon);
//                    holder.img.setTag("plus");
//                    Toast.makeText(context, "cart is "+cart.toString()+" total amount is : "+String.valueOf(total), Toast.LENGTH_SHORT).show();
//                }

                if(img.getTag().toString().equals("plus")){
                    cart.add(foodList.get(position).foodName);
                    total += Integer.parseInt(foodList.get(position).price);
                    foodCart.setFoodItems(cart);
                    foodCart.setPrice(total);
                    img.setImageResource(R.drawable.tick_icon);
                    img.setTag("tick");
                    Toast.makeText(context, "cart is "+cart.toString()+" total amount is : "+String.valueOf(total), Toast.LENGTH_SHORT).show();
                }else if(img.getTag().toString().equals("tick")){
                    cart.remove(cart.indexOf(holder.foodName.getText().toString()));
                    total -= Integer.parseInt(foodList.get(position).price);
                    img.setImageResource(R.drawable.plus_icon);
                    img.setTag("plus");
                    Toast.makeText(context, "cart is "+cart.toString()+" total amount is : "+String.valueOf(total), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size()-1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView foodName ;
        TextView price;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodName =(TextView) itemView.findViewById(R.id.foodName_new);
            price =(TextView) itemView.findViewById(R.id.price_new);
            img = (ImageView) itemView.findViewById(R.id.cart_image_new);
        }
    }
}
