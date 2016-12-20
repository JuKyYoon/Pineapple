/**
 * 2016-12-20
 * Third survey activity in the application
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

public class Survey3Activity extends Activity{
    Chronometer chron;  // Chronometer declaration to measure time.

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey3);
        Intent intent = getIntent();

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


    /**
     * On click.
     * The method that will handle the event when the button in the activity is pressed.
     * I will distinguish the wrong answer or the correct answer, and then proceed to the next activity.
     * @param view the view
     */
    public void onClick(View view){
        long current = SystemClock.elapsedRealtime() - chron.getBase();
        time += current / 1000;
        chron.stop();

        finish();
        CheckBox answer_3_3 = (CheckBox) findViewById(R.id.answer_3_3); //Declare the answer 'answer_3_3' CheckBox.

        //The return value of option1.isChecked() is Boolean.
        if(answer_3_3.isChecked()){        //If the correct answer is checked
            LoginActivity.one.setOk(1);
        }
        else{                              //If the wrong answer is checked
            LoginActivity.one.setNo(1);
        }
        //From Survey3, go to Survey4.
        startActivity(new Intent(Survey3Activity.this, Survey4Activity.class));
        //Animation effects from left to right
        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);


    }
}
