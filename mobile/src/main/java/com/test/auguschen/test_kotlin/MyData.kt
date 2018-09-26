package com.test.auguschen.test_kotlin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


class MyData(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {
    val SQL = "CREATE TABLE " + "time_data " + "( "+
            "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
            "name VARCHAR(200) NOT NULL,"+
            "start_time INTEGER NOT NULL,"+
            "end_time INTEGER NOT NULL,"+
            "weeks VARCHAR(200) NOT NULL,"+
            "model INTEGER NOT NULL"+
            " ) ";


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + "time_data")
        onCreate(db)
    }

    companion object {
        // 資料庫名稱
        val DATABASE_NAME = "mydata.db"
        // 資料庫版本，資料結構改變的時候要更改這個數字，通常是加一
        val VERSION = 1

        // 需要資料庫的元件呼叫這個函式，這個函式在一般的應用都不需要修改
        fun getDatabase(context: Context): SQLiteDatabase {

            return MyData(context, DATABASE_NAME, null, VERSION).writableDatabase
        }

        fun Insertdate(context:Context, database: SQLiteDatabase, name:String, start_time:Int, end_time:Int, weeks:String, model:Int):Boolean{
            var data:ContentValues = ContentValues() ;

            data.put("name", name)
            data.put("start_time", start_time)
            data.put("end_time", end_time)
            data.put("weeks", weeks)
            data.put("model", model)
            try {
                InsertAction(context, database, data)
                return true
            }catch (e:Exception){
                Log.e("data insert error", e.toString())
                return false
            }
        }

        fun InsertAction(context:Context, database: SQLiteDatabase, value:ContentValues){
            database.insert(context.getString(R.string.TABLE_NAME ),null,value)
        }

        fun selectALLData(db:SQLiteDatabase):Cursor{
            val data = db.rawQuery("select * from time_data",null)
            data.moveToFirst()
            /*while(!data.isAfterLast()) {
                Log.e("data",data.getString(data.getColumnIndex("name")))
                data.moveToNext()
            }*/
            return data
        }

        fun selectDataFromId(db:SQLiteDatabase, id: Int){
            val data = db.rawQuery("select * from time_data where id = "+ id,null)
            data.moveToFirst()
            while(!data.isAfterLast()) {
                Log.e("data22",data.getString(data.getColumnIndex("name")))
                data.moveToNext()
            }

        }

    }

}