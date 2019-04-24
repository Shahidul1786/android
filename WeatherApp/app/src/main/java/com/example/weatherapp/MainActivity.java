package com.example.weatherapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    EditText cityName;
    Button serchButton;

    class Weather extends AsyncTask<String,Void,String>{

        public void SearchCity(View view){

            cityName = findViewById(R.id.editTextCityNameId);
            serchButton = findViewById(R.id.buttonSearchId);

            String cName = cityName.getText().toString();


            String content ;
            Weather weather = new Weather();

            try {
                content = weather.execute("https://openweathermap.org/data/2.5/weather?q="+cName+"Bangladesh&appid=b6907d289e10d714a6e88b30761fae22").get();

                Log.i("contentData",content);

                //JSON

                JSONObject jsonObject = new JSONObject(content);

                String weatherData = jsonObject.getString("weather");
                Log.i("weatherData",weatherData);

                //JSON Array
                JSONArray jsonArray = new JSONArray(weatherData);
                String main = "";
                String description="";

                for (int i= 0; i<jsonArray.length();i++){
                    JSONObject weatherPart = jsonArray.getJSONObject(i);
                    main =weatherPart.getString("main");
                    description =weatherPart.getString("description");
                }
                Log.i("main",main);
                Log.i("description",description);

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        @Override
        protected String doInBackground(String... address) {

            //String means multipule address can be send as array

            try {
                URL url = new URL(address[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                //estabilsh connection with address
                connection.connect();

                //retrieve data from url
                InputStream is = connection.getInputStream();

                InputStreamReader isr = new InputStreamReader(is);

                //retrieve data and return as String

                int data = isr.read();

                String content= "";
                char ch;

                while (data != -1){
                    ch= (char) data;
                    content = content+ch;

                    data =isr.read();
                }

                return  content;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    }

