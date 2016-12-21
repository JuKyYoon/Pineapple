/**
 * 2016-11-21
 * 어플의 결과 창
 * @author jk
 * @version 1.0
 */

package pineapple.iq_quest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import pineapple.for_future.R;

import static pineapple.iq_quest.MainMenuActivity.num;

public class LoginActivity extends Activity{
    static You one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    /**
     * On click.
     *
     * @param view the view
     */
    public void onClick(View view)
    {
        Intent intent = new Intent(this, Survey1Activity.class);
        EditText input_id = (EditText)findViewById(R.id.id);
        EditText password = (EditText)findViewById(R.id.age);
        String id = input_id.getText().toString();
        String age = password.getText().toString();

        //Controls the Enter key.
        input_id.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId) {
                    //Next action. After entering the name, press the Enter key to move to the age box.
                    case EditorInfo.IME_ACTION_NEXT:
                        break;
                    default:
                        // Basic Enter key action
                        return false;
                }
                return true;
            }
        });
        //Controls the Enter key.
        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId) {
                    case EditorInfo.IME_ACTION_DONE:
                        //Press the Enter key to end the input.
                        break;
                    default:
                        // Basic Enter key action
                        return false;
                }
                return true;
            }
        });
        //
        switch (view.getId())
        {
            case R.id.login:
                one = new You(id,age,num++);

//                intent.putExtra("value", id);  //key, data
//                intent.putExtra("pr", pr);
                finish();
                startActivity(intent);
                break;

        }
    }
}
