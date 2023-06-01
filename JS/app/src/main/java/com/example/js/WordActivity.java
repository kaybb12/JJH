package com.example.js;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class WordActivity extends AppCompatActivity {

    private Button btnTrans;
    private EditText edTrans;

    private TextView txtTrans;
    private String result;

    class BackgroundTask extends AsyncTask<Integer, Integer, Integer>{
        @Override
        protected Integer doInBackground(Integer... integers) {
            StringBuilder output = new StringBuilder();
            String clientID = "DPJtdhGUK3ywrhp3WgLT";
            String clientSecret = "fFKGnhdDnC";

            try{
                String text = URLEncoder.encode(edTrans.getText().toString(),"UTF-8");
                String apiURL = "https://openapi.naver.com/v1/papago/n2mt";

                URL url = new URL(apiURL);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("X-NAVER-Client-Id",clientID);
                con.setRequestProperty("X-NAVER-Client-Secret",clientSecret);

                String postParams = "source=ko&target=jp&text=" + text;
                con.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(con.getOutputStream());

                wr.writeBytes(postParams);
                wr.flush();
                wr.close();

                int responseCode = con.getResponseCode();
                BufferedReader br;
                if(responseCode == 200){
                    br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                }else{
                    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                }
                String inputLine;
                while ((inputLine = br.readLine()) != null){
                    output.append(inputLine);
                }
                br.close();
            } catch (Exception ex){
                Log.e("SampleHTTP","Exception in processing response.",ex);
                ex.printStackTrace();
            }
            result = output.toString();
            return null;
        }
        protected void onPostExecute(Integer a){
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
    }
}