package pineapple.for_future;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
        Intent intent = new Intent(getApplicationContext(), Survey2Activity.class);
        startActivity(intent);
        startActivity(new Intent(Survey2Activity.this, Survey3Activity.class));
        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);

    }
}
