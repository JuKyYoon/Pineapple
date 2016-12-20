/**
 * 2016-12-20
 * 6th survey activity in the application
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

/**
 * The type Survey 6 activity.
 */
public class Survey6Activity extends Activity{
    Chronometer chron;  // Chronometer declaration to measure time.

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey6);

        chron = (Chronometer) findViewById(R.id.chron);
        chron.setBase(SystemClock.elapsedRealtime());   //Set the chronometer time.
        chron.start();                                  //Start time measurement.
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

    public void onClick(View view){
        long current = SystemClock.elapsedRealtime() - chron.getBase();
        time += current / 1000;
        chron.stop();

        finish();
        CheckBox answer_6_3 = (CheckBox) findViewById(R.id.answer_6_3);
        //option1.isChecked() 는 리턴값이 불

        if(answer_6_3.isChecked()){
            LoginActivity.one.setOk(1);
        }
        else{
            LoginActivity.one.setNo(1);
        }
        startActivity(new Intent(Survey6Activity.this,Survey7Activity.class));
        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);


    }
}
