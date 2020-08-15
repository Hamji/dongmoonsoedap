package com.ap.sameanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import data.GameDataManager;
import data.SettingActivity;

public class InGameActivity extends AppCompatActivity {

    public static Activity ingame;

    GameDataManager data = GameDataManager.getInstance();

    Button checkBtn;

    TextView wordTxt;
    TextView descTxt;

    int currentRound;
    int sequence;
    int suspect;

    String after; // 단어 확인시 나타내는 텍스트
    String before; // 단어 확인 전 나타내는 텍스트

    boolean check;
    boolean end;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);

        SettingActivity set = (SettingActivity)SettingActivity.set;
        if(set != null)
            set.finish();

        ingame = InGameActivity.this;

        // 초기화
        init();

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!check){
                    PrintWord();
                    descTxt.setText(after);
                    if(sequence == data.getPeople())
                        checkBtn.setText("결과 보기");
                    check = true;
                }else if(sequence == data.getPeople()){
                    PrintResult();
                }else{
                    descTxt.setText(before);
                    wordTxt.setText("");
                    check = false;
                    sequence++;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    void PrintWord(){
        if(sequence == suspect){
            wordTxt.setText(data.getMinor());
        }else{
            wordTxt.setText(data.getMajor());
        }

    }

    void PrintResult(){
        if(end){
            Intent intent = new Intent(
                    getApplicationContext(), // 현재 화면의 제어권자
                    MainActivity.class); // 다음 넘어갈 클래스 지정
            startActivity(intent);

        }

        wordTxt.setText("소수 :" + data.getMinor() + "\n" + "다수 :" + data.getMajor());

        end = true;
    }

    void init(){
        checkBtn = (Button) findViewById(R.id.buttonCheck);

        wordTxt = findViewById(R.id.textWord);
        descTxt = findViewById(R.id.textDescription);

        // 라운드, 순번 초기화
        currentRound = 1;
        sequence = 1;

        // 범인 고르기
        Random rnd = new Random();
        suspect = rnd.nextInt(data.getPeople());
        suspect++;

        data.setMajor("우주인");
        data.setMinor("외계인");

        before = "확인 버튼을 눌러 단어를 확인해주세요.";
        after = "단어를 확인 했다면 확인 버튼을 누르고 다음 사람에게 넘겨주세요.";

        check = false;
        end = false;
        descTxt.setText(before);
    }


}
