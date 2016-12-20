/**
 * 2016-12-20
 * 어플의 1번째 문제 엑티비티
 * @author Pineapple
 * @version 1.0
 */

package pineapple.iq_quest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Chronometer;

import pineapple.for_future.R;

import static pineapple.iq_quest.LoginActivity.one;

public class Survey1Activity extends Activity{

    Chronometer chron; //chron 선언
    public static long time = 0; //계속 레이아웃 당 시간을 더해갈 time 변수 선언

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey1);

        chron = (Chronometer) findViewById(R.id.chron); //
        chron.setBase(SystemClock.elapsedRealtime());   //chron의 시간을 지정해주고 시간 측정 시작
        chron.start();                                  //
    }

    public void onClick(View view){
//        Intent intent = new Intent(getApplicationContext(), Survey2Activity.class);
//        startActivity(intent);
        long current = SystemClock.elapsedRealtime() - chron.getBase(); //정답을 누르는 버튼을 눌렀을 떄, 시간을 기록
        time += current / 1000; //나노초 단위이기 때문에 1000을 나눠 초 단위로 만들어주고 time에 기록을 쌓아나감
        chron.stop();

        finish();
        CheckBox answer_1_2 = (CheckBox) findViewById(R.id.answer_1_2);
        //option1.isChecked() 는 리턴값이 불

        if(answer_1_2.isChecked()){
            one.setOk(1);
        }
        else{
            one.setNo(1);
        }
        startActivity(new Intent(Survey1Activity.this, Survey2Activity.class));
        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
