package pineapple.for_future;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

/**
 * Created by jk on 2016. 11. 16..
 */

public class Survey1Activity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey1);
        Intent intent = getIntent();

    }

    public void onClick(View view){
        Intent intent = new Intent(getApplicationContext(), Survey2Activity.class);
        startActivity(intent);
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
