package com.example.javatokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private val sharePreference by lazy { PreferenceManager.getDefaultSharedPreferences(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        with(sharePreference) {
            firstRangeTextView.text = getInt(MainActivity.FIRST_RANGE_COUNTER, 0).toString()
            secondRangeTextView.text = getInt(MainActivity.SECOND_RANGE_COUNTER, 0).toString()
            thirdRangeTextView.text = getInt(MainActivity.THIRD_RANGE_COUNTER, 0).toString()
            fourthRangeTextView.text = getInt(MainActivity.FOURTH_RANGE_COUNTER, 0).toString()
            fifthRangeTextView.text = getInt(MainActivity.FIFTH_RANGE_COUNTER, 0).toString()
            otherRangeTextView.text = getInt(MainActivity.OTHER_COUNTER, 0).toString()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
