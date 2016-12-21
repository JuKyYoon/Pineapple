/**
 * The type My sq lite open helper.
 *
 * @author JuKyYoon
 */

package pineapple.iq_quest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    /**
     * Instantiates a new My sq lite open helper.
     * db name and version
     * @param context the context
     * @param name    the name
     * @param factory the factory
     * @param version the version
     */

    public MySQLiteOpenHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //make a new datatable
        db.execSQL("CREATE TABLE MONEYBOOK (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age TEXT, iq TEXT);");
    }

    // if version is changed, this method is called
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

    /**
     * Update.
     *
     * @param name the name
     * @param iq   the iq
     */
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

