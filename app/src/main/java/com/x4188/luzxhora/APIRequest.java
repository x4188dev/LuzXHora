package com.x4188.luzxhora;
import android.os.AsyncTask;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class APIRequest extends AsyncTask<String,String,String> {

    @Override
    protected String doInBackground(String... strings) {
        URL url = null;
        try {
            url = new URL(strings[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection conn;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.connect();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String content = "", line;
            while ((line = rd.readLine()) != null) {
                content += line + "\n";
            }
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "0";
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }
}