package com.example.arocha2.kotlin.feature

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.support.design.widget.Snackbar
import android.widget.Toast


class DBHelper(val context: Context?) :
SQLiteOpenHelper(context, "APPEX", null, 1) {
init {
    Toast.makeText(context, "Criado", Toast.LENGTH_LONG).show()
}
    val TABLE_NAME: String = "Expense"
    val Col1: String = "Description"
    var Col2: String = "Value"

    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE $TABLE_NAME (ID INTENGER AUTOINCREMENT PRIMARY KEY, $Col1 TEXT )")


    }

    override fun onUpgrade( db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP IF TABLE EXISTS $TABLE_NAME")
        onCreate(db)
    }


    fun addData(expense: Expense) {
       var db: SQLiteDatabase = this.writableDatabase
        var content: ContentValues = ContentValues()
        content.put(Col1, expense.desc)
        val result: Long = db.insert(TABLE_NAME, null, content)

        if (result.equals(-1)) {
            Toast.makeText(context, "Fail", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Adicionado", Toast.LENGTH_LONG).show()
        }
    }
}