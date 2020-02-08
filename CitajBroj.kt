package com.example.brojslovima

import android.app.Activity

fun Activity.CitajBroj(broj: Int): String {
    /**Izračunavanje miliona i stotina u muškom rodu
     * osnovni broj treba prikazati kao i ostale kao cijelobrojne Int
     */

    val broj1 : Int
    val broj2 : Int
    val broj3 : Int
    val broj4 : Int
    val broj5 : Int
    val broj6 : Int
    val rijec1 : String
    val rijec2 : String
    val rijec3 : String
    val rijec4 : String

    if (broj > 99) {
        broj1 = broj / 100
    }  else { broj1 = 0 }

    when (broj1) {
        1-> rijec1 = getString(R.string.no_100)
        2-> rijec1 = getString(R.string.no_200)
        3-> rijec1 = getString(R.string.no_300)
        4-> rijec1 = getString(R.string.no_400)
        5-> rijec1 = getString(R.string.no_500)
        6-> rijec1 = getString(R.string.no_600)
        7-> rijec1 = getString(R.string.no_700)
        8-> rijec1 = getString(R.string.no_800)
        9-> rijec1 = getString(R.string.no_900)
        else ->{
            rijec1 = ""}
    }

    broj2 = broj - (broj1 * 100)
    if (broj2 >= 20) {
        broj3 = (broj - (broj1 * 100)) / 10
    }  else { broj3 = 0 }

    when (broj3) {
        1-> rijec2 = ""
        2-> rijec2 = getString(R.string.no_20)
        3-> rijec2 = getString(R.string.no_30)
        4-> rijec2 = getString(R.string.no_40)
        5-> rijec2 = getString(R.string.no_50)
        6-> rijec2 = getString(R.string.no_60)
        7-> rijec2 = getString(R.string.no_70)
        8-> rijec2 = getString(R.string.no_80)
        9-> rijec2 = getString(R.string.no_90)
        else ->{
            rijec2 = ""}
    }

    broj4 = broj2 - (broj3 * 10)
    if (broj2 >= 20) {
        broj5 = broj4
    }  else { broj5 = 0 }
    when (broj5) {
        1-> rijec3 = getString(R.string.no_1)
        2-> rijec3 = getString(R.string.no_2)
        3-> rijec3 = getString(R.string.no_3)
        4-> rijec3 = getString(R.string.no_4)
        5-> rijec3 = getString(R.string.no_5)
        6-> rijec3 = getString(R.string.no_6)
        7-> rijec3 = getString(R.string.no_7)
        8-> rijec3 = getString(R.string.no_8)
        9-> rijec3 = getString(R.string.no_9)
        else ->{
            rijec3 = ""}
    }

    if (broj2 < 20) {
        broj6 = (broj - (broj1 * 100))
    }  else { broj6 = 0 }
    when (broj6) {
        1-> rijec4 = getString(R.string.no_1)
        2-> rijec4 = getString(R.string.no_2)
        3-> rijec4 = getString(R.string.no_3)
        4-> rijec4 = getString(R.string.no_4)
        5-> rijec4 = getString(R.string.no_5)
        6-> rijec4 = getString(R.string.no_6)
        7-> rijec4 = getString(R.string.no_7)
        8-> rijec4 = getString(R.string.no_8)
        9-> rijec4 = getString(R.string.no_9)
        10-> rijec4 = getString(R.string.no_10)
        11-> rijec4 = getString(R.string.no_11)
        12-> rijec4 = getString(R.string.no_12)
        13-> rijec4 = getString(R.string.no_13)
        14-> rijec4 = getString(R.string.no_14)
        15-> rijec4 = getString(R.string.no_15)
        16-> rijec4 = getString(R.string.no_16)
        17-> rijec4 = getString(R.string.no_17)
        18-> rijec4 = getString(R.string.no_18)
        19-> rijec4 = getString(R.string.no_19)
        else ->{
            rijec4 = ""}
    }

    return rijec1 + rijec2 + rijec3 + rijec4

}
