package data;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ap.sameanswer.InGameActivity;
import com.ap.sameanswer.R;

public class SettingActivity extends AppCompatActivity {

    public static Activity set;

    Button peoplePlusBtn;
    Button peopleMinusBtn;

    Button startBtn;

    TextView peopleText;
    TextView roundText;

    GameDataManager data = GameDataManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        set = SettingActivity.this;

        peopleMinusBtn = (Button) findViewById(R.id.peopleMinusBtn);
        peoplePlusBtn = (Button) findViewById(R.id.peoplePlusBtn);


        startBtn = (Button) findViewById(R.id.completeSetBtn);

        peopleText = findViewById(R.id.peopleNumberText);

        peopleText.setText(Integer.toString(data.getPeople()));

        peopleMinusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 숫자 범위 2 ~ 5
                int temp = data.getPeople();
                if(data.getPeople() > 2){
                    temp--;
                    data.setPeople(temp);
                }
                peopleText.setText(Integer.toString(data.getPeople()));
            }
        });

        peoplePlusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 숫자 범위 2 ~ 5
                int temp = data.getPeople();
                if(data.getPeople() < 5){
                    temp++;
                    data.setPeople(temp);
                }
                peopleText.setText(Integer.toString(data.getPeople()));
            }
        });



        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 게임 시작
                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        InGameActivity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent);

            }
        });
    }
}
