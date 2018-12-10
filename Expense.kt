package com.example.arocha2.kotlin.feature

import java.io.Serializable

class Expense(var value: Double, var desc: String ) : Serializable {

    override fun toString(): String {
        return desc
    }
}