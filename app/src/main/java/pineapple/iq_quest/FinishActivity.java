package pineapple.iq_quest;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import pineapple.for_future.R;
import pineapple.iq_quest.adapter.CustomAdapter;
import pineapple.iq_quest.data.InfoClass;
import pineapple.iq_quest.database.DbOpenHelper;
import pineapple.iq_quest.util.DLog;

import static android.content.ContentValues.TAG;
import static pineapple.iq_quest.Survey1Activity.time;

/**
 * Created by jk on 2016. 11. 16..
 */

public class FinishActivity extends Activity{

    private pineapple.iq_quest.database.DbOpenHelper mDbOpenHelper;
    private Cursor mCursor;
    private pineapple.iq_quest.data.InfoClass mInfoClass;
    private ArrayList<InfoClass> mInfoArray;
    private pineapple.iq_quest.adapter.CustomAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);


        TextView pr_input_id = (TextView)findViewById(R.id.printname);
        TextView pr_input_age = (TextView)findViewById(R.id.age);
        TextView pr_ok = (TextView)findViewById(R.id.ok);
        TextView pr_no = (TextView)findViewById(R.id.no);
        TextView pr_time = (TextView)findViewById(R.id.timeView);

        pr_input_id.setText(LoginActivity.one.getName());
        pr_input_age.setText(LoginActivity.one.getAge());

        String s1 = String.valueOf(LoginActivity.one.getOk());
        pr_ok.setText(s1);
        String s2 = String.valueOf(LoginActivity.one.getNo());
        pr_no.setText(s2);
        String s3 = String.valueOf(time);
        pr_time.setText(s3);



        making();

    }

    public void onClick(View view){
        Intent intent = new Intent(this, Survey1Activity.class);


        switch (view.getId()){
            case R.id.back:
                finish();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    public void making() {
        // DB Create and Open
        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();


        String name = String.valueOf(LoginActivity.one.getName());
        mDbOpenHelper.insertColumn(name,LoginActivity.one.getAge(),"80");

        mInfoArray = new ArrayList<InfoClass>();

        doWhileCursorToArray();

        for(InfoClass i : mInfoArray){
            DLog.d(TAG, "ID = " + i._id);
            DLog.d(TAG, "name = " + i.name);
            DLog.d(TAG, "old = " + i.old);
            DLog.d(TAG, "email = " + i.email);
        }

        mAdapter = new CustomAdapter(this, mInfoArray);
//        mListView.setAdapter(mAdapter);


    }

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }

    private void doWhileCursorToArray(){

        mCursor = null;
        mCursor = mDbOpenHelper.getAllColumns();
        DLog.e(TAG, "COUNT = " + mCursor.getCount());

        while (mCursor.moveToNext()) {

            mInfoClass = new InfoClass(
                    mCursor.getInt(mCursor.getColumnIndex("_id")),
                    mCursor.getString(mCursor.getColumnIndex("name")),
                    mCursor.getString(mCursor.getColumnIndex("old")),
                    mCursor.getString(mCursor.getColumnIndex("email"))
            );

            mInfoArray.add(mInfoClass);
        }

        mCursor.close();
    }

}

