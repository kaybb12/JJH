package com.example.js;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.Toast;

public class ChooseActivity extends AppCompatActivity {

    Button btn_Choicehome, btn_Choicestart;

    RadioGroup Radchoice;

    RadioButton RadHira, RadKata;

    CheckBox Ha, Hk, Hs, Ht, Hn, Hh, Hm, Hy, Hr, Hw, Ho, Hg, Hj, Hd, Hb, Hp;
    CheckBox Ka, Kk, Ks, Kt, Kn, Kh, Km, Ky, Kr, Kw, Ko, Kg, Kj, Kd, Kb, Kp;

    TableLayout TabHira, TabKata;

    int WhatChoice = 0; //1==Hira,2==Kata

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        //Hira checkBox
        Ha = (CheckBox) findViewById(R.id.Cbx_Ha);
        Hk = (CheckBox) findViewById(R.id.Cbx_Hk);
        Hs = (CheckBox) findViewById(R.id.Cbx_Hs);
        Ht = (CheckBox) findViewById(R.id.Cbx_Ht);
        Hn = (CheckBox) findViewById(R.id.Cbx_Hn);
        Hh = (CheckBox) findViewById(R.id.Cbx_Hh);
        Hm = (CheckBox) findViewById(R.id.Cbx_Hm);
        Hy = (CheckBox) findViewById(R.id.Cbx_Hy);
        Hr = (CheckBox) findViewById(R.id.Cbx_Hr);
        Ho = (CheckBox) findViewById(R.id.Cbx_Ho);
        Hg = (CheckBox) findViewById(R.id.Cbx_Hg);
        Hj = (CheckBox) findViewById(R.id.Cbx_Hj);
        Hd = (CheckBox) findViewById(R.id.Cbx_Hd);
        Hb = (CheckBox) findViewById(R.id.Cbx_Hb);
        Hp = (CheckBox) findViewById(R.id.Cbx_Hp);
        //Kata checkBox
        Ka = (CheckBox) findViewById(R.id.Cbx_Ka);
        Kk = (CheckBox) findViewById(R.id.Cbx_Kk);
        Ks = (CheckBox) findViewById(R.id.Cbx_Ks);
        Kt = (CheckBox) findViewById(R.id.Cbx_Kt);
        Kn = (CheckBox) findViewById(R.id.Cbx_Kn);
        Kh = (CheckBox) findViewById(R.id.Cbx_Kh);
        Km = (CheckBox) findViewById(R.id.Cbx_Km);
        Ky = (CheckBox) findViewById(R.id.Cbx_Ky);
        Kr = (CheckBox) findViewById(R.id.Cbx_Kr);
        Ko = (CheckBox) findViewById(R.id.Cbx_Ko);
        Kg = (CheckBox) findViewById(R.id.Cbx_Kg);
        Kj = (CheckBox) findViewById(R.id.Cbx_Kj);
        Kd = (CheckBox) findViewById(R.id.Cbx_Kd);
        Kb = (CheckBox) findViewById(R.id.Cbx_Kb);
        Kp = (CheckBox) findViewById(R.id.Cbx_Kp);

        btn_Choicehome = (Button) findViewById(R.id.btnChoicehome);
        btn_Choicestart = (Button) findViewById(R.id.btnChostart);
        Radchoice = (RadioGroup) findViewById(R.id.Rad_choice);
        TabHira = (TableLayout) findViewById(R.id.TabHira);
        TabKata = (TableLayout) findViewById(R.id.TabKata);

        btn_Choicehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        btn_Choicestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (WhatChoice == 1)
                {
                    Intent intent = new Intent(getApplicationContext(),HiraganaActivity.class);
                    startActivity(intent);
                }
                else if(WhatChoice == 2)
                {
                    Intent intent = new Intent(getApplicationContext(),KatakanaActivity.class);
                    startActivity(intent);
                }
                else if (WhatChoice == 0)
                {
                    Toast.makeText(getApplicationContext(),"무엇을 공부할지 선택하세요",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Radchoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i==R.id.Rad_Hira)
                {
                    TabHira.setVisibility(View.VISIBLE);
                    TabKata.setVisibility(View.GONE);
                    WhatChoice = 1;//Hira
                }
                else if (i==R.id.Rad_Kata)
                {
                    TabKata.setVisibility(View.VISIBLE);
                    TabHira.setVisibility(View.GONE);
                    WhatChoice = 2;//Kata
                }
            }
        });
    }

    public String Checked(View v){
        if (Ha.isChecked())

    }
}