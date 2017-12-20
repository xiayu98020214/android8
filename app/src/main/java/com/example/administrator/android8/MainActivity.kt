package com.example.administrator.android8

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.layoutManager = LinearLayoutManager(this)
        val datalist = ArrayList<String>()
        datalist.add("画中画")
        datalist.add("pin")
        val adapter = MainAdapter(datalist)
        list.adapter = adapter
    }
}
