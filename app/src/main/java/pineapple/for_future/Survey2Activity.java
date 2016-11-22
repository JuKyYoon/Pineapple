package pineapple.for_future;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;

import static pineapple.for_future.LoginActivity.one;
import static pineapple.for_future.R.id.answer_1_2;

/**
 * Created by jk on 2016. 11. 16..
 */

public class Survey2Activity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey2);
        Intent intent = getIntent();

    }

    public void onClick(View view){
//        Intent intent = new Intent(getApplicationContext(), Survey2Activity.class);
//        startActivity(intent);
        finish();
        CheckBox answer_2_4 = (CheckBox) findViewById(R.id.answer_2_4);
        //option1.isChecked() 는 리턴값이 불

        if(answer_2_4.isChecked()){
            one.setOk(1);
        }
        else{
            one.setNo(1);
        }
        startActivity(new Intent(Survey2Activity.this, Survey3Activity.class));
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
