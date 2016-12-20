/**
 * 2016-12-20
 * 어플의 결과 엑티비티
 * @author Pineapple
 * @version 1.0
 */

package pineapple.iq_quest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import pineapple.for_future.R;

import static pineapple.iq_quest.Survey1Activity.time;

public class FinishActivity extends Activity{


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        int iq = 0;
        iq = 110 + LoginActivity.one.getOk() - ((int)time % 10);

        String s5 = new String(" ");
        if (iq < 55) { s5 = "Not Human Being";}
        if (55 <=iq && iq < 70) { s5 = "0% - 2.3%";}
        if (70 <=iq && iq < 85) { s5 = "2.3% - 15.9";}
        if (85 <=iq && iq < 100) { s5 = "15.9 - 50%";}
        if (100 <=iq && iq < 115) { s5 = "50% - 84.1%";}
        if (115 <=iq && iq < 130) { s5 = "84.1% - 97.7%";}
        if (130 <=iq && iq < 145) { s5 = "97.7% - 99.8%";}
        if (145 <=iq) { s5 = "99.8 - ";}

        //TextView pr_input_id = (TextView)findViewById(R.id.printname);
        //TextView pr_input_age = (TextView)findViewById(R.id.age);
        //TextView pr_ok = (TextView)findViewById(R.id.ok);
        //TextView pr_no = (TextView)findViewById(R.id.no);
        //TextView pr_time = (TextView)findViewById(R.id.timeView);
        TextView pr_pc = (TextView)findViewById(R.id.percent);

        //pr_input_id.setText(LoginActivity.one.getName());
        //pr_input_age.setText(LoginActivity.one.getAge());

        TextView pr_iq = (TextView)findViewById(R.id.iq);

        //String s1 = String.valueOf(LoginActivity.one.getOk());
        //pr_ok.setText(s1);
        //String s2 = String.valueOf(LoginActivity.one.getNo());
        //pr_no.setText(s2);
        //String s3 = String.valueOf(time);
        //pr_time.setText(s3);
        String s4 = String.valueOf(iq);
        pr_iq.setText(s4);
        pr_pc.setText(s5);

        String name = LoginActivity.one.getName();
        String iqtext = String.valueOf(iq);
        String age = LoginActivity.one.getAge();

        MainMenuActivity.helper.insert(name,age,iqtext);




    }


    public void onClick(View view){
        Intent intent = new Intent(this, Survey1Activity.class);
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
        }
    }






}

