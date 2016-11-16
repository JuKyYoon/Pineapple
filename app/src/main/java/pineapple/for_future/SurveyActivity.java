package pineapple.for_future;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by jk on 2016. 11. 16..
 */

public class SurveyActivity extends Activity{
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_survey);
        Intent intent = getIntent();

    }

    public void onClick(View view){

        switch (view.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
}
