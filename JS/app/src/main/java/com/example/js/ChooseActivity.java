package com.example.js;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

public class ChooseActivity extends AppCompatActivity {

    Button btn_Choicehome, btn_Choicestart;

    RadioGroup Radchoice, Radck;

    RadioButton RadHira ;
    RadioButton RadKata ;

    CheckBox[] Hira = new CheckBox[16];
    CheckBox[] Kata = new CheckBox[16];

    RadioButton ck5, ck10, ck15, ck20;
    int ck = 0;

    private static final int  _A= 0;
    private static final int  _K= 1;
    private static final int  _S= 2;
    private static final int  _T= 3;
    private static final int  _N= 4;
    private static final int  _H= 5;
    private static final int  _M= 6;
    private static final int  _Y= 7;
    private static final int  _R= 8;
    private static final int  _W= 9;
    private static final int  _O= 10;
    private static final int  _G= 11;
    private static final int  _J= 12;
    private static final int  _D= 13;
    private static final int  _B= 14;
    private static final int  _P= 15;

    TableLayout TabHira, TabKata;

    int WhatChoice = 0; //1==Hira,2==Kata

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        //Hira checkBox
        Hira[_A] = (CheckBox) findViewById(R.id.Cbx_Ha);
        Hira[_K] = (CheckBox) findViewById(R.id.Cbx_Hk);
        Hira[_S] = (CheckBox) findViewById(R.id.Cbx_Hs);
        Hira[_T] = (CheckBox) findViewById(R.id.Cbx_Ht);
        Hira[_N] = (CheckBox) findViewById(R.id.Cbx_Hn);
        Hira[_H] = (CheckBox) findViewById(R.id.Cbx_Hh);
        Hira[_M] = (CheckBox) findViewById(R.id.Cbx_Hm);
        Hira[_Y] = (CheckBox) findViewById(R.id.Cbx_Hy);
        Hira[_R] = (CheckBox) findViewById(R.id.Cbx_Hr);
        Hira[_W] = (CheckBox) findViewById(R.id.Cbx_Hw);
        Hira[_O] = (CheckBox) findViewById(R.id.Cbx_Ho);
        Hira[_G] = (CheckBox) findViewById(R.id.Cbx_Hg);
        Hira[_J] = (CheckBox) findViewById(R.id.Cbx_Hj);
        Hira[_D] = (CheckBox) findViewById(R.id.Cbx_Hd);
        Hira[_B] = (CheckBox) findViewById(R.id.Cbx_Hb);
        Hira[_P] = (CheckBox) findViewById(R.id.Cbx_Hp);
        //Kata checkBox
        Kata[_A] = (CheckBox) findViewById(R.id.Cbx_Ka);
        Kata[_K] = (CheckBox) findViewById(R.id.Cbx_Kk);
        Kata[_S] = (CheckBox) findViewById(R.id.Cbx_Ks);
        Kata[_T] = (CheckBox) findViewById(R.id.Cbx_Kt);
        Kata[_N] = (CheckBox) findViewById(R.id.Cbx_Kn);
        Kata[_H] = (CheckBox) findViewById(R.id.Cbx_Kh);
        Kata[_M] = (CheckBox) findViewById(R.id.Cbx_Km);
        Kata[_Y] = (CheckBox) findViewById(R.id.Cbx_Ky);
        Kata[_R] = (CheckBox) findViewById(R.id.Cbx_Kr);
        Kata[_W] = (CheckBox) findViewById(R.id.Cbx_Kw);
        Kata[_O] = (CheckBox) findViewById(R.id.Cbx_Ko);
        Kata[_G] = (CheckBox) findViewById(R.id.Cbx_Kg);
        Kata[_J] = (CheckBox) findViewById(R.id.Cbx_Kj);
        Kata[_D] = (CheckBox) findViewById(R.id.Cbx_Kd);
        Kata[_B] = (CheckBox) findViewById(R.id.Cbx_Kb);
        Kata[_P] = (CheckBox) findViewById(R.id.Cbx_Kp);

        ck5 = (RadioButton) findViewById(R.id.ck5);
        ck10 = (RadioButton) findViewById(R.id.ck10);
        ck15 = (RadioButton) findViewById(R.id.ck15);
        ck20 = (RadioButton) findViewById(R.id.ck20);

        btn_Choicehome = (Button) findViewById(R.id.btnChoicehome);
        btn_Choicestart = (Button) findViewById(R.id.btnChostart);
        Radchoice = (RadioGroup) findViewById(R.id.Rad_choice);
        Radck = (RadioGroup) findViewById(R.id.RadCk);
        TabHira = (TableLayout) findViewById(R.id.TabHira);
        TabKata = (TableLayout) findViewById(R.id.TabKata);

        RadHira = (RadioButton) findViewById(R.id.Rad_Hira);
        RadKata = (RadioButton) findViewById(R.id.Rad_Kata);

        btn_Choicehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btn_Choicestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (WhatChoice == 1) {
                    Intent intent = new Intent(getApplicationContext(), HiraganaActivity.class);

                    intent.putExtra("HiraCheck", Checked(view));
                    intent.putExtra("proNum",ck);
                    startActivity(intent);
                } else if (WhatChoice == 2) {
                    Intent intent = new Intent(getApplicationContext(), KatakanaActivity.class);

                    intent.putExtra("KataCheck", Checked(view));
                    intent.putExtra("proNum",ck);
                    ArrayList<Integer> vec = Checked(view);
                    Log.d("선택값", "123" + vec);
                    startActivity(intent);
                } else if (WhatChoice == 0) {
                    Toast.makeText(getApplicationContext(), "무엇을 공부할지 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Radchoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.Rad_Hira) {
                    TabHira.setVisibility(View.VISIBLE);
                    TabKata.setVisibility(View.GONE);
                    WhatChoice = 1;//Hira
                } else if (i == R.id.Rad_Kata) {
                    TabKata.setVisibility(View.VISIBLE);
                    TabHira.setVisibility(View.GONE);
                    WhatChoice = 2;//Kata
                }
            }
        });

        Radck.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.ck5)
                    ck = 5;
                else if (i == R.id.ck10)
                    ck = 10;
                else if (i == R.id.ck15)
                    ck = 15;
                else if (i == R.id.ck20)
                    ck = 20;
            }
        });
    }

    public ArrayList<Integer> Checked(View view){

        ArrayList<Integer> vector = new ArrayList<Integer>();
        for(int i = 0; i < 16; ++i)
        {
            if (RadHira.isChecked()) {
                if (Hira[i].isChecked()) {
                    for (int j = 0; j < 5; ++j)
                        vector.add(i * 5 + j);
                }
            } else if (RadKata.isChecked()) {
                if (Kata[i].isChecked())
                {
                    for(int j =0; j < 5; ++j)
                        vector.add(i*5+j);
                }
            }
        }
        return vector;
    }
}