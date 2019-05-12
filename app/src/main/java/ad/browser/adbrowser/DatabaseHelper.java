package ad.browser.adbrowser;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ADITYA on 2/2/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    static String dbName ="ADBrowserDatabase";
    static int dbversion = 1;
    int j;

    String createHistoryTable = "CREATE TABLE if not exists \"history\" (\n" +
            "\t`h_id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`time`\tTEXT,\n" +
            "\t`date`\tTEXT,\n" +
            "\t`title`\tTEXT,\n" +
            "\t`url`\tTEXT NOT NULL\n" +
            ")";

    public DatabaseHelper(Context context) {
        super(context, dbName, null, dbversion);

        getWritableDatabase().execSQL(createHistoryTable);
    }

    public void addHistory(ContentValues cv) {
        // for avoiding duplicate data
        String sqlGetHistory ="select * from history";
        int duplicate = 0;
        Cursor cursor = getWritableDatabase().rawQuery(sqlGetHistory,null);
        while(cursor.moveToNext()){
            if(cv.get("time").equals(cursor.getString(cursor.getColumnIndex("time"))) && cv.get("url").equals(cursor.getString(cursor.getColumnIndex("url")))){
                duplicate++;
            }
        }
        cursor.close();
        if (duplicate == 0){
            getWritableDatabase().insert("history","",cv);
        }
    }
    public void deleteHistory(){
        getWritableDatabase().execSQL("delete from "+ "history");
    }

    public ArrayList<History> getHistory(){
        String sqlGetHistory ="select * from history";

        Cursor cursor = getWritableDatabase().rawQuery(sqlGetHistory,null);
        ArrayList<History>hList = new ArrayList<History>();
        while(cursor.moveToNext()){
            History history = new History();
            history.time = cursor.getString(cursor.getColumnIndex("time"));
            history.date = cursor.getString(cursor.getColumnIndex("date"));
            history.title = cursor.getString(cursor.getColumnIndex("title"));
            history.url = cursor.getString(cursor.getColumnIndex("url"));
            hList.add(history);
        }
        cursor.close();
        return hList;
    }

    public ArrayList<String> getUrl(){
        String sqlGetHistory ="select * from history";
        Cursor cursor = getWritableDatabase().rawQuery(sqlGetHistory,null);
        ArrayList<String>uList = new ArrayList<String>();
        while(cursor.moveToNext()){

            // removing "https://www." or similar by only selecting characters after '//'

            String url = cursor.getString(cursor.getColumnIndex("url"));
            int len = url.length();
            char[] url1= url.toCharArray();
            for(  j =0 ; j<len; j++){  //finding the position of '//'
                if(url1[j]=='/'){
                    j=j+1;
                    break;
                }}
            char[] url2 = new char[len-j];
            for(int i=j+1; i<len; i++){
                url2[i-j-1]= url1[i];
            }
            String url3 = new String(url2);
            uList.add(url3);
        }
        return uList;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
