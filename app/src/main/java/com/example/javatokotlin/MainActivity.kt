package com.example.javatokotlin

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import com.example.javatokotlin.extention.getColorCompat
import com.example.javatokotlin.extention.toast
import kotlinx.android.synthetic.main.activity_main.*

import java.util.Random

class MainActivity : AppCompatActivity() {

    companion object {
        const val FIRST_RANGE_COUNTER = "first_range_counter"
        const val SECOND_RANGE_COUNTER = "second_range_counter"
        const val THIRD_RANGE_COUNTER = "third_range_counter"
        const val FOURTH_RANGE_COUNTER = "fourth_range_counter"
        const val FIFTH_RANGE_COUNTER = "fifth_range_counter"
        const val OTHER_COUNTER = "other_counter"
    }

    private val defaultNumber: String by lazy { randomInt(50).toString() }
    private lateinit var sharePreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharePreference = PreferenceManager.getDefaultSharedPreferences(this)
        initUi()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_stat, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.stat_screen) {
            navigateToSecondActivity()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun navigateToSecondActivity() {
        startActivity(Intent(this, SecondActivity::class.java))
    }

    private fun initUi() {
        numberTextView.text = defaultNumber
        updateBackgroundColor(defaultNumber.toInt())
        resetButton.setOnClickListener {
            numberTextView.text = defaultNumber
            updateBackgroundColor(defaultNumber.toInt())
        }
        countButton.setOnClickListener { countMe(numberTextView) }
        randomButton.setOnClickListener {
            val randomInt = randomInt(50)
            numberTextView.text = randomInt.toString()
            updateBackgroundColor(randomInt)
        }
    }

    private fun randomInt(maximum: Int) = Random().nextInt(maximum) + 1

    private fun countMe(textView: TextView) {
        val countString = textView.text.toString()
        var count: Int = Integer.parseInt(countString)
        count++
        updateBackgroundColor(count)
        textView.text = count.toString()
        toast("before : $countString")
    }

    private fun updateBackgroundColor(number: Int) {
        constraintLayout.setBackgroundColor(when (number) {
            in 1..10 -> {
                increaseCounter(FIRST_RANGE_COUNTER)
                getColorCompat(android.R.color.holo_red_dark)
            }
            in 11..20 -> {
                increaseCounter(SECOND_RANGE_COUNTER)
                getColorCompat(android.R.color.holo_green_dark)
            }
            in 21..30 -> {
                increaseCounter(THIRD_RANGE_COUNTER)
                getColorCompat(android.R.color.holo_blue_dark)
            }
            in 31..40 -> {
                increaseCounter(FOURTH_RANGE_COUNTER)
                getColorCompat(android.R.color.holo_orange_dark)
            }
            in 41..50 -> {
                increaseCounter(FIFTH_RANGE_COUNTER)
                getColorCompat(android.R.color.holo_purple)
            }
            else -> {
                increaseCounter(OTHER_COUNTER)
                getColorCompat(android.R.color.black)
            }
        })
    }

    private fun increaseCounter(key: String) {
        with(sharePreference) {
            var counter = getInt(key, 0)
            counter++
            edit().putInt(key, counter).apply()
        }

    }
}