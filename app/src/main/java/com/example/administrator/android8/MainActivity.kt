package com.example.administrator.android8

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.administrator.android8.Pip.PipActivity
import com.example.administrator.android8.Pip.TestPIPActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.layoutManager = LinearLayoutManager(this)
        val datalist = ArrayList<ProgramItemData>()
        datalist.add(ProgramItemData("画中画", TestPIPActivity::class.java))

        val adapter = MainAdapter(datalist,this)
        list.adapter = adapter
    }
}
