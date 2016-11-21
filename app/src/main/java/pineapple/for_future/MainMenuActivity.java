package pineapple.for_future;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity {
    static int num = 0;
    private long lastTimeBackPressed; //마지막으로 종료버튼을 누른 시간


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

    }

    @Override
    public void onBackPressed(){

        if(System.currentTimeMillis() - lastTimeBackPressed < 1500){
            finish();
            return ;
        }
        Toast.makeText(this,"뒤로 / 종료 버튼을 한번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT).show();
        lastTimeBackPressed = System.currentTimeMillis();
    }

    public void onClick(View view){
        Intent intent = new Intent(this, LoginActivity.class);


        switch (view.getId()){
            case R.id.exit_button:
                finish();
                break;
            case R.id.start:
                startActivity(intent);
                break;
        }
    }

}
