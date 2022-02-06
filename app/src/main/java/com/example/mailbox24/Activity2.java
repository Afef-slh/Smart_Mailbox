package com.example.mailbox24;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Activity2 extends AppCompatActivity {

    private TextView textView;
    EditText et_dataInput;
    TextView result;

    //String myUrl = "https://172.20.10.5/";


    Button displayData;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        // assign value to each control in layout
        displayData = findViewById(R.id.displayData);
        result = findViewById(R.id.results);

        // click listener to button
        displayData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(Activity2.this);
                String url ="http://172.20.10.5/message";
                //JsonArrayRequest request = new JsonArrayRequest
                        //(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                            //@Override
                            //public void onResponse(JSONArray response) {
                                //String title="";
                                //try {
                                    //JSONObject data = response.getJSONObject(0);
                                     //title = data.getString("woeid");
                                //} catch (JSONException e) {
                                    //e.printStackTrace();
                                //}

                                //result.setText("message recu est " + title);

                               // Toast.makeText(Activity2.this, "Refresh ",Toast.LENGTH_SHORT).show();
                            //}
                        //}, new Response.ErrorListener() {

                            //@Override
                            //public void onErrorResponse(VolleyError error) {
                                //Toast.makeText(Activity2.this,"error",Toast.LENGTH_SHORT).show();

                          //  }
                       // });
               // queue.add(request);

// Access the RequestQueue through your singleton class.

// Request a string response from the provided URL.
               StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {

                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(Activity2.this,response,Toast.LENGTH_SHORT).show();

                                System.out.println(response);
                                //Log.e(response);

                                result.setText("message recu est " + response);

                               
                            }
                        }, new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {
                       String body="";
                       //get status code here
                       final String statusCode = String.valueOf(error.networkResponse.statusCode);
                       //get response body and parse with appropriate encoding
                       try {
                           body = new String(error.networkResponse.data,"UTF-8");
                       } catch (UnsupportedEncodingException e) {
                           // exception
                       }
                        Toast.makeText(Activity2.this,body,Toast.LENGTH_SHORT).show();
                        System.out.println("error");

                    }
               });

// Add the request to the RequestQueue.
               queue.add(stringRequest);
               Toast.makeText(Activity2.this,"Refresh",Toast.LENGTH_SHORT).show();

            }
        });

    }













}