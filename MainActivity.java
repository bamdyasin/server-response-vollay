package com.example.application;
 
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import com.android.volley.toolbox.StringRequest;
import java.lang.reflect.Method;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity { 
TextView textView;
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		textView = findViewById(R.id.activitymainTextView1);
        
        
        
        

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://earningaide.000webhostapp.com/app/info.php";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Display the first 500 characters of the response string.
                    textView.setText("Response is: \n" + response); //.substring(0,10)
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    textView.setText("That didn't work!");
                }
            });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
        
        
    }
	
} 
