/**
 * 2016-12-20
 * 어플의 메인메뉴 엑티비티
 * @author Pineapple
 * @version 1.0
 */

package pineapple.iq_quest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import pineapple.for_future.R;

public class MainMenuActivity extends AppCompatActivity {
    static int num = 0;
    private long lastTimeBackPressed = 0; //Last button pressed time
    static MySQLiteOpenHelper helper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        helper = new MySQLiteOpenHelper(MainMenuActivity.this, "person.db", null, 1);
    }

    /**
     * onBackPressed.
     */
    @Override
    public void onBackPressed(){
        //When the back button is pressed and pressed again within 15 seconds
        if(System.currentTimeMillis() - lastTimeBackPressed < 1500){
            finish(); //Application termination
            return ;
        }
        Toast.makeText(this,"뒤로 / 종료 버튼을 한번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT).show();
        lastTimeBackPressed = System.currentTimeMillis();
    }

    /**
     * On click.
     * The method that will handle the event when the button in the activity is pressed.
     * If you press the view button, go to the view activity where the list is saved.
     * If you press the exit button, it will close the app.
     * If you press the start button, go to the first survey activity and start solving the problem.
     * @param view the view
     */
    public void onClick(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        Intent intentview = new Intent(this, ViewData.class);

        switch (view.getId()){
            case R.id.exit_button:
                finish();
                break;

            case R.id.view:
                startActivity(intentview);
                break;

            case R.id.start:
                startActivity(intent);
                break;


        }
    }

}
