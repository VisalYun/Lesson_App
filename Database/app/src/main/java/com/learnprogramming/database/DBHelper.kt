package com.learnprogramming.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):SQLiteOpenHelper(context, "myDB", null, 1) {
    val COL1 = "city"
    val COL2 = "sname"
    val DB_NAME = "mydb"
    val TABLE_NAME = "staff"

    lateinit var list: ArrayList<Staff>

    override fun onCreate(p0: SQLiteDatabase?) {
        var create_table = "create table $TABLE_NAME ($COL1 varchar(250), $COL2 varchar(250))"
        p0?.execSQL(create_table)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(dto:Staff):Long{
        var cv = ContentValues()
        cv.put(COL1, dto.city)
        cv.put(COL2, dto.sname)

        var db = this.writableDatabase
        var res = db.insert(TABLE_NAME, null, cv)

        return res
    }

    fun readRecord():ArrayList<Staff>{
        var temp = Staff("","")
        var db = this.readableDatabase
        var cursor = db.rawQuery("SELECT * FROM staff",null)
        if(cursor.moveToFirst() || cursor!=null){
            do{
                var city = cursor.getString(0)
                var name = cursor.getString(1)
                temp.city = city
                temp.sname = name
                list.add(temp)
            }while (cursor.moveToNext())
        }
        return list
    }
}