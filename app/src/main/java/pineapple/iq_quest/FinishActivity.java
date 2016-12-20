/**
 * 2016-12-20
 * Result activity of application
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

        int iq = 110 + LoginActivity.one.getOk() - ((int)time % 10);    //Formula for finding the iq we created.

        String s5 = new String(" ");                    //Declare a string that represents the percentage.
        if (iq < 55) { s5 = "Not Human Being";}         //The percentage varies according to iq.
        else if (55 <=iq && iq < 70) { s5 = "0% - 2.3%";}
        else if (70 <=iq && iq < 85) { s5 = "2.3% - 15.9";}
        else if (85 <=iq && iq < 100) { s5 = "15.9 - 50%";}
        else if (100 <=iq && iq < 115) { s5 = "50% - 84.1%";}
        else if (115 <=iq && iq < 130) { s5 = "84.1% - 97.7%";}
        else if (130 <=iq && iq < 145) { s5 = "97.7% - 99.8%";}
        else if (145 <=iq) { s5 = "99.8 - ";}


        TextView pr_pc = (TextView)findViewById(R.id.percent); //Declare a TextView that represents a percentage.
        TextView pr_iq = (TextView)findViewById(R.id.iq);      //Declare a TextView that represents IQ.

        String s4 = String.valueOf(iq); //Converts 'iq' to a string.
        pr_iq.setText(s4);              //Set the 'string iq(pr_iq)' in textview.
        pr_pc.setText(s5);              //Set the 'string percent(pr_pc)' in textview.

        String name = LoginActivity.one.getName();
        String iqtext = String.valueOf(iq);
        String age = LoginActivity.one.getAge();

        MainMenuActivity.helper.insert(name,age,iqtext);




    }


    /**
     * On click.
     *
     * @param view the view
     */
    public void onClick(View view){
        Intent intent = new Intent(this, Survey1Activity.class);
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
        }
    }






}

