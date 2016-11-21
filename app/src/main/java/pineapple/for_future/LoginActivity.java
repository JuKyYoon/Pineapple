package pineapple.for_future;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static pineapple.for_future.MainMenuActivity.num;

/**
 * Created by jk on 2016. 11. 21..
 */

public class LoginActivity extends Activity{
    static You one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void onClick(View view)
    {
        Intent intent = new Intent(this, Survey1Activity.class);
        EditText input_id = (EditText)findViewById(R.id.id);
        EditText password = (EditText)findViewById(R.id.password);
        String id = input_id.getText().toString();
        String pr = password.getText().toString();
        switch (view.getId())
        {
            case R.id.login:
                one = new You(id,20,num++);

//                intent.putExtra("value", id);  //key, data
//                intent.putExtra("pr", pr);
                finish();
                startActivity(intent);
                break;

        }
    }
}
