package pineapple.for_future;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
/**
 * Created by jk on 2016. 11. 16..
 */

public class LoadingActivity extends Activity {
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        try{
            //2초 대기
            Thread.sleep(1000);

        }

        catch(InterruptedException e){
            e.printStackTrace();
        }

        startActivity(new Intent(this,MainMenuActivity.class));
        finish();
    }
}
