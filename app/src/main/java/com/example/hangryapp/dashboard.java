package com.example.hangryapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class dashboard extends AppCompatActivity {

    Button scan;
    ImageView cart_view;
    ArrayList<FoodModel> foods = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        scan = findViewById(R.id.scan);
        cart_view = findViewById(R.id.cart_button);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(dashboard.this, "scanned", Toast.LENGTH_SHORT).show();
                scanCode();

                //Intent checkout = new Intent(dashboard.this,checkout.class);
                //startActivity(checkout);
            }
        });

        cart_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dashboard.this,checkout.class);
                startActivity(intent);
            }
        });
    }

    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("volume up to flash");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    }

    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(),result -> {
       if(result.getContents()!=null){
           AlertDialog.Builder builder = new AlertDialog.Builder(dashboard.this);
           builder.setTitle("Result");
           builder.setMessage(result.getContents());
           builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   dialogInterface.dismiss();
               }
           }).show();

           if(result.getContents().toString().contains("https://hangry.onrender.com/")){
               apiCall(result.getContents().toString());
           }
       }
    });

    protected void apiCall(String url){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        //url = "https://hangry.onrender.com/hotel";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray foodArray = obj.getJSONArray("foodItems");
                            foods.clear();

                            for (int i = 0; i < foodArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject foodObject = foodArray.getJSONObject(i);

                                //creating a tutorial object and giving them the values from json object
                                FoodModel food = new FoodModel(foodObject.getString("foodName"), foodObject.getString("price"));

                                //adding the tutorial to foodList
                                foods.add(food);

                                //recycler view implementation
                                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvFoodList);
                                RecyclerFoodAdapter adapter = new RecyclerFoodAdapter(foods,getApplicationContext());
                                recyclerView.setAdapter(adapter);
                                recyclerView.setLayoutManager(new LinearLayoutManager(dashboard.this));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.d("response successful", "onResponse: "+response);
                        Toast.makeText(dashboard.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("response error", "onErrorResponse: "+error );
                Toast.makeText(dashboard.this, String.valueOf(error), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);
    }


}