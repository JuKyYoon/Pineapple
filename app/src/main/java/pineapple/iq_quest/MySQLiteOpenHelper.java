package pineapple.iq_quest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * The type My sq lite open helper.
 * @author JuKyYoon
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
    public MySQLiteOpenHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // DB를 새로 생성할 때 호출되는 함수
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블 생성
        /* 이름은 MONEYBOOK이고, 자동으로 값이 증가하는 _id 정수형 기본키 컬럼과
        item 문자열 컬럼, price 정수형 컬럼, create_at 문자열 컬럼으로 구성된 테이블을 생성. */
        db.execSQL("CREATE TABLE MONEYBOOK (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age TEXT, iq TEXT);");
    }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Insert.
     * add a data into the datatable
     * @param name the name
     * @param age  the age
     * @param iq   the iq
     */
    public void insert(String name, String age, String iq) {
        SQLiteDatabase db = getWritableDatabase(); //open the database for writing and reading
        db.execSQL("INSERT INTO MONEYBOOK VALUES(null, '" + name + "', " + age + ", '" + iq + "');"); //insert into datatable values
        db.close(); //close the database
    }

    public void update(String name, int iq) {
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("UPDATE MONEYBOOK SET price=" +iq + " WHERE item='" + name + "';");
        db.close();
    }

    /**
     * Delete.
     * delete the specific database
     * @param name the name
     */
    public void delete(String name) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM MONEYBOOK WHERE item='" + name + "';");
        db.close();
    }

    /**
     * Delete all.
     * delete all database
     * @param
     *
     * @return void
     */
    public void deleteAll() {
        SQLiteDatabase db = getWritableDatabase(); //open the database for writing and reading
        db.execSQL("DELETE FROM MONEYBOOK"); //all database is deleted
        db.close(); //close the database
    }

    /**
     * Gets result.
     * all data is printed in the datatable using Cursor
     * @return the result
     */
    public String getResult() {

        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM MONEYBOOK ORDER BY iq desc", null);
        while (cursor.moveToNext()) {
            result += cursor.getString(1)
                    + " | "
                    + cursor.getInt(2)
                    + "살 | IQ = "
                    + cursor.getString(3)
                    + "\n";
        }

        return result;
    }
}

