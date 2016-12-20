/**
 * 2016-12-20
 * 5th survey activity in the application
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


/**
 * The type Survey 5 activity.
 */
public class Survey5Activity extends Activity{
    Chronometer chron;  // Chronometer declaration to measure time.

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey5);

        chron = (Chronometer) findViewById(R.id.chron);
        chron.setBase(SystemClock.elapsedRealtime());   //Set the chronometer time.
        chron.start();                                  //Start time measurement.

    }

    /**
     * Method onClick 버튼 클릭 처리
     * @return 정답처리, 다음 엑티비티로 넘어가기
     */

    public void onClick(View view){
//        Intent intent = new Intent(getApplicationContext(), Survey2Activity.class);
//        startActivity(intent);
        long current = SystemClock.elapsedRealtime() - chron.getBase();
        time += current / 1000;
        chron.stop();

        finish();
        CheckBox answer_5_4 = (CheckBox) findViewById(R.id.answer_5_4);
        //option1.isChecked() 는 리턴값이 불

        if(answer_5_4.isChecked()){
            one.setOk(1);
        }
        else{
            one.setNo(1);
        }
        startActivity(new Intent(Survey5Activity.this, Survey6Activity.class));
        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);


    }

    /**
     * onKeyDown.
     * It processes event of special key such as back button or enter button.
     * In this code, when keyCode is back, do nothing and prevent it from going back before you finish the evey survey activity.
     * @return Do nothing when back button is pressed, other keys work normally.
     * @param keyCode
     * @param event
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
