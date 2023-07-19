package com.example.androidappkiarash

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlin.properties.Delegates
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var textView: TextView

    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button2)
        textView = findViewById(R.id.textView)
        button.text = "Click Me"
    }

    fun onButtonClicked(v: View) {
        val color = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
        number = Random.nextInt(1..1000)
        textView.setTextColor(color)
        textView.text = number.toString()
        textView.alpha = Random.nextFloat()

        val animation = AnimationUtils.loadAnimation(this, R.anim.button_animation)
        textView.startAnimation(animation)

        Log.println(Log.INFO,"", "clicked")
    }
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(numberKey, number)
        super.onSaveInstanceState(outState)
    }
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {

        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        number = savedInstanceState.getInt(numberKey)
        if (number != 0) {
            textView.text = number.toString()
        } else {
            textView.text = "Click Me"
        }
    }

    companion object {
        val numberKey = "RandomNumber"
    }
}