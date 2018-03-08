package edu.cofc.csci490_lab_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("tag",aMethod("https://jsonplaceholder.typicode.com/users"));
        Log.i("tag","test");
    }

    private String aMethod( String stuff)
    {
        String rtnval= "testingValue";
        BufferedReader in;
        InputStreamReader isr;
        URLConnection connection;
        URL url;
        try {
            url = new URL(stuff);
            connection = url.openConnection();
            isr = new InputStreamReader((connection.getInputStream()));
            in = new BufferedReader(isr);
            rtnval = in.readLine();
        }
        catch (Exception e)
        {
            Log.i("exception", e.toString());
        }
        return rtnval;
    }
}
