package pineapple.iq_quest.activity;

/**
 * Created by jk on 2016. 11. 29..
 */

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import pineapple.for_future.R;
import pineapple.iq_quest.data.InfoClass;

import static android.content.ContentValues.TAG;


public class ViewData extends Activity {


    private pineapple.iq_quest.database.DbOpenHelper mDbOpenHelper;
    private Cursor mCursor;
    private pineapple.iq_quest.data.InfoClass mInfoClass;
    private ArrayList<InfoClass> mInfoArray;
    private pineapple.iq_quest.adapter.CustomAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setLayout();

        // DB Create and Open
        mDbOpenHelper = new pineapple.iq_quest.database.DbOpenHelper(this);
        mDbOpenHelper.open();




        mInfoArray = new ArrayList<InfoClass>();

        doWhileCursorToArray();

        for(pineapple.iq_quest.data.InfoClass i : mInfoArray){
            pineapple.iq_quest.util.DLog.d(TAG, "ID = " + i._id);
            pineapple.iq_quest.util.DLog.d(TAG, "name = " + i.name);
            pineapple.iq_quest.util.DLog.d(TAG, "old = " + i.old);
            pineapple.iq_quest.util.DLog.d(TAG, "email = " + i.email);
        }

        mAdapter = new pineapple.iq_quest.adapter.CustomAdapter(this, mInfoArray);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemLongClickListener(longClickListener);

    }

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }


    /**
     * ListView의 Item을 롱클릭 할때 호출 ( 선택한 아이템의 DB 컬럼과 Data를 삭제 한다. )
     */
    private AdapterView.OnItemLongClickListener longClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                       int position, long arg3) {

            pineapple.iq_quest.util.DLog.e(TAG, "position = " + position);

            boolean result = mDbOpenHelper.deleteColumn(position + 1);
            pineapple.iq_quest.util.DLog.e(TAG, "result = " + result);

            if(result){
                mInfoArray.remove(position);
                mAdapter.setArrayList(mInfoArray);
                mAdapter.notifyDataSetChanged();
            }else {
                Toast.makeText(getApplicationContext(), "INDEX를 확인해 주세요.",
                        Toast.LENGTH_LONG).show();
            }

            return false;
        }
    };


    /**
     * DB에서 받아온 값을 ArrayList에 Add
     */
    private void doWhileCursorToArray(){

        mCursor = null;
        mCursor = mDbOpenHelper.getAllColumns();
        pineapple.iq_quest.util.DLog.e(TAG, "COUNT = " + mCursor.getCount());

        while (mCursor.moveToNext()) {

            mInfoClass = new pineapple.iq_quest.data.InfoClass(
                    mCursor.getInt(mCursor.getColumnIndex("_id")),
                    mCursor.getString(mCursor.getColumnIndex("name")),
                    mCursor.getString(mCursor.getColumnIndex("old")),
                    mCursor.getString(mCursor.getColumnIndex("email"))
            );

            mInfoArray.add(mInfoClass);
        }

        mCursor.close();
    }


    /**
     * OnClick Button
     * @param v
     */
//    public void onClick(View v){
//        switch (v.getId()) {
//            case R.id.btn_add:
//                mDbOpenHelper.insertColumn
//                        (
//                                mEditTexts[pineapple.iq_quest.conf.Constants.NAME].getText().toString().trim(),
//                                mEditTexts[pineapple.iq_quest.conf.Constants.CONTACT].getText().toString().trim(),
//                                mEditTexts[pineapple.iq_quest.conf.Constants.EMAIL].getText().toString().trim()
//                        );
//
//                mInfoArray.clear();
//
//                doWhileCursorToArray();
//
//                mAdapter.setArrayList(mInfoArray);
//                mAdapter.notifyDataSetChanged();
//
//                mCursor.close();
//
//                break;
//
//            default:
//                break;
//        }
//    }

    /*
     * Layout
     */
    private EditText[] mEditTexts;
    private ListView mListView;
//
    private void setLayout(){
        mEditTexts = new EditText[]{
//                (EditText)findViewById(R.id.et_name),
//                (EditText)findViewById(R.id.et_contact),
//                (EditText)findViewById(R.id.et_email)
        };

        mListView = (ListView) findViewById(R.id.lv_list);
    }
}




