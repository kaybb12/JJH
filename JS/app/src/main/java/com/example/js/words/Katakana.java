package com.example.js.words;

import java.util.ArrayList;
import java.util.Vector;

public class Katakana {

    public static ArrayList<Voca> katakana = new ArrayList<Voca>();

    public Katakana() {
        if (katakana.size()==0)
            init();
    }

    private static void init()
    {
        //아
        katakana.add(new Voca("아", "ア"));
        katakana.add(new Voca("이", "イ"));
        katakana.add(new Voca("우", "ウ"));
        katakana.add(new Voca("에", "エ"));
        katakana.add(new Voca("오", "オ"));
        //카
        katakana.add(new Voca("카", "カ"));
        katakana.add(new Voca("키", "キ"));
        katakana.add(new Voca("쿠", "ク"));
        katakana.add(new Voca("케", "ケ"));
        katakana.add(new Voca("코", "コ"));
        //사
        katakana.add(new Voca("사", "サ"));
        katakana.add(new Voca("시", "シ"));
        katakana.add(new Voca("스", "ス"));
        katakana.add(new Voca("세", "セ"));
        katakana.add(new Voca("소", "ソ"));
        //타
        katakana.add(new Voca("타", "タ"));
        katakana.add(new Voca("치", "チ"));
        katakana.add(new Voca("츠", "ツ"));
        katakana.add(new Voca("테", "テ"));
        katakana.add(new Voca("토", "ト"));
        //나
        katakana.add(new Voca("나", "ナ"));
        katakana.add(new Voca("니", "ニ"));
        katakana.add(new Voca("누", "ヌ"));
        katakana.add(new Voca("네", "ネ"));
        katakana.add(new Voca("노", "ノ"));
        //하
        katakana.add(new Voca("하", "ハ"));
        katakana.add(new Voca("히", "ヒ"));
        katakana.add(new Voca("후", "フ"));
        katakana.add(new Voca("헤", "ヘ"));
        katakana.add(new Voca("호", "ホ"));
        //마
        katakana.add(new Voca("마", "マ"));
        katakana.add(new Voca("미", "ミ"));
        katakana.add(new Voca("무", "ム"));
        katakana.add(new Voca("메", "メ"));
        katakana.add(new Voca("모", "モ"));
        //야
        katakana.add(new Voca("야", "ヤ"));
        katakana.add(new Voca("야", "ヤ"));
        katakana.add(new Voca("유", "ユ"));
        katakana.add(new Voca("유", "ユ"));
        katakana.add(new Voca("요", "ヨ"));
        //라
        katakana.add(new Voca("라", "ラ"));
        katakana.add(new Voca("리", "リ"));
        katakana.add(new Voca("루", "ル"));
        katakana.add(new Voca("레", "レ"));
        katakana.add(new Voca("로", "ロ"));
        //와
        katakana.add(new Voca("와", "ワ"));
        katakana.add(new Voca("와", "ワ"));
        katakana.add(new Voca("와", "ワ"));
        katakana.add(new Voca("오", "ヲ"));
        katakana.add(new Voca("오", "ヲ"));
        //응
        katakana.add(new Voca("응", "ン"));
        katakana.add(new Voca("응", "ン"));
        katakana.add(new Voca("응", "ン"));
        katakana.add(new Voca("응", "ン"));
        katakana.add(new Voca("응", "ン"));
        //가
        katakana.add(new Voca("가", "ガ"));
        katakana.add(new Voca("기", "ギ"));
        katakana.add(new Voca("구", "グ"));
        katakana.add(new Voca("게", "ゲ"));
        katakana.add(new Voca("고", "ゴ"));
        //자
        katakana.add(new Voca("자", "ザ"));
        katakana.add(new Voca("지", "ジ"));
        katakana.add(new Voca("즈", "ズ"));
        katakana.add(new Voca("제", "ゼ"));
        katakana.add(new Voca("조", "ゾ"));
        //다
        katakana.add(new Voca("다", "ダ"));
        katakana.add(new Voca("다", "ダ"));
        katakana.add(new Voca("데", "デ"));
        katakana.add(new Voca("데", "デ"));
        katakana.add(new Voca("도", "ド"));
        //바
        katakana.add(new Voca("바", "バ"));
        katakana.add(new Voca("비", "ビ"));
        katakana.add(new Voca("부", "ブ"));
        katakana.add(new Voca("베", "ベ"));
        katakana.add(new Voca("보", "ボ"));
        //파
        katakana.add(new Voca("파", "パ"));
        katakana.add(new Voca("피", "ピ"));
        katakana.add(new Voca("푸", "プ"));
        katakana.add(new Voca("페", "ペ"));
        katakana.add(new Voca("포", "ポ"));
    }

    static public Voca getVoca(int idx){
        if (katakana.size()==0)
            init();
        return katakana.get(idx);
    }
}
