package com.example.js.words;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap;
import java.util.Vector;

public class Hiragana {
    public static Vector<Voca> hiragana = new Vector<Voca>();

    public Hiragana() {
        //아
        hiragana.add(new Voca("아", "あ"));
        hiragana.add(new Voca("이", "い"));
        hiragana.add(new Voca("우", "う"));
        hiragana.add(new Voca("에", "え"));
        hiragana.add(new Voca("오", "お"));
        //카
        hiragana.add(new Voca("카", "か"));
        hiragana.add(new Voca("키", "き"));
        hiragana.add(new Voca("쿠", "く"));
        hiragana.add(new Voca("케", "け"));
        hiragana.add(new Voca("코", "こ"));
        //사
        hiragana.add(new Voca("사", "さ"));
        hiragana.add(new Voca("시", "し"));
        hiragana.add(new Voca("스", "す"));
        hiragana.add(new Voca("세", "せ"));
        hiragana.add(new Voca("소", "そ"));
        //타
        hiragana.add(new Voca("타", "た"));
        hiragana.add(new Voca("치", "ち"));
        hiragana.add(new Voca("츠", "つ"));
        hiragana.add(new Voca("테", "て"));
        hiragana.add(new Voca("토", "と"));
        //나
        hiragana.add(new Voca("나", "な"));
        hiragana.add(new Voca("니", "に"));
        hiragana.add(new Voca("누", "ぬ"));
        hiragana.add(new Voca("네", "ね"));
        hiragana.add(new Voca("노", "の"));
        //하
        hiragana.add(new Voca("하", "は"));
        hiragana.add(new Voca("히", "ひ"));
        hiragana.add(new Voca("후", "ふ"));
        hiragana.add(new Voca("헤", "へ"));
        hiragana.add(new Voca("호", "ほ"));
        //마
        hiragana.add(new Voca("마", "ま"));
        hiragana.add(new Voca("미", "み"));
        hiragana.add(new Voca("무", "む"));
        hiragana.add(new Voca("메", "め"));
        hiragana.add(new Voca("모", "も"));
        //야
        hiragana.add(new Voca("야", "や"));
        hiragana.add(new Voca("유", "ゆ"));
        hiragana.add(new Voca("요", "よ"));
        //라
        hiragana.add(new Voca("라", "ら"));
        hiragana.add(new Voca("리", "り"));
        hiragana.add(new Voca("루", "る"));
        hiragana.add(new Voca("레", "れ"));
        hiragana.add(new Voca("로", "ろ"));
        //와
        hiragana.add(new Voca("와", "わ"));
        hiragana.add(new Voca("오", "を"));
        //응
        hiragana.add(new Voca("응", "ん"));
        //가
        hiragana.add(new Voca("가", "が"));
        hiragana.add(new Voca("기", "ぎ"));
        hiragana.add(new Voca("구", "ぐ"));
        hiragana.add(new Voca("게", "げ"));
        hiragana.add(new Voca("고", "ご"));
        //자
        hiragana.add(new Voca("자", "ざ"));
        hiragana.add(new Voca("지", "じ"));
        hiragana.add(new Voca("즈", "ず"));
        hiragana.add(new Voca("제", "ぜ"));
        hiragana.add(new Voca("조", "ぞ"));
        //다
        hiragana.add(new Voca("다", "だ"));
        hiragana.add(new Voca("데", "で"));
        hiragana.add(new Voca("도", "ど"));
        //바
        hiragana.add(new Voca("바", "ば"));
        hiragana.add(new Voca("비", "び"));
        hiragana.add(new Voca("부", "ぶ"));
        hiragana.add(new Voca("베", "べ"));
        hiragana.add(new Voca("보", "ぼ"));
        //파
        hiragana.add(new Voca("파", "ぱ"));
        hiragana.add(new Voca("피", "ぴ"));
        hiragana.add(new Voca("푸", "ぷ"));
        hiragana.add(new Voca("페", "ぺ"));
        hiragana.add(new Voca("포", "ぽ"));
    }
}