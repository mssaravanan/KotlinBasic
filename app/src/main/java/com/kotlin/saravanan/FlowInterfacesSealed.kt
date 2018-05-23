package com.kotlin.saravanan

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.flow_interfaces_sealed.*

class FlowInterfacesSealed : AppCompatActivity(), OnClickListener, View.OnClickListener // implement the the interface's
{

    var context: Context? = null

    var dataList: ArrayList<DataClass> = ArrayList()

    //Interface override methods
    override var clickValue: String
        get() = toString()
        set(value) {
            calledFromInterface(value)
        }

    override fun callClickData(value: String) {

        Log.v("CallBack", value)
    }

    //Initialized the Interface
    val onClickListener: OnClickListener = this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flow_interfaces_sealed)
        context = this@FlowInterfacesSealed
        buttonBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })
        buttonInterface.setOnClickListener(View.OnClickListener {
            onClickListener.callClickData("Hello Kotlin")
            onClickListener.onClick("Welcome To Kotlin")
        })
        buttonAddData1.setOnClickListener(this)
        buttonAddData2.setOnClickListener(this)
        buttonAddData3.setOnClickListener(this)
        buttonDisplay.setOnClickListener(this)
    }

    fun calledFromInterface(value: Any) {

        Log.v("InterfaceVariable", value.toString());
    }


    override fun onResume() {
        super.onResume()
    }

    override fun onClick(p0: View?) {

        when (p0!!.id) {
            R.id.buttonAddData1 -> dataList.add(DataClass("NameData1", 20))
            R.id.buttonAddData2 -> dataList.add(DataClass("NameData2", 22))
            R.id.buttonAddData3 -> dataList.add(DataClass("NameData3", 23))
            R.id.buttonDisplay -> {


                for (i in 0..dataList.size - 1) {
                    println(dataList.get(i).name)
                }

                for (dataClass: DataClass in dataList) {

                    if (dataClass.age > 20 && dataClass.age < 23) {
                        Toast.makeText(this, dataClass.name, Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, dataClass.name, Toast.LENGTH_LONG).show()
                    }
                }
            }
            else -> {
                dataList.add(DataClass("Default", 26))
            }
        }
    }
}