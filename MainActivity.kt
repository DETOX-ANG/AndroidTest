package com.example.arocha2.kotlin.feature

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    var arrayList: ArrayList<Expense> = arrayListOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val db: DBHelper = DBHelper(this)

     // arrayList.add(Expense(20.00, "Ifood"))
     // arrayList.add(Expense(500.00, "Uber"))

        val arrayAdapter = ArrayAdapter<Expense>(this, android.R.layout.simple_list_item_1,arrayList)
        listview.adapter = arrayAdapter
        var bundle: Bundle = Bundle()



        listview.setOnItemClickListener { parent, view, position, id ->
            var intent = Intent(this, ExDetail::class.java)
            bundle.putSerializable("EX",arrayList.get(position))
            intent.putExtras(bundle)
            startActivity(intent)

        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        //db.addData(Expense(1.0,"Teste"))
            var intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
