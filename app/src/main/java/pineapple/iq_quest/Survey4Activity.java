/**
 * 2016-12-20
 * 어플의 4번째 문제 엑티비티
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
import static pineapple.iq_quest.Survey1Activity.time;


public class Survey4Activity extends Activity{
    Chronometer chron;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey4);

        chron = (Chronometer) findViewById(R.id.chron);
        chron.setBase(SystemClock.elapsedRealtime());
        chron.start();

    }

    /**
     * On click.
     *
     * @param view the view
     */
    public void onClick(View view){
//        Intent intent = new Intent(getApplicationContext(), Survey2Activity.class);
//        startActivity(intent);
        long current = SystemClock.elapsedRealtime() - chron.getBase();
        time += current / 1000;
        chron.stop();

        finish();
        CheckBox answer_4_3 = (CheckBox) findViewById(R.id.answer_4_3);
        //option1.isChecked() 는 리턴값이 불

        if(answer_4_3.isChecked()){
            one.setOk(1);
        }
        else{
            one.setNo(1);
        }
        startActivity(new Intent(Survey4Activity.this, Survey5Activity.class));
        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);


    }

    /**
     * Method onKeyDown 키 처리
     * @return 백버튼을 눌렀을 때, 아무것도 하지 않음
     */

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
