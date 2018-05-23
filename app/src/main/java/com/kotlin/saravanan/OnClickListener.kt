package com.kotlin.saravanan

import android.util.Log

interface OnClickListener {
    fun callClickData(value: String)

    var clickValue: String

    fun onClick(data: String) {
        clickValue = data
        Log.v("onClick", data)
    }

}