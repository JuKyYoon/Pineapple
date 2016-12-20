/**
 * 2016-12-20
 * 어플의 17번째 문제 엑티비티
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

import static pineapple.iq_quest.Survey1Activity.time;

public class Survey17Activity extends Activity{
    Chronometer chron;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey17);
        Intent intent = getIntent();

        chron = (Chronometer) findViewById(R.id.chron);
        chron.setBase(SystemClock.elapsedRealtime());
        chron.start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onClick(View view){
//        Intent intent = new Intent(getApplicationContext(), Survey2Activity.class);
//        startActivity(intent);
        long current = SystemClock.elapsedRealtime() - chron.getBase();
        time += current / 1000;
        chron.stop();

        finish();
        CheckBox answer_17_3 = (CheckBox) findViewById(R.id.answer_17_3);
        //option1.isChecked() 는 리턴값이 불

        if(answer_17_3.isChecked()){
            LoginActivity.one.setOk(1);
        }
        else{
            LoginActivity.one.setNo(1);
        }
        startActivity(new Intent(Survey17Activity.this,Survey18Activity.class));
        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);


    }
}
