package pineapple.iq_quest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import pineapple.for_future.R;


/**
 * The type View data.
 * @author JuKyung
 */
public class ViewData extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_lanking);
        MySQLiteOpenHelper dbHelper = MainMenuActivity.helper;

        TextView result_text = (TextView)findViewById(R.id.result);
        result_text.setText(dbHelper.getResult());

    }

    /**
     * On click.
     *
     * @param view the view
     * @return void
     */
    public void onClick(View view){
        switch (view.getId()){
            case R.id.backtomain:
                finish();
                break;
            case R.id.delete:
                MySQLiteOpenHelper dbHelper = MainMenuActivity.helper;
                dbHelper.deleteAll();
                TextView result_text = (TextView)findViewById(R.id.result);
                result_text.setText(dbHelper.getResult());
                break;
        }
    }

}
