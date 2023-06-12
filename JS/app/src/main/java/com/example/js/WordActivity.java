package com.example.js;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class WordActivity extends AppCompatActivity {

  Button btnTrans, btnTransHome;
  EditText edTrans;
  TextView txtTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        btnTrans = (Button) findViewById(R.id.btnTrans);
        txtTrans = (TextView) findViewById(R.id.txtTrans);
        edTrans = (EditText) findViewById(R.id.edTrans);
        btnTransHome = (Button) findViewById(R.id.btnTranshome);

        btnTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackgroundTask task = new BackgroundTask();
                String tmp = edTrans.getText().toString();
                task.execute(tmp);
            }
        });

        btnTransHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
    class BackgroundTask extends AsyncTask<String,Void,String>{
        @RequiresApi(api= Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(String... str) {
            String inputTest = str[0];
            String clientId = "DUFUgQTEhwaLayTvrRuh";
            String clientSecret = "fmW7Soz_pn";
            String result ="";

            try {
                String text = URLEncoder.encode(inputTest,"UTF-8");// 번역할 문장 Edittext  입력
                String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
                URL url = new URL(apiURL);
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("X-Naver-Client-Id", clientId);
                con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
                // post request
                String postParams = "source=ko&target=ja&text=" + text;
                con.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                wr.writeBytes(postParams);
                wr.flush();
                wr.close();
                //번역 출력
                int responseCode = con.getResponseCode();
                BufferedReader br;
                if(responseCode==200) { // 정상 호출
                    br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                } else {  // 에러 발생
                    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                }
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                result = response.toString();
            } catch (Exception e) {
                result = "번역실패";
                System.out.println(e);
            }
            Log.d("papago",result);
            return result;
        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(s);
            String tmp = element.getAsJsonObject().get("message").getAsJsonObject().get("result").getAsJsonObject().get("translatedText").getAsString();
            txtTrans.setText(tmp);
        }
    }
}